package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpBpActivityMeta generated by hbm2java
 */
public class WpBpActivityMeta  implements java.io.Serializable {


     private Long id;
     private long activityId;
     private String metaKey;
     private String metaValue;

    public WpBpActivityMeta() {
    }

	
    public WpBpActivityMeta(long activityId) {
        this.activityId = activityId;
    }
    public WpBpActivityMeta(long activityId, String metaKey, String metaValue) {
       this.activityId = activityId;
       this.metaKey = metaKey;
       this.metaValue = metaValue;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getActivityId() {
        return this.activityId;
    }
    
    public void setActivityId(long activityId) {
        this.activityId = activityId;
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


