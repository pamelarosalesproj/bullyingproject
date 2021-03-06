package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpEspCurrency generated by hbm2java
 */
public class WpEspCurrency  implements java.io.Serializable {


     private String curCode;
     private String curSingle;
     private String curPlural;
     private String curSign;
     private String curDecPlc;
     private Boolean curActive;

    public WpEspCurrency() {
    }

	
    public WpEspCurrency(String curCode, String curDecPlc) {
        this.curCode = curCode;
        this.curDecPlc = curDecPlc;
    }
    public WpEspCurrency(String curCode, String curSingle, String curPlural, String curSign, String curDecPlc, Boolean curActive) {
       this.curCode = curCode;
       this.curSingle = curSingle;
       this.curPlural = curPlural;
       this.curSign = curSign;
       this.curDecPlc = curDecPlc;
       this.curActive = curActive;
    }
   
    public String getCurCode() {
        return this.curCode;
    }
    
    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }
    public String getCurSingle() {
        return this.curSingle;
    }
    
    public void setCurSingle(String curSingle) {
        this.curSingle = curSingle;
    }
    public String getCurPlural() {
        return this.curPlural;
    }
    
    public void setCurPlural(String curPlural) {
        this.curPlural = curPlural;
    }
    public String getCurSign() {
        return this.curSign;
    }
    
    public void setCurSign(String curSign) {
        this.curSign = curSign;
    }
    public String getCurDecPlc() {
        return this.curDecPlc;
    }
    
    public void setCurDecPlc(String curDecPlc) {
        this.curDecPlc = curDecPlc;
    }
    public Boolean getCurActive() {
        return this.curActive;
    }
    
    public void setCurActive(Boolean curActive) {
        this.curActive = curActive;
    }




}


