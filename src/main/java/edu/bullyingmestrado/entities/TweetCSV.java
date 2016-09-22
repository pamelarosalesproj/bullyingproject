/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.entities;

/**
 *
 * @author pamela
 */
public class TweetCSV {
    public String text;
    public boolean isEnriched;
    
    public String classBullyingTrace;
    public double valueBullyingTrace;
    
    public String classTeasingTrace;
    public double valueTeasingTrace;
    
    public String classFormBullying;
    public double valueFormBullying;
    
    public String classAuthor;
    public double valueAuthor;
    
    public boolean isValidForFuzzification;
    public double valueSeverity;


    public TweetCSV(){
        this.isEnriched=false;
        this.isValidForFuzzification=false;
        this.classBullyingTrace ="";
        this.valueBullyingTrace = 0;
        
        this.classTeasingTrace ="";
        this.valueTeasingTrace =0;
        
        this.classFormBullying ="";
        this.valueFormBullying = 0;
        
        this.classAuthor = "";
        this.valueAuthor = 0;
        
        this.valueSeverity = 0;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIsEnriched() {
        return isEnriched;
    }

    public void setIsEnriched(boolean isEnriched) {
        this.isEnriched = isEnriched;
    }

    public String getClassBullyingTrace() {
        return classBullyingTrace;
    }

    public void setClassBullyingTrace(String classBullyingTrace) {
        this.classBullyingTrace = classBullyingTrace;
    }

    public double getValueBullyingTrace() {
        return valueBullyingTrace;
    }

    public void setValueBullyingTrace(double valueBullyingTrace) {
        this.valueBullyingTrace = valueBullyingTrace;
    }

    public String getClassTeasingTrace() {
        return classTeasingTrace;
    }

    public void setClassTeasingTrace(String classTeasingTrace) {
        this.classTeasingTrace = classTeasingTrace;
    }

    public double getValueTeasingTrace() {
        return valueTeasingTrace;
    }

    public void setValueTeasingTrace(double valueTeasingTrace) {
        this.valueTeasingTrace = valueTeasingTrace;
    }

    public String getClassFormBullying() {
        return classFormBullying;
    }

    public void setClassFormBullying(String classFormBullying) {
        this.classFormBullying = classFormBullying;
    }

    public double getValueFormBullying() {
        return valueFormBullying;
    }

    public void setValueFormBullying(double valueFormBullying) {
        this.valueFormBullying = valueFormBullying;
    }

    public String getClassAuthor() {
        return classAuthor;
    }

    public void setClassAuthor(String classAuthor) {
        this.classAuthor = classAuthor;
    }

    public double getValueAuthor() {
        return valueAuthor;
    }

    public void setValueAuthor(double valueAuthor) {
        this.valueAuthor = valueAuthor;
    }

    public boolean isIsValidForFuzzification() {
        return isValidForFuzzification;
    }

    public void setIsValidForFuzzification(boolean isValidForFuzzification) {
        this.isValidForFuzzification = isValidForFuzzification;
    }

    public double getValueSeverity() {
        return valueSeverity;
    }

    public void setValueSeverity(double valueSeverity) {
        this.valueSeverity = valueSeverity;
    }

    
}
