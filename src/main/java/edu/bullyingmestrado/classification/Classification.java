    /*
Load classification model and use it to classify the input.

Input: each line from stdin is treated as a short document.  It is expected that the input
has been filtered by Enrichment.jar to remove lines without bullying keywords.  This program
will still work if no filtering has been done, but may produce warnings to stderr.

Output: The program runs SVM classification and outputs the predicted label.

Warnings: the program is intended to work on "enriched tweets."  It will try to detect whether an
input line is such a tweet.  If not, it produces a warning message for that line.  it will still 
attempt to classify the line.  However, the classification accuracy in the presence of a warning
can not be guaranteed.

To cite the code:

Learning from bullying traces in social media
Jun-Ming Xu, Kwang-Sung Jun, Xiaojin Zhu, and Amy Bellmore
In North American Chapter of the Association for Computational Linguistics - 
Human Language Technologies (NAACL HLT)
Montreal, Canada, 2012

Author: Jun-Ming Xu (xujm@cs.wisc.edu)

Contact: Jun-Ming Xu (xujm@cs.wisc.edu), Xiaojin Zhu (jerryzhu@cs.wisc.edu)
June 2012

 */

package edu.bullyingmestrado.classification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.bullyingmestrado.commons.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Jun-Ming Xu
 * Modified by Pamela Rosales
 */
public class Classification implements Comparable<Classification>{
    
        
        private static final Logger logger = LogManager.getLogger(Classification.class.getName());

        double value;
        String classResult; //label
        String classifierName;
        String pathModel;
	static String[] keywords = {    Constants.KW_IGNORED, Constants.KW_PUSHED ,
                                        Constants.KW_RUMORS , Constants.KW_LOCKER ,
                                        Constants.KW_SPREAD , Constants.KW_SHOVED ,
                                        Constants.KW_RUMOR ,  Constants.KW_TEASED,
                                        Constants.KW_KICKED,  Constants.KW_CRYING,
                                        Constants.KW_BULLYED, Constants.KW_BULLIED,
                                        Constants.KW_BULLYNG, Constants.KW_BULLYER,
                                        Constants.KW_BULLING, Constants.KW_BULLY
                                    };

	static String[] classifier_type = { Constants.CLA_TRACE,        Constants.CLA_TEASING,    
                                            Constants.CLA_AUTHOR_ROLE,  Constants.CLA_FORM     
                                        }; 
	double[][] w;
	double bias;
	int num_features;
	int num_classes;
	static String class_labels[];
        String resultado;
        
        //max and min  values of classes
        static double[][] borders;
        
        public Classification(){
            this.value = 0.0;
        }
        
        public Classification(String classifierName) {
            this.value = 0.0;
            this.classifierName= classifierName.toLowerCase();
            this.pathModel = Constants.PATH_MODELS + this.classifierName;
        }


        public double getValue() {
            return value;
        }
        
        public String getClassResult() {
            return classResult;
        }

        public void setClassResult(String classResult) {
            this.classResult = classResult;
        }
    
        public String getClassifierName() {
            return classifierName;
        }

        public void setClassifierName(String classifierName) {
            this.classifierName = classifierName;
        }
        
        public String getPathModel() {
        return pathModel;
    }

        public void setPathModel(String pathModel) {
            this.pathModel = pathModel;
        }
          

	// Since the model is trained on the enriched data, the test data should be
	// also in the enriched data 'containing keywords'.
	// Otherwise, the performance is not guaranteed.
	public static boolean checkInput(String text) {
		if (text.length() > 150) {
			System.err.println("(Warning: line longer than 150 characters): " + text);
			return false;
		}
		String lowerCase = text.toLowerCase();
		boolean containKeyword = false;
		for (String k : keywords)
			if (lowerCase.contains(k)) {
				containKeyword = true;
				break;
			}
		if (containKeyword == false) {
			System.err.println("(Warning: line does not contain keywords): " + text);
			return false;
		}
		if (!lowerCase.contains("bull")) {
			System.err.println("(Warning: line does not contain string \"bull\"): " + text);
			return false;
		}
		if (text.contains("RT")) {
			System.err.println("(Warning: line contains \"RT\", retweet?): " + text);
			return false;
		}
		return true;
	}

	public boolean loadModel() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				Classification.class.getResourceAsStream(this.pathModel)));
		String line = br.readLine();  // ignore first line

		//@pamela --> Read the number of classes according to the chosen classifier";
		line = br.readLine(); // nr_class
		String[] fields = line.split(Constants.SPACE);
		if (!fields[0].equals(Constants.VCLASIF_NR_CLASS)) {
			return false;
		}
		
                num_classes = Integer.parseInt(fields[1]);                
                borders = new double[num_classes][2];
                
                for(int k = 0; k < num_classes; k++){
                    for(int l = 0; l < 2; l++){
                        borders[k][l] = 0;
                    }
                }
		
                //@pamela --> Read labels of the classes";
		line = br.readLine(); 
		fields = line.split(Constants.SPACE);
		if (!fields[0].equals(Constants.VCLASIF_LABEL) || fields.length < num_classes + 1) {
			return false;
		}
		class_labels = new String[num_classes];
		for (int i = 1; i <= num_classes; i++) {
			class_labels[i-1] = fields[i];

		}
                
                //@pamela --> Read the number of words/features of the vocabulary vocab
		line = br.readLine(); // nr_feature
		fields = line.split(Constants.SPACE);
		if (!fields[0].equals(Constants.VCLASIF_NR_FEATURE)) {
			return false;
		}
		num_features = Integer.parseInt(fields[1]);

                //@pamela --> Read the bias
		line = br.readLine(); // bias
		fields = line.split(Constants.SPACE);
		if (!fields[0].equals(Constants.VCLASIF_BIAS)) {
			return false;
		}
		bias = Double.parseDouble(fields[1]);

                
                //@pamela --> Verifiy if the line is equals to "w" that means weight
		line = br.readLine();
		if (!line.equals(Constants.VCLASIF_WEIGH)) {
			return false;
		}

		int num_weights = num_classes;
		if (num_classes == 2) {
			num_weights = 1;
		} 
                
		//@pamela -->  Create an array w["+ num_weights +"]" + "["+ num_features+"]");
		w = new double[num_weights][num_features];
		
		for (int f = 0; f < num_features; f++) {
			line = br.readLine();
			if (line == null) {
				return false;
			}
			fields = line.split(Constants.SPACE);
			if (fields.length != num_weights)
				return false;
			for (int i = 0; i < num_weights; i++) {
				w[i][f] = Double.parseDouble(fields[i]);
			}
		}
		return true;
	}

	public void classify(Integer[] index, double[] value) {
		String rptaClassificador;
                //@pamela --> Evaluate if the classifier is binary
		if (num_classes == 2) {
			double margin = 0.0;
			for (int i : index) {
				margin += w[0][i] * value[i];
			}
			rptaClassificador = margin > 0 ? class_labels[0] : class_labels[1];
                        this.value = margin;
                        this.classResult = rptaClassificador  + Constants.UNDERLINE + this.classifierName;
                        return;
		}
		

                //@pamela --> Evaluate if the classifier is multiclasses
		double[] margins = new double[num_classes];
		for (int i : index) {
			for (int c = 0; c < num_classes; c++) {
				margins[c] += w[c][i] * value[i]; 
			}
		}
		double max_margin = Double.NEGATIVE_INFINITY;
                
		int idx = -1;
		for (int c = 0; c < num_classes; c++) {
			if (margins[c] > max_margin) {
				max_margin = margins[c];
                                if(margins[c] < borders[c][0]){
                                    borders[c][0] = margins[c];
                                }
                                if(margins[c] > borders[c][1]){
                                    borders[c][1] = margins[c];
                                }
				idx = c;
			}
		}
                
                this.classResult = class_labels[idx];
                this.value = max_margin;

        }
        
        
        @Override
        public int compareTo(Classification c) {
            return (this.classifierName).compareTo(c.getClassifierName());
        }

       
}
