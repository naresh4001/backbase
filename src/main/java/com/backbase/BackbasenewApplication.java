package com.backbase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.List;

//import java.sql.ResultSet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings("unused")
@SpringBootApplication
@RestController
@RequestMapping("/backbase")
public class BackbasenewApplication {

	
	@GetMapping("/FileCount")
	public String getFileCount()
	{
		//return "Dears, my first micro service on Azure cloud Kubernetes service ";
		JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
		return  "File Count : " + connts.Connects() ;
	}

	//http://localhost:8080/api/message
	@GetMapping("/FileList")
	public List<FileDetails> getFileList()
	{
			JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
			return  connts.FileDetails() ;	
		
	}
	
	//http://localhost:8080/api/message
	@GetMapping("/FileID/{id}")
	public List<FileDetails> getFile(@PathVariable("id") String FileID)
	{
		
			JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
			return  connts.FileGetID(FileID) ;
		
		
	}
	
	//http://localhost:8080/api/employee/naresh
	@GetMapping("/all/{id}")
	public String getEmployee(@PathVariable("id") String name1)
	{
		JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
		//return "First micro service on Azure cloud Kubernetes service developed by : " + name1 + connts.Connects() ;
		return  "Test";//connts.FileDetails() ;
	}
	
	@PostMapping("/FileAdd")
	public String addFile(@RequestBody FileDetails FileDeatils) 
	{
		 try
		 {
			JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
		    return connts.FileAdd(FileDeatils);
		    
	     } 
			 catch (Exception ex) 
		 {
		        
		        return ex.getMessage();
	     }
	    
	}
	
	@PostMapping("/FileAddList")
	public String addFileList(@RequestBody List<FileDetails> FileDeatil) 
	{
	 
		 try
		 {
			 String status1="";
			  Iterator<FileDetails> it = FileDeatil.iterator();
			  JdbcSQLServerConnection connts=new JdbcSQLServerConnection();
		      while(it.hasNext()) 
		      {
		    	  //FileDetails FDSO=new FileDetails();
		    	  
		    	  status1=connts.FileAdd(it.next());
		         //System.out.println(it.next());
		      }
			
		    //return connts.FileAdd(FileDeatils);
			return status1;
		    
	     } 
			 catch (Exception ex) 
		 {
		        
		        return ex.getMessage();
	     }
	    
	}
	
	@GetMapping("/add/{id}")
	public String getadd(@PathVariable("id") String num1)
	{
		
		
		try
		 {
			ExceptionHandling connts=new ExceptionHandling();
		    return connts.ConnectsPoojitha();
		    
	     } 
		
		catch (Exception ex) 
		 {
		        
		        return ex.getMessage();
	     }
		
	}
	
	@GetMapping("/systemenv")
	public String getEnv() throws UnknownHostException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		InetAddress localhost = InetAddress.getLocalHost();
		//return "Hello friends Current system Date Time : " + timeStamp + "\n : Local IP : " + localhost.getHostAddress().trim();
		return System.getenv("JAVA_HOME")+ "\n : SPINGBOOTSQL : " + System.getenv("SPRINGBOOTSQL") + "\n : Local IP : " + localhost.getHostAddress().trim();
	   
	}
	
	@Autowired
	private FileService fservice;
	
	@PostMapping("/FileAddApp")
	public String addFileApp(@RequestBody FileDetails FileDeatils) 
	{
		 try
		 {			
		    return fservice.saveFile(FileDeatils);		    
	     } 
			 catch (Exception ex) 
		 {		       
		        return ex.getMessage();
	     }
	    
	}
	
	@GetMapping("/FileListApp")
	public List<FileDetails> getFileListApp()
	{			
			return  fservice.listFile();
	}
	
	@GetMapping("/Filestatic")
	public String getFiletest() throws UnknownHostException
	{		

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			InetAddress localhost = InetAddress.getLocalHost();
			ABC objs=ABC.getInstance();
			return  objs.Firstname +" " + objs.Lastname +"\n  First request date time : " + objs.DaTime +"\n  Hello friends Current system Date Time : " + timeStamp + "\n : Local IP : " + localhost.getHostAddress().trim() ;
	}
	
	  @Autowired
	    private NumberService numberService;

	    @GetMapping(path = "/square/{number}")
	    public String getSquare(@PathVariable Long number) {
	        //log.info("call numberService to square {}", number);
	        return String.format("{\"square\": %s}", numberService.square(number));
	    }
	    
		@GetMapping("/nareshtest")
		public String getIp() throws UnknownHostException
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			InetAddress localhost = InetAddress.getLocalHost();
			return "Hello friends Current system Date Time : " + timeStamp + "\n : Local IP : " + localhost.getHostAddress().trim();
					//System.getenv("JAVA_HOME")+ "\n : SPINGBOOTSQL : " + System.getenv("SPRINGBOOTSQL") + "\n : Local IP : " + localhost.getHostAddress().trim();
		   
		}
	
	public static void main(String[] args) {
		SpringApplication.run(BackbasenewApplication.class, args);
	}

}
