/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.betboo.tango.net.amf;

import flex.messaging.io.amf.client.AMFConnection;
import flex.messaging.io.amf.client.exceptions.ClientStatusException;
import flex.messaging.io.amf.client.exceptions.ServerStatusException;

/**
 *
 * @author migueldiab
 */
public class JavaAMFClientImpl {

 public Object sendAMFMessage(
         final String destination, 
         final String method, 
         final String name) throws ClientStatusException, ServerStatusException {
    // Create the AMF connection.
    final AMFConnection amfConnection = new AMFConnection();
    // Connect to the remote url.
    final String url = "http://localhost:8080/Tango/messagebroker/amf";
    try {
      amfConnection.connect(url);
    } catch (final ClientStatusException cse) {
      System.out.println(cse);
      return null;
    }
    // Make a remoting call and retrieve the result.
    try {
      return amfConnection.call(destination+"."+method, name);
    } catch (final ClientStatusException cse) {
      System.out.println(cse);
      return null;
    } catch (ServerStatusException sse) {
      System.out.println(sse);
      return null;
    } finally {
      amfConnection.close();
    }
  }  
}
