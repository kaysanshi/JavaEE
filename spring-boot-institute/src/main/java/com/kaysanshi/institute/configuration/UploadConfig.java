package com.kaysanshi.institute.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadConfig {
	
	@Value("${upload.path.product.img}")
	private String pimgPath;

	public String getPimgPath() {
		return pimgPath;
	}

	public void setPimgPath(String pimgPath) {
		this.pimgPath = pimgPath;
	}
}
