package com.betboo.tango.net;

import java.util.Currency;

/**
 *
 * @author migueldiab
 */
public class Prize {
  private static final String objType = "Prize";
  private Integer id;
  private String name;
  private Double amount;
  private Currency currency;

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getObjType() {
    return objType;
  }
  
  public void setObjType(String type) {
    
  }
  
   
  
}
