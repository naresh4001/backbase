package com.backbase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import graphql.org.antlr.v4.runtime.IntStream;
import java.util.stream.IntStream;
 
@SuppressWarnings("unused")
public class ExceptionHandling {

	 public String ConnectsPoojitha() throws IOException {
		 
	    	
	        Connection conn = null;
	 
	        try {
	 
	        	 PreparedStatement statement;
	             Connection con;
	             String x="0";
	            
	            String dbURL = "jdbc:sqlserver://132.148.185.6;encrypt=false;databaseName=poojithamssql;user=poojitha;password=Poojitha$9";           
	            conn = DriverManager.getConnection(dbURL);
	            if (conn != null) {
	            	
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                statement = conn.prepareStatement("select count(*) from FileDetailsd");
	                ResultSet rs = statement.executeQuery();
	                while (rs.next()) {
	                    x = rs.getString(1);
	                  
	                }
	                return x;
	               
	            }
	 
	        } catch (SQLException ex) {
	        	ErrorMS(ex);
	        } finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        //return " your Connection failed ";
			return null;
	    }
	 
	 public void ErrorMS(Exception ex) throws IOException
		{
		 	 File file = new File("exception.txt");
			 FileWriter fstream=new FileWriter(file,true);
	         BufferedWriter out=new BufferedWriter(fstream);
	         out.append("\n" + ex.toString());
	         out.close();
		}


}
