<%-- 
    Document   : callAMF
    Created on : 30-may-2012, 12:11:22
    Author     : migueldiab
--%>
<%@page import="com.betboo.tango.net.Round"%>
<%@ page language="java" %>

<%@page import="com.betboo.tango.net.amf.JavaAMFClientImpl"%>
 
<%
  final String destination=request.getParameter("destination");
  final String method=request.getParameter("method");
  final String name=request.getParameter("name");

  final JavaAMFClientImpl javaAMFClientService = new JavaAMFClientImpl();
  final Object obj = javaAMFClientService.sendAMFMessage(destination, method, name);
  final Round round = (Round) obj;
%>

<%= round.getId()  %>
<%= round.getName()  %>
<%= round.getTime()  %>
<%= round.getPrizes()  %>