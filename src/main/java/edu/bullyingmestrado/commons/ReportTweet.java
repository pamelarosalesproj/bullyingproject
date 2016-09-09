/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.commons;

import edu.bullyingmestrado.entities.Tweet;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pamela
 */
public class ReportTweet {
    //Delimiter used in CSV file
	
	
	//CSV file header
	private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
        
        
        
	public static void main(String args[]) {
		
		//Create new students objects
		Tweet tweet1 = new Tweet("tweet 1", true);
		Tweet tweet2 = new Tweet("tweet 2", false);
		Tweet tweet3 = new Tweet("tweet 3", true);
		Tweet tweet4 = new Tweet("tweet 4", false);
		Tweet tweet5 = new Tweet("tweet 5", true);
		Tweet tweet6 = new Tweet("tweet 6", false);
		
		//Create a new list of student objects
		List<Tweet> tweets = new ArrayList();
		tweets.add(tweet1);
		tweets.add(tweet2);
		tweets.add(tweet3);
		tweets.add(tweet4);
		tweets.add(tweet5);
		tweets.add(tweet6);
		
		FileWriter fileWriter = null;
		String fileName = Constants.getCSVFilename();

                try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER);
			
			//Add a new line separator after the header
			fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Tweet tweet : tweets) {
				fileWriter.append(String.valueOf(tweet.getText()));
				fileWriter.append(Constants.VERTICALBAR_DELIMITER);
				fileWriter.append(Boolean.toString(tweet.getValidForFuzzified()));
				fileWriter.append(Constants.NEW_LINE_SEPARATOR);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
			}
			
		}
	}
}
