package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpBpNotificationsMeta generated by hbm2java
 */
public class WpBpNotificationsMeta  implements java.io.Serializable {


     private Long id;
     private long notificationId;
     private String metaKey;
     private String metaValue;

    public WpBpNotificationsMeta() {
    }

	
    public WpBpNotificationsMeta(long notificationId) {
        this.notificationId = notificationId;
    }
    public WpBpNotificationsMeta(long notificationId, String metaKey, String metaValue) {
       this.notificationId = notificationId;
       this.metaKey = metaKey;
       this.metaValue = metaValue;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getNotificationId() {
        return this.notificationId;
    }
    
    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }
    public String getMetaKey() {
        return this.metaKey;
    }
    
    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }
    public String getMetaValue() {
        return this.metaValue;
    }
    
    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }




}


