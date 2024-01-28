package com.backbase;
import java.io.BufferedWriter;
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
 
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("unused")
public class JdbcSQLServerConnection {
 
    public String Connects() {
    	 
        Connection conn = null;
 
        try {
 
        	 PreparedStatement statement;
             Connection con;
             String x="0";
            
            String dbURL = System.getenv("SPRINGBOOTSQL");//"jdbc:sqlserver://132.148.185.6;encrypt=false;databaseName=poojithamssql;user=poojitha;password=Poojitha$9";           
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
            	
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                statement = conn.prepareStatement("select count(*) from FileDetails");
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    x = rs.getString(1);
                  
                }
                return x;
                //return " your Connection sucess 2 " + dm.getDatabaseProductName() + " record count : " + x.toString();
                //System.out.println("Driver name: " + dm.getDriverName());
                //System.out.println("Driver version: " + dm.getDriverVersion());
                //System.out.println("Product name: " + dm.getDatabaseProductName());
                //System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    public String ConnectsPoojitha() throws IOException {
 
    	
        Connection conn = null;
 
        try {
 
        	 PreparedStatement statement;
             Connection con;
             String x="0";
            
            String dbURL =System.getenv("SPRINGBOOTSQL");            
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
            	
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                statement = conn.prepareStatement("select count(*) from FileDetails");
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

    //@SuppressWarnings("null")
	public List<FileDetails>  FileDetails() {
    	
		 List<FileDetails> fds=new ArrayList<FileDetails>();
		 
        Connection conn = null;
        String Stage="Level 0";
 
        try {
 
        	 PreparedStatement statement;
             Connection con;
             String x="0";
            
            String dbURL = System.getenv("SPRINGBOOTSQL");             
            conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
            	 
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                statement = conn.prepareStatement("select top 10 * from FileDetails order by 1 desc");
                ResultSet resultSet = statement.executeQuery();
                Stage="Level 1";
               
                while (resultSet.next()) {
                	FileDetails fd=new FileDetails();
                	fd.fileID = resultSet.getString("FileID");
                    fd.fileNames = resultSet.getString("FileNames");
                	fd.fileUploadTime = resultSet.getString("FileUploadTime");
                    fd.fileUploadedFrom = resultSet.getString("FileUploadedFrom");                    
                    fds.add(fd);
                }
                Stage="Level 2";
                
                return fds;
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
            //return Stage + ex.getMessage();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                //return Stage + ex.getMessage();
            }
        }
        //return " your Connection failed ";
        //return "Level last";
        return fds;
    }

	 //@SuppressWarnings("null")
		public List<FileDetails>  FileGetID(String FileID) {
	    	
			 List<FileDetails> fds=new ArrayList<FileDetails>();
			 
	        Connection conn = null;
	        String Stage="Level 0";
	 
	        try {
	 
	        	 PreparedStatement statement;
	             Connection con;
	             String x="0";
	            
	            String dbURL =System.getenv("SPRINGBOOTSQL"); 
	            
	            conn = DriverManager.getConnection(dbURL);
	            if (conn != null) {
	            	 
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                statement = conn.prepareStatement("select top 10 * from FileDetails where FileID=" + Integer.valueOf(FileID) );
	                ResultSet resultSet = statement.executeQuery();
	                Stage="Level 1";
	               
	                while (resultSet.next()) {
	                	FileDetails fd=new FileDetails();
	                	fd.fileID = resultSet.getString("FileID");
	                    fd.fileNames = resultSet.getString("FileNames");
	                	fd.fileUploadTime = resultSet.getString("FileUploadTime");
	                    fd.fileUploadedFrom = resultSet.getString("FileUploadedFrom");                    
	                    fds.add(fd);
	                }
	                Stage="Level 2";
	                
	                return fds;
	            }
	 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            //return Stage + ex.getMessage();
	        } finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                //return Stage + ex.getMessage();
	            }
	        }
	        //return " your Connection failed ";
	        //return "Level last";
	        return fds;
	    }

	
	public String  FileAdd(FileDetails FileAddOne) {
    	
		 //List<FileDetails> fds=new ArrayList<FileDetails>();
	   PreparedStatement statement;
       Connection conn = null;
       String Stage="Level 0";

       try {

       	 
            Connection con;
            String x="0";
           
           String dbURL = System.getenv("SPRINGBOOTSQL");
           
           conn = DriverManager.getConnection(dbURL);
           if (conn != null) {
           	 
               DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
               statement = conn.prepareStatement("insert into FileDetails(FileNames,FileUploadTime,FileUploadedFrom) values('" + FileAddOne.fileNames + "','" + FileAddOne.fileUploadTime + "','" + FileAddOne.fileUploadedFrom +"') ");
               ResultSet resultSet = statement.executeQuery();               
               Stage="Level 1";                                                   
               return "File added";
           }

       } catch (SQLException ex) {
           ex.printStackTrace();
           //return Stage + ex.getMessage();
       } finally {
           try {
               if (conn != null && !conn.isClosed()) {
                   conn.close();
               }
           } catch (SQLException ex) {
               ex.printStackTrace();
               //return Stage + ex.getMessage();
           }
       }
       //return " your Connection failed ";
       //return "Level last";
       return "File added";
   }
	
	public void ErrorMS(Exception ex) throws IOException
	{
		 FileWriter fstream=new FileWriter("exception.txt");
         BufferedWriter out=new BufferedWriter(fstream);
         out.write(ex.toString());
         out.close();
	}


}
