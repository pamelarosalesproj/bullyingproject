package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpEspQuestionGroup generated by hbm2java
 */
public class WpEspQuestionGroup  implements java.io.Serializable {


     private Integer qsgId;
     private String qsgName;
     private String qsgIdentifier;
     private String qsgDesc;
     private byte qsgOrder;
     private boolean qsgShowGroupName;
     private boolean qsgShowGroupDesc;
     private Byte qsgSystem;
     private boolean qsgDeleted;
     private Long qsgWpUser;

    public WpEspQuestionGroup() {
    }

	
    public WpEspQuestionGroup(String qsgName, String qsgIdentifier, byte qsgOrder, boolean qsgShowGroupName, boolean qsgShowGroupDesc, boolean qsgDeleted) {
        this.qsgName = qsgName;
        this.qsgIdentifier = qsgIdentifier;
        this.qsgOrder = qsgOrder;
        this.qsgShowGroupName = qsgShowGroupName;
        this.qsgShowGroupDesc = qsgShowGroupDesc;
        this.qsgDeleted = qsgDeleted;
    }
    public WpEspQuestionGroup(String qsgName, String qsgIdentifier, String qsgDesc, byte qsgOrder, boolean qsgShowGroupName, boolean qsgShowGroupDesc, Byte qsgSystem, boolean qsgDeleted, Long qsgWpUser) {
       this.qsgName = qsgName;
       this.qsgIdentifier = qsgIdentifier;
       this.qsgDesc = qsgDesc;
       this.qsgOrder = qsgOrder;
       this.qsgShowGroupName = qsgShowGroupName;
       this.qsgShowGroupDesc = qsgShowGroupDesc;
       this.qsgSystem = qsgSystem;
       this.qsgDeleted = qsgDeleted;
       this.qsgWpUser = qsgWpUser;
    }
   
    public Integer getQsgId() {
        return this.qsgId;
    }
    
    public void setQsgId(Integer qsgId) {
        this.qsgId = qsgId;
    }
    public String getQsgName() {
        return this.qsgName;
    }
    
    public void setQsgName(String qsgName) {
        this.qsgName = qsgName;
    }
    public String getQsgIdentifier() {
        return this.qsgIdentifier;
    }
    
    public void setQsgIdentifier(String qsgIdentifier) {
        this.qsgIdentifier = qsgIdentifier;
    }
    public String getQsgDesc() {
        return this.qsgDesc;
    }
    
    public void setQsgDesc(String qsgDesc) {
        this.qsgDesc = qsgDesc;
    }
    public byte getQsgOrder() {
        return this.qsgOrder;
    }
    
    public void setQsgOrder(byte qsgOrder) {
        this.qsgOrder = qsgOrder;
    }
    public boolean isQsgShowGroupName() {
        return this.qsgShowGroupName;
    }
    
    public void setQsgShowGroupName(boolean qsgShowGroupName) {
        this.qsgShowGroupName = qsgShowGroupName;
    }
    public boolean isQsgShowGroupDesc() {
        return this.qsgShowGroupDesc;
    }
    
    public void setQsgShowGroupDesc(boolean qsgShowGroupDesc) {
        this.qsgShowGroupDesc = qsgShowGroupDesc;
    }
    public Byte getQsgSystem() {
        return this.qsgSystem;
    }
    
    public void setQsgSystem(Byte qsgSystem) {
        this.qsgSystem = qsgSystem;
    }
    public boolean isQsgDeleted() {
        return this.qsgDeleted;
    }
    
    public void setQsgDeleted(boolean qsgDeleted) {
        this.qsgDeleted = qsgDeleted;
    }
    public Long getQsgWpUser() {
        return this.qsgWpUser;
    }
    
    public void setQsgWpUser(Long qsgWpUser) {
        this.qsgWpUser = qsgWpUser;
    }




}


