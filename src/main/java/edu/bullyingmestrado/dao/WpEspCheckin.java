package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * WpEspCheckin generated by hbm2java
 */
public class WpEspCheckin  implements java.io.Serializable {


     private Integer chkId;
     private int regId;
     private int dttId;
     private boolean chkIn;
     private Date chkTimestamp;

    public WpEspCheckin() {
    }

    public WpEspCheckin(int regId, int dttId, boolean chkIn, Date chkTimestamp) {
       this.regId = regId;
       this.dttId = dttId;
       this.chkIn = chkIn;
       this.chkTimestamp = chkTimestamp;
    }
   
    public Integer getChkId() {
        return this.chkId;
    }
    
    public void setChkId(Integer chkId) {
        this.chkId = chkId;
    }
    public int getRegId() {
        return this.regId;
    }
    
    public void setRegId(int regId) {
        this.regId = regId;
    }
    public int getDttId() {
        return this.dttId;
    }
    
    public void setDttId(int dttId) {
        this.dttId = dttId;
    }
    public boolean isChkIn() {
        return this.chkIn;
    }
    
    public void setChkIn(boolean chkIn) {
        this.chkIn = chkIn;
    }
    public Date getChkTimestamp() {
        return this.chkTimestamp;
    }
    
    public void setChkTimestamp(Date chkTimestamp) {
        this.chkTimestamp = chkTimestamp;
    }




}


