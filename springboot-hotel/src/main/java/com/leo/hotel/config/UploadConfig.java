package com.leo.hotel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadConfig {
	@Value("${upload.path.hotel.img}")
	private String pimgPath;

	public String getPimgPath(){
		return pimgPath;
	}

	public void setPimgPath(String pimgPath){
		this.pimgPath = pimgPath;
	}
}
