package com.backbase;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileDetails{
    @JsonProperty("FileID") 
    public String fileID;
    @JsonProperty("FileNames") 
    public String fileNames;
    @JsonProperty("FileUploadTime") 
    public String fileUploadTime;
    @JsonProperty("FileUploadedFrom") 
    public String fileUploadedFrom;
}