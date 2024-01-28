package com.backbase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FileService {

	public RestTemplate resttemplate;
	public String saveFile(FileDetails fileDeatil)
	{
		HttpEntity<FileDetails> entity=new HttpEntity<>(fileDeatil);
		return resttemplate.exchange("http://4.255.25.216:8080/backbase/FileAdd", HttpMethod.POST,  entity, String.class).getBody();						
	}
	
	@SuppressWarnings("unchecked")
	public List<FileDetails> listFile()
	{		
		return resttemplate.exchange("http://4.255.25.216:8080/backbase/FileList", HttpMethod.GET,  null, List.class).getBody();						
	}

	@Autowired
	public  FileService(RestTemplateBuilder resttemplatebuilder) {
		resttemplate=resttemplatebuilder.build();
	}
	
	
	
	
	
}
