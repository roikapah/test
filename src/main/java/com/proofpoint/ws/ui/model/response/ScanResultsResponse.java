package com.proofpoint.ws.ui.model.response;

public class ScanResultsResponse {
	public String[] getSensitiveDataTypes() {
		return sensitiveDataTypes;
	}

	public void setSensitiveDataTypes(String[] sensitiveDataTypes) {
		this.sensitiveDataTypes = sensitiveDataTypes;
	}

	private String [] sensitiveDataTypes;
	 
}
