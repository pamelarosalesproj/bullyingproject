package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpPostmeta generated by hbm2java
 */
public class WpPostmeta  implements java.io.Serializable {


     private Long metaId;
     private long postId;
     private String metaKey;
     private String metaValue;

    public WpPostmeta() {
    }

	
    public WpPostmeta(long postId) {
        this.postId = postId;
    }
    public WpPostmeta(long postId, String metaKey, String metaValue) {
       this.postId = postId;
       this.metaKey = metaKey;
       this.metaValue = metaValue;
    }
   
    public Long getMetaId() {
        return this.metaId;
    }
    
    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }
    public long getPostId() {
        return this.postId;
    }
    
    public void setPostId(long postId) {
        this.postId = postId;
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


