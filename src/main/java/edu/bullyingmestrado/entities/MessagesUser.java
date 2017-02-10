/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bullyingmestrado.entities;


/**
 *
 * @author pamela
 */
public class MessagesUser  implements java.io.Serializable{

    private String userLogin;
    private String displayName;
    private Long id;
    private Long secondaryItemId;
    private String content;

     public MessagesUser(){
     }
     
    public MessagesUser(String userLogin, String displayName, Long id, Long secondaryItemId, String content) {
        this.userLogin = userLogin;
        this.displayName = displayName;
        this.id = id;
        this.secondaryItemId = secondaryItemId;
        this.content = content;
    }
    
    
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecondaryItemId() {
        return secondaryItemId;
    }

    public void setSecondaryItemId(Long secondaryItemId) {
        this.secondaryItemId = secondaryItemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
