/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.commons;

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
	  
          /*
          Variables used by classifiers
          */
          public static final String VCLASIF_NR_CLASS = "nr_class";
          public static final String VCLASIF_LABEL = "label";
          public static final String VCLASIF_NR_FEATURE ="nr_feature";
          public static final String VCLASIF_BIAS ="bias";
          public static final String VCLASIF_WEIGH ="w";
          /**
           * Path for file used in ProjetoBullyingMestrado Netbeans
           */
          public static final String PATH_TWEETS_INI = "/tweets/test.txt";
          public static final String PATH_MODELS = "/model/";
          public static final String PATH_FCL = "/fcl/";
          
          /**
           Error, Warnings and Success Messages
           */
           public static final String MSG_WARN_ENRICH_NOKEYWORDS = "Warning: line does not contain keywords";
           public static final String MSG_WARN_ENRICH_NOWORDBULL = "(Warning: line does not contain string \"bull\"): ";
           public static final String MSG_WARN_ENRICH_MAX150 = "(Warning: line longer than 150 characters): ";   
           public static final String MSG_WARN_ENRICH_EXISTRT = "(Warning: line contains \"RT\", retweet?): ";
           
           
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
           


}
