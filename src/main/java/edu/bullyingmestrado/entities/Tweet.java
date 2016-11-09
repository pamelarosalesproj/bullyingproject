/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.entities;

import edu.bullyingmestrado.classification.Classification;
import edu.bullyingmestrado.classification.FeatureVector;
import edu.bullyingmestrado.classification.Tokenizer;
import edu.bullyingmestrado.classification.Tokens2FeatureVector;
import edu.bullyingmestrado.commons.Constants;
import edu.bullyingmestrado.fuzzification.Fuzzification;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author pamela
 */
public class Tweet {
        private String text;
        private boolean isTextEnriched;
        private ArrayList<String> tokens;
        private String tokensOneText;
        
        private HashMap<String,Double> textUnigramBigram;
        private String textUnigramBigramOneText;
        
        private FeatureVector fv;
        Map<String, Classification> mapClassifiers;
        private boolean validForFuzzified;
        
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
            textUnigramBigram = new HashMap<>();
            this.validForFuzzified = false;
            this.isTextEnriched=false;
        }
        
        public Tweet(String text){
            this.text = text;
            mapClassifiers = new HashMap<>();
            textUnigramBigram = new HashMap<>();

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
                                    false, /*indicates if chart is displayed or not*/
                                    this.mapClassifiers.get(Constants.CLA_AUTHOR_ROLE).getClassResult(), 
                                    this.mapClassifiers.get(Constants.CLA_FORM).getClassResult(),
                                    this.mapClassifiers.get(Constants.CLA_TEASING).getClassifierName(),
                                    this.mapClassifiers.get(Constants.CLA_AUTHOR_ROLE).getValue(), 
                                    this.mapClassifiers.get(Constants.CLA_FORM).getValue(),
                                    this.mapClassifiers.get(Constants.CLA_TEASING).getValue()
                                    );
        }
        
        public boolean validateTweetForFuzzification(){
            for(String classifierName : Constants.classifier_type){
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
        
        public TweetCSV convertToTweetCSV(){
            TweetCSV tweetCSV = new TweetCSV();
            tweetCSV.setText(this.text);
            tweetCSV.setIsEnriched(this.isTextEnriched);
            tweetCSV.setTextTokens(this.tokensOneText);
            tweetCSV.setVectorUnigramBigram(textUnigramBigramOneText);
            
            for(String key : this.mapClassifiers.keySet()){
                    Classification classifier = this.mapClassifiers.get(key);
                    
                    if (classifier.getClassifierName().equals(Constants.CLA_TRACE)){
                        tweetCSV.setClassBullyingTrace(classifier.getClassResult());
                        tweetCSV.setValueBullyingTrace(classifier.getValue());
                    }
                    
                    if (classifier.getClassifierName().equals(Constants.CLA_TEASING)){
                        tweetCSV.setClassTeasingTrace(classifier.getClassResult());
                        tweetCSV.setValueTeasingTrace(classifier.getValue());
                    }
                    
                    if (classifier.getClassifierName().equals(Constants.CLA_FORM)){
                        tweetCSV.setClassFormBullying(classifier.getClassResult());
                        tweetCSV.setValueFormBullying(classifier.getValue());
                    }
                    
                    if (classifier.getClassifierName().equals(Constants.CLA_AUTHOR_ROLE)){
                        tweetCSV.setClassAuthor(classifier.getClassResult());
                        tweetCSV.setValueAuthor(classifier.getValue());
                    }
                    
            }
            
            tweetCSV.setValueSeverity(this.valueSeverity);
            tweetCSV.setIsValidForFuzzification(this.validForFuzzified);
            return tweetCSV;
        }
        
        public void createHashMapUnigramBigram(Tokens2FeatureVector t2v){
            Integer[] indexSet = this.fv.getIndexSet();
            
            for (Integer index : indexSet) {
                String word = t2v.getWordUsingIndex(index);
                double valueWord = fv.getValueOfWordIndex(index);
                this.textUnigramBigram.put(word, valueWord);
            }

        }
        
        public void createVectorUnigramBigram() {
		StringBuffer output = new StringBuffer();
                DecimalFormat df2 = new DecimalFormat(".####");

                output.append("[" );
                for(Entry<String, Double> entry : this.textUnigramBigram.entrySet())
                {   //print keys and values
                    output.append("(" + entry.getKey() + ":" + df2.format(entry.getValue()) + ")\t");
                }
                output.append("]" );
                
		this.textUnigramBigramOneText = output.toString();
	}
        
        
        public void process() throws IOException{
            /*@pamela --> Don't process line that don't fulfill the requirements of Enrichment*/
                        if (!Classification.checkInput(this.text) ){
                            return;
                        }
                        this.setIsTextEnriched(true);
                        
                        /*@pamela --> Convert text to vector according to vocabulary*/
                        Tokenizer tokenizer = new Tokenizer();
                        Tokens2FeatureVector t2v = new Tokens2FeatureVector();
                        t2v.loadVocab(Constants.PATH_VOCAB);
                        this.tokens = tokenizer.tokenize(this.text);
                        this.tokensOneText = String.join(Constants.SPACE, this.tokens);
                        t2v.covertFeatureVector(tokens);
                        this.setFv(t2v.getFv());
                        
                        
                        this.createHashMapUnigramBigram(t2v);
                        this.createVectorUnigramBigram();
                        
                        /*@pamela --> Use the 1st classifier 'Bullying Trace Classifier' that is a filter*/              
                        Classification clasifBullyingTrace = new Classification(Constants.CLA_TRACE);
                        clasifBullyingTrace.loadModel();
                        clasifBullyingTrace.classify(t2v.getIndexSet(), t2v.getValueSet());
                       /*@pamela --> Add Bullying Trace classifier to tweet*/
                        this.addClassifier(clasifBullyingTrace);
                        
                        /*@pamela --> If bullying trace classifier gives YES, continue with the other classifiers*/
                        if (clasifBullyingTrace.getClassResult().toUpperCase().equals(Constants.CLA_YES_BTRACE)){
                            for (String classifierName : Constants.classifier_type_withoutBullyingTrace){
                                Classification classifier = new Classification(classifierName);
                                classifier.loadModel();
                                classifier.classify(t2v.getIndexSet(), t2v.getValueSet());
                                
                                /*@pamela --> set attributes of the tweet*/
                                this.addClassifier(classifier);
                            }

                            /*@pamela --> Evaluate if tweet will be processed in the fuzzification process*/
                            if (this.validateTweetForFuzzification()){
                                    this.fuzzificationProcess();
                            }
                            
                
                        }
        }
        
        
        
}
