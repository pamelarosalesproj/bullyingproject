package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpTermmeta generated by hbm2java
 */
public class WpTermmeta  implements java.io.Serializable {


     private Long metaId;
     private long termId;
     private String metaKey;
     private String metaValue;

    public WpTermmeta() {
    }

	
    public WpTermmeta(long termId) {
        this.termId = termId;
    }
    public WpTermmeta(long termId, String metaKey, String metaValue) {
       this.termId = termId;
       this.metaKey = metaKey;
       this.metaValue = metaValue;
    }
   
    public Long getMetaId() {
        return this.metaId;
    }
    
    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }
    public long getTermId() {
        return this.termId;
    }
    
    public void setTermId(long termId) {
        this.termId = termId;
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


