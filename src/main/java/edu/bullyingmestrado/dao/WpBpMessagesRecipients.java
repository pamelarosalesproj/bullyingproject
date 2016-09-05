package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1



/**
 * WpBpMessagesRecipients generated by hbm2java
 */
public class WpBpMessagesRecipients  implements java.io.Serializable {


     private Long id;
     private long userId;
     private long threadId;
     private int unreadCount;
     private boolean senderOnly;
     private boolean isDeleted;

    public WpBpMessagesRecipients() {
    }

    public WpBpMessagesRecipients(long userId, long threadId, int unreadCount, boolean senderOnly, boolean isDeleted) {
       this.userId = userId;
       this.threadId = threadId;
       this.unreadCount = unreadCount;
       this.senderOnly = senderOnly;
       this.isDeleted = isDeleted;
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
    public long getThreadId() {
        return this.threadId;
    }
    
    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }
    public int getUnreadCount() {
        return this.unreadCount;
    }
    
    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
    public boolean isSenderOnly() {
        return this.senderOnly;
    }
    
    public void setSenderOnly(boolean senderOnly) {
        this.senderOnly = senderOnly;
    }
    public boolean isIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }




}


