package com.betboo.tango.net.amf;

import com.betboo.tango.net.Prize;
import com.betboo.tango.net.Round;
import com.betboo.tango.net.TangoController;
import flex.messaging.io.MessageIOConstants;
import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.ActionMessage;
import flex.messaging.io.amf.AmfMessageSerializer;
import flex.messaging.io.amf.AmfTrace;
import flex.messaging.io.amf.MessageBody;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author migueldiab
 */
public class AMFServlet extends HttpServlet {

  private Round results = new Round();

  public Round getResults() {
    Integer rand = new Random().nextInt(100000);
    results.setId(rand);
    results.setName("The Round " + rand);
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
  
  @Override
  public void doGet(
          HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
      response.setHeader("Content-Type", "application/html");
      final ServletOutputStream out = response.getOutputStream();
      out.print("GET Not Supported");
      out.close();
  }

  @Override
  protected void doPost(
          HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    response.setHeader("Content-Type", "application/x-amf;charset=x-user-defined");
    final Map<String, String[]> parameterMap = request.getParameterMap();
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      System.out.println("Key : " + entry.getKey());
      for (String string : entry.getValue()) {
        System.out.println("Value : " + string);
      }
      
    }
    final String methodName = parameterMap.get("method")[0];
    final String parm1 = parameterMap.get("parm")[0];
    Method method = null;
    Object result = null;
    try {
      method = TangoController.class.getMethod(methodName, String.class);
    } catch (NoSuchMethodException ex) {
      Logger.getLogger(AMFServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(AMFServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      result = method.invoke(TangoController.getInstance(), parm1);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(AMFServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(AMFServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(AMFServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    final ServletOutputStream out = response.getOutputStream();

    final MessageBody amfMessage = new MessageBody();      
    amfMessage.setData(result);

    final ActionMessage requestMessage = new ActionMessage();
    requestMessage.setVersion(MessageIOConstants.AMF3);
    requestMessage.addBody(amfMessage);

    final AmfMessageSerializer amfMessageSerializer = new AmfMessageSerializer();
    amfMessageSerializer.initialize(
            SerializationContext.getSerializationContext(), 
            out, 
            new AmfTrace());
    amfMessageSerializer.writeMessage(requestMessage);
    out.close();
  }
  
  
  
}
