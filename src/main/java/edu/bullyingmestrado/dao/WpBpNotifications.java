package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * WpBpNotifications generated by hbm2java
 */
public class WpBpNotifications  implements java.io.Serializable {


     private Long id;
     private long userId;
     private long itemId;
     private Long secondaryItemId;
     private String componentName;
     private String componentAction;
     private Date dateNotified;
     private boolean isNew;

    public WpBpNotifications() {
    }

	
    public WpBpNotifications(long userId, long itemId, String componentName, String componentAction, Date dateNotified, boolean isNew) {
        this.userId = userId;
        this.itemId = itemId;
        this.componentName = componentName;
        this.componentAction = componentAction;
        this.dateNotified = dateNotified;
        this.isNew = isNew;
    }
    public WpBpNotifications(long userId, long itemId, Long secondaryItemId, String componentName, String componentAction, Date dateNotified, boolean isNew) {
       this.userId = userId;
       this.itemId = itemId;
       this.secondaryItemId = secondaryItemId;
       this.componentName = componentName;
       this.componentAction = componentAction;
       this.dateNotified = dateNotified;
       this.isNew = isNew;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getItemId() {
        return this.itemId;
    }
    
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    public Long getSecondaryItemId() {
        return this.secondaryItemId;
    }
    
    public void setSecondaryItemId(Long secondaryItemId) {
        this.secondaryItemId = secondaryItemId;
    }
    public String getComponentName() {
        return this.componentName;
    }
    
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
    public String getComponentAction() {
        return this.componentAction;
    }
    
    public void setComponentAction(String componentAction) {
        this.componentAction = componentAction;
    }
    public Date getDateNotified() {
        return this.dateNotified;
    }
    
    public void setDateNotified(Date dateNotified) {
        this.dateNotified = dateNotified;
    }
    public boolean isIsNew() {
        return this.isNew;
    }
    
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }




}


