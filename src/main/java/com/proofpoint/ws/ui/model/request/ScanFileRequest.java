package com.proofpoint.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScanFileRequest {
	@NotNull(message="file Path to scan cannot be null")
	@Size(min=2, message = "file Path to scan must not be less than 2 characters")
	
	//windows limitation
	@Size(max=260, message = "file Path maximum length is 260")
	 
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	 
	 
	
	
}
