package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpTermRelationships generated by hbm2java
 */
public class WpTermRelationships  implements java.io.Serializable {


     private WpTermRelationshipsId id;
     private int termOrder;

    public WpTermRelationships() {
    }

    public WpTermRelationships(WpTermRelationshipsId id, int termOrder) {
       this.id = id;
       this.termOrder = termOrder;
    }
   
    public WpTermRelationshipsId getId() {
        return this.id;
    }
    
    public void setId(WpTermRelationshipsId id) {
        this.id = id;
    }
    public int getTermOrder() {
        return this.termOrder;
    }
    
    public void setTermOrder(int termOrder) {
        this.termOrder = termOrder;
    }




}


