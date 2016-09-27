/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pamela
 */
public final class Constants {
	
	  public static final String EMPTY_STRING = "";
	  public static final String SPACE = " ";
	  public static final String TAB = "\t";
	  public static final String SINGLE_QUOTE = "'";
	  public static final String PERIOD = ".";
	  public static final String DOUBLE_QUOTE = "\"";
          public static final String UNDERLINE = "_";
          public static final String COMMA_DELIMITER = ",";
          public static final String NEW_LINE_SEPARATOR = "\n";
          public static final String VERTICALBAR_DELIMITER = "|";
          /*
          * Words used in tweets that will be cleaned or replaced
          */
          public static final String TWEET_RT = "RT";
	  public static final String TWEET_BULL = "bull";
	  
	  /*
	   * Types of Classification for Severity Tool
	   * */
	  public static final String CLA_TRACE          = "trace";
	  public static final String CLA_TEASING        = "teasing";
	  public static final String CLA_AUTHOR_ROLE    = "author_role";
	  public static final String CLA_FORM           = "form";
	  
          
          public static String[] classifier_type_withoutBullyingTrace = { Constants.CLA_TEASING, 
                                            Constants.CLA_FORM,
                                            Constants.CLA_AUTHOR_ROLE
                                        }; 
          public static String[] classifier_type = { Constants.CLA_TRACE,        Constants.CLA_TEASING,    
                                            Constants.CLA_AUTHOR_ROLE,  Constants.CLA_FORM     
                                        }; 
          
          /* Labels of Binary Classifier */
          public static final String CLA_YES = "YES";
          public static final String CLA_NO = "NO";
          //Classifier Bullying Trace
          public static final String CLA_YES_BTRACE     = "YES_TRACE";
          public static final String CLA_NO_BTRACE      = "NO_TRACE";
          //Classifier Teasing Trace
          public static final String CLA_YES_TEASING    = "YES_TEASING";
          public static final String CLA_NO_TEASING     =  "NO_TEASING";

          /* Labels of Multiclasses Classifier */
          //Classifier Author
          public static final String CLA_AUTH_VICTIM    = "victim";
          public static final String CLA_AUTH_BULLY     =  "bully";
          public static final String CLA_AUTH_DEFENDER  =  "defender";
          public static final String CLA_AUTH_REPORTER  =  "reporter";
          public static final String CLA_AUTH_ACCUSER   =  "accuser";
          public static final String CLA_AUTH_OTHER   =  "other";
         
          //Classifier Form
          public static final String CLA_FORM_PHYSICAL   = "physical";
          public static final String CLA_FORM_VERBAL    =  "verbal";
          public static final String CLA_FORM_GENERAL    =  "general";
          public static final String CLA_FORM_CYBERBULLYING    =  "cyberbullying";


        
          /*
          Variables used by classifiers & fuzzification
          */
          public static final String VCLASIF_NR_CLASS = "nr_class";
          public static final String VCLASIF_LABEL = "label";
          public static final String VCLASIF_NR_FEATURE ="nr_feature";
          public static final String VCLASIF_BIAS ="bias";
          public static final String VCLASIF_WEIGH ="w";
          public static final String V_SEVERITY ="Severity";
          /**
           * Path for file used in ProjetoBullyingMestrado Netbeans
           */
          public static final String PATH_TWEETS_INI = "/tweets/test.txt";
          public static final String PATH_MODELS = "/model/";
          public static final String PATH_FCL = "fcl/";
          public static final String PATH_LONG_FCL = "src/main/resources/fcl/";
          public static final String PATH_VOCAB = "/model/vocab";
          
          /**
           Error, Warnings and Success Messages
           */
           public static final String MSG_WARN_ENRICH_NOKEYWORDS = "Warning: line does not contain keywords";
           public static final String MSG_WARN_ENRICH_NOWORDBULL = "(Warning: line does not contain string \"bull\"): ";
           public static final String MSG_WARN_ENRICH_MAX150 = "(Warning: line longer than 150 characters): ";   
           public static final String MSG_WARN_ENRICH_EXISTRT = "(Warning: line contains \"RT\", retweet?): ";
           public static final String MSG_ERROR_NOFILE = "ERROR - The file wasn't found : '";
           public static final String MSG_INFO_FILECREATED = "INFO - The file created is : '";
           public static final String MSG_INFO_CSVCREATED= "INFO - CSV File written successfully";
           public static final String MSG_ERROR_CSVFAIL= "ERROR - CSV File wasn't created or has errors";

           /**
            List of keywords used in Bullying context
            *
            */
           public static final String KW_IGNORED = "ignored";
           public static final String KW_PUSHED = "pushed";
           public static final String KW_RUMORS = "rumors";
           public static final String KW_LOCKER = "locker";
           public static final String KW_SPREAD = "spread";
           public static final String KW_SHOVED = "shoved";
           public static final String KW_RUMOR = "rumor";
           public static final String KW_TEASED= "teased";
           public static final String KW_KICKED= "kicked";
           public static final String KW_CRYING= "crying";
           public static final String KW_BULLYED= "bullyed";
           public static final String KW_BULLIED= "bullied";
           public static final String KW_BULLYNG= "bullying";
           public static final String KW_BULLYER= "bullyer";
           public static final String KW_BULLING= "bulling";
           public static final String KW_BULLY= "bully";
           /*
           List of format extensions
           */
           public static final String EXT_FCL = ".fcl";
           
           /**
            Structure for *.csv files
            */
           public static final String CSV_REPORTTWEETS_FILE_HEADER ="Original Tweet |is a Enriched Tweet?|Bullying Trace?|Teasing Trace?|Bullying Form?|Author Role|Valid for Fuzzification?|Severity";
           
           public static String[] CSV_TWEETS_FILE_HEADER = { 
                                            Constants.COLUMN_TWEET_TEXT,
                                            Constants.COLUMN_TWEET_ISENRICHED,
                                            Constants.COLUMN_TWEET_CLASSBULLYINGTRACE,
                                            Constants.COLUMN_TWEET_VALUEBULLYINGTRACE,
                                            Constants.COLUMN_TWEET_CLASSTEASINGTRACE,
                                            Constants.COLUMN_TWEET_VALUETEASINGTRACE,
                                            Constants.COLUMN_TWEET_CLASSFORMBULLYING,
                                            Constants.COLUMN_TWEET_VALUEFORMBULLYING,
                                            Constants.COLUMN_TWEET_CLASSAUTHOR,
                                            Constants.COLUMN_TWEET_VALUEAUTHOR,
                                            Constants.COLUMN_TWEET_ISVALIDFUZZIFICATION,
                                            Constants.COLUMN_TWEET_VALUESEVERITY
                                        };
           
           /*array of columns for CSV file*/
           public static final String COLUMN_TWEET_TEXT = "text";
           public static final String COLUMN_TWEET_ISENRICHED ="isEnriched";
           public static final String COLUMN_TWEET_CLASSBULLYINGTRACE ="classBullyingTrace";
           public static final String COLUMN_TWEET_VALUEBULLYINGTRACE ="valueBullyingTrace";
           public static final String COLUMN_TWEET_CLASSTEASINGTRACE ="classTeasingTrace";
           public static final String COLUMN_TWEET_VALUETEASINGTRACE ="valueTeasingTrace";
           public static final String COLUMN_TWEET_CLASSFORMBULLYING ="classFormBullying";
           public static final String COLUMN_TWEET_VALUEFORMBULLYING ="valueFormBullying";
           public static final String COLUMN_TWEET_CLASSAUTHOR ="classAuthor";
           public static final String COLUMN_TWEET_VALUEAUTHOR ="valueAuthor";
           public static final String COLUMN_TWEET_ISVALIDFUZZIFICATION ="isValidForFuzzification";
           public static final String COLUMN_TWEET_VALUESEVERITY ="valueSeverity";
           
          
           public static String getCSVFilename(){
                Date dNow = new Date( );
                SimpleDateFormat ft = 
                new SimpleDateFormat ("yyyy-MM-dd_HH-mm-ss");
		String fileName = "E:/tweetsCSV/reportTweet" + ft.format(dNow)+ ".csv";	
                return fileName;
            }

}
