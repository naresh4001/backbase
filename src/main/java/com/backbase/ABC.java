package com.backbase;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ABC {
	
	public static ABC abcs;
	String Firstname;
	String Lastname;
	String DaTime;
	private ABC()
	{
		
	}
	
	public static synchronized ABC getInstance()
	{
		if(abcs==null)
		{
			abcs=new ABC();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			abcs.Firstname="Naresh Babu";
			abcs.Lastname="Nuthalapati";	
			abcs.DaTime=timeStamp;
		}
		return abcs;
	}

}
