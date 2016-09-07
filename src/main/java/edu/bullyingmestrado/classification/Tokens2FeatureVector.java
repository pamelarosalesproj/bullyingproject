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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;



public class Tokens2FeatureVector {
	
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
	
	public void covertFeatureVector(ArrayList<String> tokens){
		fv = new FeatureVector(vocab.size());
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
		fv.normalize();
	   System.out.println(fv.toString());	
	}
	
	public Integer[] getIndexSet(){
		return fv.getIndexSet();
	}
	
	public double[] getValueSet(){
		return fv.getValueSet();
	}
}

