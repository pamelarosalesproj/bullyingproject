/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.fuzzification;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.entities.Tweet;
import edu.bullyingmestrado.entities.TweetCSV;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author pamela
 */
public class ReadTweets {
        /**
	 * Inicio do Severity Tool
	 *
     * @param listTweets */
       private static final Logger logger = LogManager.getLogger(ReadTweets.class.getName());
       
        
       public static void writeCSVTweets(List<TweetCSV> listTweets){
            String fileName = Constants.getCSVFilename();
            CSVWriter csvWriter = null;
		try
		{
			//Create CSVWriter for writing to Tweets.csv 
			csvWriter = new CSVWriter(new FileWriter(fileName));
                        BeanToCsv bc = new BeanToCsv();
                        //mapping of columns with their positions
                        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
                        //Set mappingStrategy type to TweetCSV Type
                        mappingStrategy.setType(TweetCSV.class);
                        //Setting the colums for mappingStrategy
                        mappingStrategy.setColumnMapping(Constants.CSV_TWEETS_FILE_HEADER);
                        //Writing listTweets to csv file
                        bc.write(mappingStrategy,csvWriter,listTweets);
                        //logger.info(Constants.MSG_INFO_CSVCREATED);
                }
                catch(Exception e){
                
                }
                finally
		{
			try
			{
				csvWriter.close();
			}
			catch(Exception ee)
			{
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
                        if (!tweet.getAuthorRoleClassResult().equals("")){
                            System.out.println(tweet.getTokensOneText());
                            //@pamela --> Print tweet after passing Tokenizer.java
                            logger.info(tweet.getTokensOneText());
                            System.out.println(tweet.getAuthorRoleClassResult() + " , " + tweet.getFv().toString()  ); 
                           // logger.info(tweet.getAuthorRoleClassResult() + " , " + tweet.getFv().toString()  ); 
                        }
                        tweetCSV= tweet.convertToTweetCSV();
                        /*@pamela --> Add tweet to the list of tweets*/
                        listTweets.add(tweetCSV);
                        
                    }
                    
                  writeCSVTweets(listTweets);  
		} catch (IOException e) {
                    logger.error(Constants.MSG_ERROR_NOFILE);
		}catch (Exception e) {
                    e.printStackTrace();
		}


			
		
			
			
		}/*fin main*/

}
