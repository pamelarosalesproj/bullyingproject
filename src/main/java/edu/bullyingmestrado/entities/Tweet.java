/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.entities;

import edu.bullyingmestrado.classification.Classification;
import edu.bullyingmestrado.classification.FeatureVector;
import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.fuzzification.Fuzzification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pamela
 */
public class Tweet {
        private String text;
        private boolean isTextEnriched;
        private ArrayList<String> tokens;
        private FeatureVector fv;
        Map<String, Classification> mapClassifiers;
        private boolean validForFuzzified;
        static String[] classifier_type = { Constants.CLA_TRACE,        Constants.CLA_TEASING,    
                                            Constants.CLA_AUTHOR_ROLE,  Constants.CLA_FORM     
                                        }; 
        private double valueSeverity;

    public boolean getIsTextEnriched() {
        return isTextEnriched;
    }

    public void setIsTextEnriched(boolean isTextEnriched) {
        this.isTextEnriched = isTextEnriched;
    }    
        
    public boolean getValidForFuzzified() {
        return this.validForFuzzified;
    }

    public void setValidForFuzzified(boolean validForFuzzified) {
        this.validForFuzzified = validForFuzzified;
    }

    public double getValueSeverity() {
        return valueSeverity;
    }

    public void setValueSeverity(double valueSeverity) {
        this.valueSeverity = valueSeverity;
    }
        
        public void addClassifier(Classification classifier){
                this.mapClassifiers.put(classifier.getClassifierName(),classifier);
        }
        
        public Tweet(){
            mapClassifiers = new HashMap<>();
            this.validForFuzzified = false;
            this.isTextEnriched=false;
        }
        
        public Tweet(String text){
            this.text = text;
            mapClassifiers = new HashMap<>();
            this.validForFuzzified = false;
             this.isTextEnriched=false;
        }
        
        public Tweet(String text, boolean validForFuzzified ){
            this.text = text;
            this.validForFuzzified= validForFuzzified;
            mapClassifiers = new HashMap<>();        
        }
        
        
        
        public ArrayList<String> getTokens() {
            return tokens;
        }

        public void setTokens(ArrayList<String> tokens) {
            this.tokens = tokens;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public FeatureVector getFv() {
            return fv;
        }

        public void setFv(FeatureVector fv) {
            this.fv = fv;
        }
        
        public void fuzzificationProcess(){
           Fuzzification fuzzy = new Fuzzification();
           this.valueSeverity = fuzzy.getFuzzy(
                                    this.mapClassifiers.get(Constants.CLA_AUTHOR_ROLE).getClassResult(), 
                                    this.mapClassifiers.get(Constants.CLA_FORM).getClassResult(),
                                    this.mapClassifiers.get(Constants.CLA_TEASING).getClassifierName(),
                                    this.mapClassifiers.get(Constants.CLA_AUTHOR_ROLE).getValue(), 
                                    this.mapClassifiers.get(Constants.CLA_FORM).getValue(),
                                    this.mapClassifiers.get(Constants.CLA_TEASING).getValue()
                                    );
        }
        
        public boolean validateTweetForFuzzification(){
            for(String classifierName : classifier_type){
                Classification classifier = this.mapClassifiers.get(classifierName);
                if (classifier.getClassResult().equals(Constants.CLA_AUTH_ACCUSER) ||
                    classifier.getClassResult().equals(Constants.CLA_AUTH_DEFENDER) ||
                    classifier.getClassResult().equals(Constants.CLA_AUTH_REPORTER) ||
                    classifier.getClassResult().equals(Constants.CLA_AUTH_OTHER) ||
                    classifier.getClassResult().equals(Constants.CLA_FORM_GENERAL) 
                    ){
                    this.validForFuzzified = false;
                    return this.validForFuzzified;
                }
            }
            
            this.validForFuzzified = true;
            return this.validForFuzzified ;
        }

}
