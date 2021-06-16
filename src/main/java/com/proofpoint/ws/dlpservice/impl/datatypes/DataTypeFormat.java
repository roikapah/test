package com.proofpoint.ws.dlpservice.impl.datatypes;

public class DataTypeFormat {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getPatterns() {
		return patterns;
	}
	public void setPatterns(String   patterns) {
		//update the patterns String with regular Expression OR between the words
				this.patterns = patterns;
	}
	public String  getContextKeywords() {
		return contextKeywords;
	}
	public void setContextKeywords(String   contextKeywords) {
 
	
		this.contextKeywords = contextKeywords;
	}
	
	public String getDetectionMethods() {
		return detectionMethods;
	}
	public void setDetectionMethods(String detectionMethods) {
		this.detectionMethods = detectionMethods;
	}
	
	
	private String name;
	private String   patterns;
	private String   contextKeywords;
	private String   detectionMethods;
	
	
}
