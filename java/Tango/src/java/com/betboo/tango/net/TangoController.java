package com.betboo.tango.net;

import java.util.*;

/**
 *
 * @author migueldiab
 */
public class TangoController {
  private static final TangoController instance = new TangoController();

  private TangoController() {
    
  }

  public static TangoController getInstance() {
    return instance;
  }
  
  
  private Round results = new Round();
  private String string = "Test String";

  public Round getResults() {
    Integer rand = new Random().nextInt();
    results.setId(rand);
    results.setName("The Round ");
    results.setTime(new Date());
    return results;
  }
  public Round getResults(final String parameter) {
    Integer rand = new Random().nextInt();
    results.setId(rand);
    results.setName("The Round " + parameter);
    results.setTime(new Date());
    List<String> newList = new ArrayList();
    newList.add("BINGO");
    newList.add("LINE");
    newList.add("DOUBLE");
    results.setPrizes(newList);
    
  
    results.setNewPrizes(new ArrayList<Prize>());
    Prize aPrize = new Prize();
    aPrize.setId(new Random().nextInt(100));
    aPrize.setName("BINGO");
    aPrize.setCurrency(Currency.getInstance("BRL"));
    aPrize.setAmount(new Random().nextDouble());
    results.addPrize(aPrize);
    aPrize = new Prize();
    aPrize.setId(new Random().nextInt(100));
    aPrize.setName("LINE");
    aPrize.setCurrency(Currency.getInstance("BRL"));
    aPrize.setAmount(new Random().nextDouble());
    results.addPrize(aPrize);
    aPrize = new Prize();
    aPrize.setId(new Random().nextInt(100));
    aPrize.setName("DOUBLE");
    aPrize.setCurrency(Currency.getInstance("BRL"));
    aPrize.setAmount(new Random().nextDouble());
    results.addPrize(aPrize);
        
    return results;
  }

  public void setResults(Round results) {
    this.results = results;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }
  
  
}
