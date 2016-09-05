package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * WpBpMessagesNotices generated by hbm2java
 */
public class WpBpMessagesNotices  implements java.io.Serializable {


     private Long id;
     private String subject;
     private String message;
     private Date dateSent;
     private boolean isActive;

    public WpBpMessagesNotices() {
    }

    public WpBpMessagesNotices(String subject, String message, Date dateSent, boolean isActive) {
       this.subject = subject;
       this.message = message;
       this.dateSent = dateSent;
       this.isActive = isActive;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDateSent() {
        return this.dateSent;
    }
    
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
    public boolean isIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }




}

