package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpTermTaxonomy generated by hbm2java
 */
public class WpTermTaxonomy  implements java.io.Serializable {


     private Long termTaxonomyId;
     private long termId;
     private String taxonomy;
     private String description;
     private long parent;
     private long count;

    public WpTermTaxonomy() {
    }

    public WpTermTaxonomy(long termId, String taxonomy, String description, long parent, long count) {
       this.termId = termId;
       this.taxonomy = taxonomy;
       this.description = description;
       this.parent = parent;
       this.count = count;
    }
   
    public Long getTermTaxonomyId() {
        return this.termTaxonomyId;
    }
    
    public void setTermTaxonomyId(Long termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }
    public long getTermId() {
        return this.termId;
    }
    
    public void setTermId(long termId) {
        this.termId = termId;
    }
    public String getTaxonomy() {
        return this.taxonomy;
    }
    
    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public long getParent() {
        return this.parent;
    }
    
    public void setParent(long parent) {
        this.parent = parent;
    }
    public long getCount() {
        return this.count;
    }
    
    public void setCount(long count) {
        this.count = count;
    }




}

