package com.proofpoint.ws.dlpservice.impl.datatypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DetectionMethodEnum {
	DIGITS_PATTERN,CONTEXT_KEYWORDS,CHECKSUM;
	
	
	
	
	
	public boolean match(DataTypeFormat dtf ,String text) {
		String patternsInput=null;
		Pattern pattern =null;
		Matcher matcher =null;
		switch(this) {
		case DIGITS_PATTERN:
			
			   patternsInput=dtf.getPatterns().replaceAll(",", "|").replaceAll("d","\\\\d");
			 
			  pattern = Pattern.compile(patternsInput);
			  matcher = pattern.matcher(text);

			return matcher.find(0);
		
		case CONTEXT_KEYWORDS:
			 patternsInput="(?i)"+dtf.getContextKeywords().replaceAll(",", "|");

				pattern = Pattern.compile(patternsInput);
				 matcher = pattern.matcher(text);
				 return matcher.find(0);
				 
		case CHECKSUM:
			//TBD
			return true;
		default:
			break;
		}
		return false;
	}
}
