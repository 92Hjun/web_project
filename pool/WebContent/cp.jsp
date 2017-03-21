<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	Context initContext = new InitialContext();
	DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
	
	Connection con = ds.getConnection();
%>