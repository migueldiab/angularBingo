package com.betboo.tango.net;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author migueldiab
 */
public class Round implements Serializable {
  
  private Integer id;
  private String name;
  private Date time;
  private List<String> prizes;
  private List<Prize> newPrizes = new ArrayList<Prize>();

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

  public List<String> getPrizes() {
    return prizes;
  }

  public void setPrizes(List<String> prizes) {
    this.prizes = prizes;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public List<Prize> getNewPrizes() {
    return newPrizes;
  }

  public void setNewPrizes(List<Prize> newPrizes) {
    this.newPrizes = newPrizes;
  }

  public void addPrize(final Prize aPrize) {
    newPrizes.add(aPrize);
  }
  
}
