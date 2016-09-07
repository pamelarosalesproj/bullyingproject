/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.fuzzification;

import edu.bullyingmestrado.classification.Classification;
import edu.bullyingmestrado.classification.Tokenizer;
import edu.bullyingmestrado.classification.Tokens2FeatureVector;
import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.entities.Tweet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pamela
 */
public class ReadTweets {
        /**
	 * Inicio do Severity Tool
	 * */
    
        static String[] classifier_type = { Constants.CLA_TRACE,        Constants.CLA_TEASING,    
                                            Constants.CLA_AUTHOR_ROLE,  Constants.CLA_FORM     
                                        }; 
         
        public static void main(String[] args){
            String modeloAUsar = null;
            String line = null;
            String rptaIsBullyingTrace = null;
            String filePath = "C:/Users/pamela/Desktop/archivoOut.txt";		
            String linea1 = "sep=|" + System.getProperty("line.separator");
            boolean primeraLinea = true;
			
            try {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				ReadTweets.class.getResourceAsStream(Constants.PATH_TWEETS_INI)));

                while ((line = br.readLine()) != null) {					
                    /*@pamela --> Don't process line that don't fulfill the requirements of Enrichment*/
                    if (!Classification.checkInput(line) )continue;					
                    
                    /*@pamela --> Use the 1st classifier 'Bullying Trace Classifier' that is a filter*/              
                    Tweet tweet = new Tweet(line);
                    ArrayList<String> tokens;
		    Tokenizer tokenizer = new Tokenizer();
                    Tokens2FeatureVector t2v = new Tokens2FeatureVector();
                    t2v.loadVocab(Constants.PATH_VOCAB);
                    Classification clasifBullyingTrace = new Classification(Constants.CLA_TRACE);
		    clasifBullyingTrace.loadModel();
                    tokens = tokenizer.tokenize(line);
                    t2v.covertFeatureVector(tokens);
                    clasifBullyingTrace.classify(t2v.getIndexSet(), t2v.getValueSet());
                    
                    //REVISAR.. PARA ESCRIBIR CSV
                    if (primeraLinea ){
			//REVISAR escribirResultadoClasificacion(linea1, filePath);
			primeraLinea=false;
                    }
					
                    /*@pamela --> If bullying trace classifier gives YES, continue with the other classifiers*/
                    if (clasifBullyingTrace.getClassResult().toUpperCase().equals(Constants.CLA_YES_BTRACE)){
			for (String classifierName : classifier_type){
                            t2v = new Tokens2FeatureVector();
                            t2v.loadVocab(Constants.PATH_VOCAB);
                            
                            Classification classifier = new Classification(classifierName);
                            classifier.loadModel();
                            classifier.classify(t2v.getIndexSet(), t2v.getValueSet());
                            
                            /*@pamela --> set attributes of the tweet*/
                            tweet.addClassifier(classifier);
                            tweet.setTokens(tokens);
                            tweet.setFv(t2v.getFv());
			}
			
                        /*@pamela --> Evaluate if tweet will be processed in the fuzzification process*/
			if (tweet.validateTweetForFuzzification());
                                tweet.fuzzificationProcess();
			
                    }
		}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		
			
			
		}/*fin main*/

}
