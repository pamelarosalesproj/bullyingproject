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

import edu.bullyingmestrado.fuzzification.ReadTweets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Tokens2FeatureVector {
        private static final Logger logger = LogManager.getLogger(Tokens2FeatureVector.class.getName());

	HashMap<String, Integer> vocab; 
	
	FeatureVector fv;

        public FeatureVector getFv() {
            return fv;
        }

        public void setFv(FeatureVector fv) {
            this.fv = fv;
        }

        
	public void loadVocab(String file){
		vocab = new HashMap<>();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(Tokens2FeatureVector.class.getResourceAsStream(file)));
			String line;
			int index = 0;
			while ((line = br.readLine()) != null){
				vocab.put(line.trim(), index);
				index++;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
        
        public String getWordUsingIndex(int i){
            String word=null;
            for (String key : this.vocab.keySet()) {
                if (this.vocab.get(key).equals(i)) {
                  return key;
                }
            }
            return word;
        }
	
	public void covertFeatureVector(ArrayList<String> tokens){
		this.fv = new FeatureVector(vocab.size());
		for (String t : tokens){
			Integer idx = vocab.get(t);
			if (idx != null)
				fv.increase(idx);
		}
		for (int i = 1 ; i < tokens.size(); i++){
			Integer idx = vocab.get(tokens.get(i-1) + " " + tokens.get(i));
			if (idx != null)
				fv.increase(idx);
		}
		//System.out.println("vector BEFORE normalization");
                //System.out.println(fv.toString());
               
                //logger.info(fv.toString());
                
                this.fv.normalize();
                
                //System.out.println("vector AFTER normalization");
                //System.out.println(fv.toString());
                //logger.info(fv.toString());
	}
	
	public Integer[] getIndexSet(){
		return fv.getIndexSet();
	}
	
	public double[] getValueSet(){
		return fv.getValueSet();
	}
}

