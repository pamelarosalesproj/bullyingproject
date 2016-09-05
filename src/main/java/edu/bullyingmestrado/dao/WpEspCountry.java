package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpEspCountry generated by hbm2java
 */
public class WpEspCountry  implements java.io.Serializable {


     private String cntIso;
     private String cntIso3;
     private Byte rgnId;
     private String cntName;
     private String cntCurCode;
     private String cntCurSingle;
     private String cntCurPlural;
     private String cntCurSign;
     private Boolean cntCurSignB4;
     private byte cntCurDecPlc;
     private String cntCurDecMrk;
     private String cntCurThsnds;
     private String cntTelCode;
     private Boolean cntIsEu;
     private Boolean cntActive;

    public WpEspCountry() {
    }

	
    public WpEspCountry(String cntIso, String cntIso3, String cntName, byte cntCurDecPlc, String cntCurDecMrk, String cntCurThsnds) {
        this.cntIso = cntIso;
        this.cntIso3 = cntIso3;
        this.cntName = cntName;
        this.cntCurDecPlc = cntCurDecPlc;
        this.cntCurDecMrk = cntCurDecMrk;
        this.cntCurThsnds = cntCurThsnds;
    }
    public WpEspCountry(String cntIso, String cntIso3, Byte rgnId, String cntName, String cntCurCode, String cntCurSingle, String cntCurPlural, String cntCurSign, Boolean cntCurSignB4, byte cntCurDecPlc, String cntCurDecMrk, String cntCurThsnds, String cntTelCode, Boolean cntIsEu, Boolean cntActive) {
       this.cntIso = cntIso;
       this.cntIso3 = cntIso3;
       this.rgnId = rgnId;
       this.cntName = cntName;
       this.cntCurCode = cntCurCode;
       this.cntCurSingle = cntCurSingle;
       this.cntCurPlural = cntCurPlural;
       this.cntCurSign = cntCurSign;
       this.cntCurSignB4 = cntCurSignB4;
       this.cntCurDecPlc = cntCurDecPlc;
       this.cntCurDecMrk = cntCurDecMrk;
       this.cntCurThsnds = cntCurThsnds;
       this.cntTelCode = cntTelCode;
       this.cntIsEu = cntIsEu;
       this.cntActive = cntActive;
    }
   
    public String getCntIso() {
        return this.cntIso;
    }
    
    public void setCntIso(String cntIso) {
        this.cntIso = cntIso;
    }
    public String getCntIso3() {
        return this.cntIso3;
    }
    
    public void setCntIso3(String cntIso3) {
        this.cntIso3 = cntIso3;
    }
    public Byte getRgnId() {
        return this.rgnId;
    }
    
    public void setRgnId(Byte rgnId) {
        this.rgnId = rgnId;
    }
    public String getCntName() {
        return this.cntName;
    }
    
    public void setCntName(String cntName) {
        this.cntName = cntName;
    }
    public String getCntCurCode() {
        return this.cntCurCode;
    }
    
    public void setCntCurCode(String cntCurCode) {
        this.cntCurCode = cntCurCode;
    }
    public String getCntCurSingle() {
        return this.cntCurSingle;
    }
    
    public void setCntCurSingle(String cntCurSingle) {
        this.cntCurSingle = cntCurSingle;
    }
    public String getCntCurPlural() {
        return this.cntCurPlural;
    }
    
    public void setCntCurPlural(String cntCurPlural) {
        this.cntCurPlural = cntCurPlural;
    }
    public String getCntCurSign() {
        return this.cntCurSign;
    }
    
    public void setCntCurSign(String cntCurSign) {
        this.cntCurSign = cntCurSign;
    }
    public Boolean getCntCurSignB4() {
        return this.cntCurSignB4;
    }
    
    public void setCntCurSignB4(Boolean cntCurSignB4) {
        this.cntCurSignB4 = cntCurSignB4;
    }
    public byte getCntCurDecPlc() {
        return this.cntCurDecPlc;
    }
    
    public void setCntCurDecPlc(byte cntCurDecPlc) {
        this.cntCurDecPlc = cntCurDecPlc;
    }
    public String getCntCurDecMrk() {
        return this.cntCurDecMrk;
    }
    
    public void setCntCurDecMrk(String cntCurDecMrk) {
        this.cntCurDecMrk = cntCurDecMrk;
    }
    public String getCntCurThsnds() {
        return this.cntCurThsnds;
    }
    
    public void setCntCurThsnds(String cntCurThsnds) {
        this.cntCurThsnds = cntCurThsnds;
    }
    public String getCntTelCode() {
        return this.cntTelCode;
    }
    
    public void setCntTelCode(String cntTelCode) {
        this.cntTelCode = cntTelCode;
    }
    public Boolean getCntIsEu() {
        return this.cntIsEu;
    }
    
    public void setCntIsEu(Boolean cntIsEu) {
        this.cntIsEu = cntIsEu;
    }
    public Boolean getCntActive() {
        return this.cntActive;
    }
    
    public void setCntActive(Boolean cntActive) {
        this.cntActive = cntActive;
    }




}

