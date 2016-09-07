/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.classification;

import java.util.HashSet;

/**
 *
 * @author pamela
 */
public class FeatureVector {

	protected HashSet<Integer> index;
	protected double[] values;
	
	public FeatureVector(int size){
		index = new HashSet<>();
		values = new double[size];
	}
	
	public void increase(Integer i){
		index.add(i);
		values[i] += 1.0;
	}
	
	public void normalize(){
		double ss = 0.0;
		for (int i : index)
			ss += values[i] * values[i];
		ss = Math.sqrt(ss);
		for (int i : index)
			values[i] /= ss;
	}
	
	public Integer[] getIndexSet(){
            
		return index.toArray(new Integer[index.size()]);
	}
	
	public double[] getValueSet(){
		return values;
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		for (int i : index) {
			output.append(i + ":" + values[i] + "\t");
		}
		output.append("\n");
		return output.toString();
	}
	
}
