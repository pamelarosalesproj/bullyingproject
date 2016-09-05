package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpLayerslider generated by hbm2java
 */
public class WpLayerslider  implements java.io.Serializable {


     private Integer id;
     private int author;
     private String name;
     private String slug;
     private String data;
     private int dateC;
     private int dateM;
     private boolean flagHidden;
     private boolean flagDeleted;

    public WpLayerslider() {
    }

    public WpLayerslider(int author, String name, String slug, String data, int dateC, int dateM, boolean flagHidden, boolean flagDeleted) {
       this.author = author;
       this.name = name;
       this.slug = slug;
       this.data = data;
       this.dateC = dateC;
       this.dateM = dateM;
       this.flagHidden = flagHidden;
       this.flagDeleted = flagDeleted;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getAuthor() {
        return this.author;
    }
    
    public void setAuthor(int author) {
        this.author = author;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSlug() {
        return this.slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    public int getDateC() {
        return this.dateC;
    }
    
    public void setDateC(int dateC) {
        this.dateC = dateC;
    }
    public int getDateM() {
        return this.dateM;
    }
    
    public void setDateM(int dateM) {
        this.dateM = dateM;
    }
    public boolean isFlagHidden() {
        return this.flagHidden;
    }
    
    public void setFlagHidden(boolean flagHidden) {
        this.flagHidden = flagHidden;
    }
    public boolean isFlagDeleted() {
        return this.flagDeleted;
    }
    
    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }




}

