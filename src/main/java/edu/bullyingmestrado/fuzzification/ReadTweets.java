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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author pamela
 */
public class ReadTweets {
        /**
	 * Inicio do Severity Tool
	 * */
    
         /*@pamela --> Only classifiers that will be used after bullying trace classifier filter*/
        static String[] classifier_type = { Constants.CLA_TEASING, 
                                            Constants.CLA_FORM,
                                            Constants.CLA_AUTHOR_ROLE
                                        }; 
         
        public static void addColumnInCSV(FileWriter fileWriter, String text, String characterAfterText) throws IOException{
                fileWriter.append(text);
		fileWriter.append(characterAfterText);
        }
        
        
        public static void main(String[] args){
            String line;
            FileWriter fileWriter=null;
            try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
				ReadTweets.class.getResourceAsStream(Constants.PATH_TWEETS_INI)));
                    
                    
                    String fileName = Constants.getCSVFilename();
                    fileWriter = new FileWriter(fileName);
                    fileWriter.append("sep="+Constants.VERTICALBAR_DELIMITER + Constants.NEW_LINE_SEPARATOR);

                    fileWriter.append(Constants.CSV_REPORTTWEETS_FILE_HEADER);
                    fileWriter.append(Constants.NEW_LINE_SEPARATOR);
                    
                    while ((line = br.readLine()) != null) {		
                        Tweet tweet = new Tweet(line);
                        /*@pamela-In Column CSV: (1)Original Tweet*/
			//addColumnInCSV(fileWriter,tweet.getText(),Constants.VERTICALBAR_DELIMITER);
                        fileWriter.append(tweet.getText());
                        fileWriter.append(Constants.VERTICALBAR_DELIMITER);                        
                        /*@pamela --> Don't process line that don't fulfill the requirements of Enrichment*/
                        if (!Classification.checkInput(line) ){
                            /*@pamela-In Column CSV: (2) Is a Enriched Tweet?*/
                           // addColumnInCSV(fileWriter,Boolean.toString(tweet.getIsTextEnriched()),Constants.NEW_LINE_SEPARATOR);
                            fileWriter.append(Boolean.toString(tweet.getIsTextEnriched()));
                            fileWriter.append(Constants.NEW_LINE_SEPARATOR);    
                            continue;
                        }
                        tweet.setIsTextEnriched(true);
                        /*@pamela-In Column CSV: (2) Is a Enriched Tweet?*/
                        //addColumnInCSV(fileWriter,Boolean.toString(tweet.getIsTextEnriched()),Constants.VERTICALBAR_DELIMITER);
                        fileWriter.append(Boolean.toString(tweet.getIsTextEnriched()));
                        fileWriter.append(Constants.VERTICALBAR_DELIMITER);  
                        
                        
                        /*@pamela --> Use the 1st classifier 'Bullying Trace Classifier' that is a filter*/              
                        ArrayList<String> tokens;
                        Tokenizer tokenizer = new Tokenizer();
                        Tokens2FeatureVector t2v = new Tokens2FeatureVector();
                        t2v.loadVocab(Constants.PATH_VOCAB);
                        Classification clasifBullyingTrace = new Classification(Constants.CLA_TRACE);
                        clasifBullyingTrace.loadModel();
                        tokens = tokenizer.tokenize(line);
                        t2v.covertFeatureVector(tokens);
                        clasifBullyingTrace.classify(t2v.getIndexSet(), t2v.getValueSet());
                       /*@pamela --> Add Bullying Trace classifier to tweet*/
                        tweet.addClassifier(clasifBullyingTrace);
                        
                        /*@pamela --> If bullying trace classifier gives YES, continue with the other classifiers*/
                        if (clasifBullyingTrace.getClassResult().toUpperCase().equals(Constants.CLA_YES_BTRACE)){
                            /*@pamela-In Column CSV: (3) Is a BullyingTrace?*/
                            //addColumnInCSV(fileWriter,clasifBullyingTrace.getClassResult(),Constants.VERTICALBAR_DELIMITER);
                            fileWriter.append(clasifBullyingTrace.getClassResult());
                            fileWriter.append(Constants.VERTICALBAR_DELIMITER);  
                            
                            for (String classifierName : classifier_type){
                               
                                t2v.loadVocab(Constants.PATH_VOCAB);

                                Classification classifier = new Classification(classifierName);
                                classifier.loadModel();
                                classifier.classify(t2v.getIndexSet(), t2v.getValueSet());
                                /*@pamela-In Column CSV: (4,5,6) */
                                //addColumnInCSV(fileWriter,classifier.getClassResult(),Constants.VERTICALBAR_DELIMITER);
                                fileWriter.append(classifier.getClassResult());
                                fileWriter.append(Constants.VERTICALBAR_DELIMITER);  
                                
                                /*@pamela --> set attributes of the tweet*/
                                tweet.addClassifier(classifier);
                                tweet.setTokens(tokens);
                                tweet.setFv(t2v.getFv());
                            }

                            /*@pamela --> Evaluate if tweet will be processed in the fuzzification process*/
                            if (tweet.validateTweetForFuzzification()){
                                    tweet.fuzzificationProcess();
                            }
                            
                            /*@pamela-In Column CSV: (7) is valid for fuzzification*/
                                //addColumnInCSV(fileWriter,Boolean.toString(tweet.getValidForFuzzified()),Constants.VERTICALBAR_DELIMITER);
                                fileWriter.append(Boolean.toString(tweet.getValidForFuzzified()));
                                fileWriter.append(Constants.VERTICALBAR_DELIMITER);  
                                
                                
                             /*@pamela-In Column CSV: (8) Severity value*/
                                //addColumnInCSV(fileWriter,Double.toString(tweet.getValueSeverity()),Constants.NEW_LINE_SEPARATOR);
                                fileWriter.append(Double.toString(tweet.getValueSeverity()));
                                fileWriter.append(Constants.NEW_LINE_SEPARATOR);  
                        }else{
                            /*@pamela-In Column CSV: (3) Is a BullyingTrace?*/
                            //addColumnInCSV(fileWriter,clasifBullyingTrace.getClassResult(),Constants.NEW_LINE_SEPARATOR);
                            fileWriter.append(clasifBullyingTrace.getClassResult());
                            fileWriter.append(Constants.NEW_LINE_SEPARATOR);  
                        }
                        
                        
                    }
		} catch (IOException e) {
                    System.out.println("Nao se encontro arquivo");
		}catch (Exception e) {
                    e.printStackTrace();
		}finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}


			
		
			
			
		}/*fin main*/

}
