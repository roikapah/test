package com.proofpoint.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScanTextRequest {
	@NotNull(message="text to scan cannot be null")
	@Size(min=2, message = "text to scan must not be less than 2 characters")
	@Size(max=4000, message = "text to scan must be up to 4000 characters")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	 
	
	
}
