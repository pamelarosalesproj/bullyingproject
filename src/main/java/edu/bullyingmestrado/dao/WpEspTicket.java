package edu.bullyingmestrado.dao;
// Generated 01/09/2016 05:04:57 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * WpEspTicket generated by hbm2java
 */
public class WpEspTicket  implements java.io.Serializable {


     private Integer tktId;
     private int ttmId;
     private String tktName;
     private String tktDescription;
     private Integer tktQty;
     private int tktSold;
     private byte tktUses;
     private byte tktRequired;
     private byte tktMin;
     private byte tktMax;
     private BigDecimal tktPrice;
     private Date tktStartDate;
     private Date tktEndDate;
     private boolean tktTaxable;
     private byte tktOrder;
     private byte tktRow;
     private boolean tktIsDefault;
     private Long tktWpUser;
     private Integer tktParent;
     private boolean tktDeleted;

    public WpEspTicket() {
    }

	
    public WpEspTicket(int ttmId, String tktName, String tktDescription, int tktSold, byte tktUses, byte tktRequired, byte tktMin, byte tktMax, BigDecimal tktPrice, Date tktStartDate, Date tktEndDate, boolean tktTaxable, byte tktOrder, byte tktRow, boolean tktIsDefault, boolean tktDeleted) {
        this.ttmId = ttmId;
        this.tktName = tktName;
        this.tktDescription = tktDescription;
        this.tktSold = tktSold;
        this.tktUses = tktUses;
        this.tktRequired = tktRequired;
        this.tktMin = tktMin;
        this.tktMax = tktMax;
        this.tktPrice = tktPrice;
        this.tktStartDate = tktStartDate;
        this.tktEndDate = tktEndDate;
        this.tktTaxable = tktTaxable;
        this.tktOrder = tktOrder;
        this.tktRow = tktRow;
        this.tktIsDefault = tktIsDefault;
        this.tktDeleted = tktDeleted;
    }
    public WpEspTicket(int ttmId, String tktName, String tktDescription, Integer tktQty, int tktSold, byte tktUses, byte tktRequired, byte tktMin, byte tktMax, BigDecimal tktPrice, Date tktStartDate, Date tktEndDate, boolean tktTaxable, byte tktOrder, byte tktRow, boolean tktIsDefault, Long tktWpUser, Integer tktParent, boolean tktDeleted) {
       this.ttmId = ttmId;
       this.tktName = tktName;
       this.tktDescription = tktDescription;
       this.tktQty = tktQty;
       this.tktSold = tktSold;
       this.tktUses = tktUses;
       this.tktRequired = tktRequired;
       this.tktMin = tktMin;
       this.tktMax = tktMax;
       this.tktPrice = tktPrice;
       this.tktStartDate = tktStartDate;
       this.tktEndDate = tktEndDate;
       this.tktTaxable = tktTaxable;
       this.tktOrder = tktOrder;
       this.tktRow = tktRow;
       this.tktIsDefault = tktIsDefault;
       this.tktWpUser = tktWpUser;
       this.tktParent = tktParent;
       this.tktDeleted = tktDeleted;
    }
   
    public Integer getTktId() {
        return this.tktId;
    }
    
    public void setTktId(Integer tktId) {
        this.tktId = tktId;
    }
    public int getTtmId() {
        return this.ttmId;
    }
    
    public void setTtmId(int ttmId) {
        this.ttmId = ttmId;
    }
    public String getTktName() {
        return this.tktName;
    }
    
    public void setTktName(String tktName) {
        this.tktName = tktName;
    }
    public String getTktDescription() {
        return this.tktDescription;
    }
    
    public void setTktDescription(String tktDescription) {
        this.tktDescription = tktDescription;
    }
    public Integer getTktQty() {
        return this.tktQty;
    }
    
    public void setTktQty(Integer tktQty) {
        this.tktQty = tktQty;
    }
    public int getTktSold() {
        return this.tktSold;
    }
    
    public void setTktSold(int tktSold) {
        this.tktSold = tktSold;
    }
    public byte getTktUses() {
        return this.tktUses;
    }
    
    public void setTktUses(byte tktUses) {
        this.tktUses = tktUses;
    }
    public byte getTktRequired() {
        return this.tktRequired;
    }
    
    public void setTktRequired(byte tktRequired) {
        this.tktRequired = tktRequired;
    }
    public byte getTktMin() {
        return this.tktMin;
    }
    
    public void setTktMin(byte tktMin) {
        this.tktMin = tktMin;
    }
    public byte getTktMax() {
        return this.tktMax;
    }
    
    public void setTktMax(byte tktMax) {
        this.tktMax = tktMax;
    }
    public BigDecimal getTktPrice() {
        return this.tktPrice;
    }
    
    public void setTktPrice(BigDecimal tktPrice) {
        this.tktPrice = tktPrice;
    }
    public Date getTktStartDate() {
        return this.tktStartDate;
    }
    
    public void setTktStartDate(Date tktStartDate) {
        this.tktStartDate = tktStartDate;
    }
    public Date getTktEndDate() {
        return this.tktEndDate;
    }
    
    public void setTktEndDate(Date tktEndDate) {
        this.tktEndDate = tktEndDate;
    }
    public boolean isTktTaxable() {
        return this.tktTaxable;
    }
    
    public void setTktTaxable(boolean tktTaxable) {
        this.tktTaxable = tktTaxable;
    }
    public byte getTktOrder() {
        return this.tktOrder;
    }
    
    public void setTktOrder(byte tktOrder) {
        this.tktOrder = tktOrder;
    }
    public byte getTktRow() {
        return this.tktRow;
    }
    
    public void setTktRow(byte tktRow) {
        this.tktRow = tktRow;
    }
    public boolean isTktIsDefault() {
        return this.tktIsDefault;
    }
    
    public void setTktIsDefault(boolean tktIsDefault) {
        this.tktIsDefault = tktIsDefault;
    }
    public Long getTktWpUser() {
        return this.tktWpUser;
    }
    
    public void setTktWpUser(Long tktWpUser) {
        this.tktWpUser = tktWpUser;
    }
    public Integer getTktParent() {
        return this.tktParent;
    }
    
    public void setTktParent(Integer tktParent) {
        this.tktParent = tktParent;
    }
    public boolean isTktDeleted() {
        return this.tktDeleted;
    }
    
    public void setTktDeleted(boolean tktDeleted) {
        this.tktDeleted = tktDeleted;
    }




}

