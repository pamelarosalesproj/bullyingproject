/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.fuzzification;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import edu.bullyingmestrado.classification.Classification;
import edu.bullyingmestrado.classification.Tokenizer;
import edu.bullyingmestrado.classification.Tokens2FeatureVector;
import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.entities.Tweet;
import edu.bullyingmestrado.entities.TweetCSV;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pamela
 */
public class ReadTweets {
        /**
	 * Inicio do Severity Tool
	 *
     * @param listTweets */
    
        
       public static void writeCSVTweets(List<TweetCSV> listTweets){
       /*@pamela-In Column CSV: (1)Original Tweet*/
       /*@pamela-In Column CSV: (2) Is a Enriched Tweet?*/
       /*@pamela-In Column CSV: (3) Is a BullyingTrace?*/
        /*@pamela-In Column CSV: (4,5,6) */
        /*@pamela-In Column CSV: (7) is valid for fuzzification*/
         /*@pamela-In Column CSV: (8) Severity value*/
            String fileName = Constants.getCSVFilename();
            CSVWriter csvWriter = null;
		try
		{
			//Create CSVWriter for writing to Tweets.csv 
			csvWriter = new CSVWriter(new FileWriter(fileName));
                        BeanToCsv bc = new BeanToCsv();
                        //mapping of columns with their positions
                        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
                        //Set mappingStrategy type to Employee Type
                        mappingStrategy.setType(TweetCSV.class);
            //Fields in Employee Bean
            String[] columns = new String[]{"text","isEnriched","classBullyingTrace",
"valueBullyingTrace","classTeasingTrace",
"valueTeasingTrace","classFormBullying",
"valueFormBullying","classAuthor",
"valueAuthor", "isValidForFuzzification",
"valueSeverity"};
            
            
            
            
            
            //Setting the colums for mappingStrategy
            mappingStrategy.setColumnMapping(columns);
            //Writing empList to csv file
            bc.write(mappingStrategy,csvWriter,listTweets);
            System.out.println("CSV File written successfully!!!");
                
                }
                catch(Exception e){}
                finally
		{
			try
			{
				//closing the writer
				csvWriter.close();
			}
			catch(Exception ee)
			{
                            System.out.println("error.. flushh");
				ee.printStackTrace();
			}
		}
       
       } 
        
        
        public static void main(String[] args){
            String line;
            List<TweetCSV> listTweets  = new ArrayList<>(); 
            try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
				ReadTweets.class.getResourceAsStream(Constants.PATH_TWEETS_INI)));
                    
                    Tweet tweet;
                    TweetCSV tweetCSV;
                    while ((line = br.readLine()) != null) {		
                        tweet = new Tweet(line);
                        tweet.process();
                        tweetCSV= tweet.convertToTweetCSV();
                        /*@pamela --> Add tweet to the list of tweets*/
                        listTweets.add(tweetCSV);
                        
                    }
                    
                  writeCSVTweets(listTweets);  
		} catch (IOException e) {
                    System.out.println("Nao se encontro arquivo");
		}catch (Exception e) {
                    e.printStackTrace();
		}


			
		
			
			
		}/*fin main*/

}
