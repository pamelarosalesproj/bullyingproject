package edu.bullyingmestrado.classification;
/*
Author: Jun-Ming Xu (xujm@cs.wisc.edu)

Contact: Jun-Ming Xu (xujm@cs.wisc.edu), Xiaojin Zhu (jerryzhu@cs.wisc.edu)
June 2012

*/
/**
 *
 * @author Jun-Ming Xu
 * Modified by Pamela Rosales
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tokenizer {
	
	// if change all text to lower case
	protected boolean toLowerCare = true;
	// if replace the user name and url with generic token
	protected boolean anonmymize = true;
	// if treat emoticons as tokens
	protected boolean emoticons = true;
	
	public ArrayList<String> tokenize(String text){
		if (toLowerCare)
			text = text.toLowerCase();
		if (anonmymize){
			text = text.replaceAll("http\\:\\/\\/[\\S]*\\b", "HTTPLINK");
                        /*@pamela --> To include httpS, without it, text converted to vector isn't correct*/
                        text = text.replaceAll("https\\:\\/\\/[\\S]*\\b", "HTTPLINK");

			text = text.replaceAll("\\@\\w+", "@USER");
		}
                
                /*@pamela --> new rules for future time*/
                text = text.replaceAll("he\\'ll+", "he will");
                text = text.replaceAll("she\\'ll+", "she will");
                text = text.replaceAll("they\\'ll+", "they will");
                text = text.replaceAll("i\\'ll+", "i will");
                text = text.replaceAll("we\\'ll+", "we will");
                text = text.replaceAll("you\\'ll+", "you will");

                //Some urban dictionary and abbreviations
                text = text.replaceAll("y\\'all+", "you all");
                text = text.replaceAll("24\\/7+", "you all");
		// deal with negation
		text = text.replaceAll("\\'", "");
                text = text.replaceAll("\\!\\!+", "!!");
                text = text.replaceAll("\\?\\?+", "??");
                text = text.replaceAll("\\bno\\s+", "no_");
                text = text.replaceAll("\\bnot\\s+", "not_");
                text = text.replaceAll("\\bdoesnt\\s+", "doesnt_");
                text = text.replaceAll("\\bdont\\s+", "dont_");
                text = text.replaceAll("\\baint\\s+", "aint_");
                
                
        
                // tokenizer
                Pattern p = null;

                if (emoticons)
                        p = Pattern.compile("([\\@\\#]?\\w[\\w'_]*)|([:;=x][-o^]?[)(/\\\\dp])|([/\\\\)(dp][-o^]?[:;=x])|([!?]+)");
                else
                        p = Pattern.compile("[\\@\\#]?\\w[\\w'_]*");

                Matcher matcher = p.matcher(text);
                ArrayList<String> tokens = new ArrayList<String>();
                String matchText = null;
                    while(matcher == null || matcher.find()){
                            matchText = matcher.group();
                            if (matchText.length() == 0)
                                    break;
                            tokens.add(matchText);
                    }
                return tokens;
	
        }


	public boolean isToLowerCare() {
		return toLowerCare;
	}


	public void setToLowerCare(boolean toLowerCare) {
		this.toLowerCare = toLowerCare;
	}


	public boolean isAnonmymize() {
		return anonmymize;
	}


	public void setAnonmymize(boolean anonmymize) {
		this.anonmymize = anonmymize;
	}


	public boolean isEmoticons() {
		return emoticons;
	}


	public void setEmoticons(boolean emoticons) {
		this.emoticons = emoticons;
	}
}
