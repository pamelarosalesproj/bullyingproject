package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * WpBpFriends generated by hbm2java
 */
public class WpBpFriends  implements java.io.Serializable {


     private Long id;
     private long initiatorUserId;
     private long friendUserId;
     private Boolean isConfirmed;
     private Boolean isLimited;
     private Date dateCreated;

    public WpBpFriends() {
    }

	
    public WpBpFriends(long initiatorUserId, long friendUserId, Date dateCreated) {
        this.initiatorUserId = initiatorUserId;
        this.friendUserId = friendUserId;
        this.dateCreated = dateCreated;
    }
    public WpBpFriends(long initiatorUserId, long friendUserId, Boolean isConfirmed, Boolean isLimited, Date dateCreated) {
       this.initiatorUserId = initiatorUserId;
       this.friendUserId = friendUserId;
       this.isConfirmed = isConfirmed;
       this.isLimited = isLimited;
       this.dateCreated = dateCreated;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getInitiatorUserId() {
        return this.initiatorUserId;
    }
    
    public void setInitiatorUserId(long initiatorUserId) {
        this.initiatorUserId = initiatorUserId;
    }
    public long getFriendUserId() {
        return this.friendUserId;
    }
    
    public void setFriendUserId(long friendUserId) {
        this.friendUserId = friendUserId;
    }
    public Boolean getIsConfirmed() {
        return this.isConfirmed;
    }
    
    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
    public Boolean getIsLimited() {
        return this.isLimited;
    }
    
    public void setIsLimited(Boolean isLimited) {
        this.isLimited = isLimited;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }




}


