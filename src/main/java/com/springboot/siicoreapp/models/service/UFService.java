package com.springboot.siicoreapp.models.service;


import org.springframework.web.multipart.MultipartFile;


public interface UFService {
	
	public boolean saveDataFromUploadFile(MultipartFile file);
	
}


