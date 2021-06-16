package com.proofpoint.ws.dlpservice.impl;

 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofpoint.ws.dlpservice.DlpService;
import com.proofpoint.ws.dlpservice.impl.datatypes.DataTypeFormat;
import com.proofpoint.ws.dlpservice.impl.datatypes.DetectionMethodEnum;
import com.proofpoint.ws.dlpservice.impl.datatypes.SensitiveDataTypesFormat;
import com.proofpoint.ws.shared.Utils;

 
@Service
public class DlpServiceImpl implements DlpService{
	private static final Logger logger = LogManager.getLogger(DlpServiceImpl.class);
	 
	Utils utils;
	
	@Autowired
	SensitiveDataTypesFormat dataTypesFormat;
	
	
	public DlpServiceImpl() {}
	
	@Autowired
	public DlpServiceImpl(Utils utils)
	{
		this.utils =utils;
	}

	@Override
	public String[] scanText(String text) {
		logger.debug("scanText:" +text);
		 //".*Ariel.*|.*Sleeping Beauty.*"
		List <String > dataTypesFoundList=new ArrayList<String>();

		for (DataTypeFormat dtf:dataTypesFormat.getDataTypesFormat()) {
			
		 	String []detectionMethods=dtf.getDetectionMethods().split(",");
		 	boolean dataTypeFound=true;
		 	//check by all the detection methods of this Data Type
			for (String method:detectionMethods) {
				DetectionMethodEnum dm = DetectionMethodEnum.valueOf(method);
				boolean patternFound=DetectionMethodEnum.valueOf(method).match(dtf, text);
			    if( patternFound) {
			    	logger.debug("pattern Found for method " +dm);
			    }
			    else {
			    	dataTypeFound=false;
			    	break;
			    }
			    
			}
			if(dataTypeFound)
			  dataTypesFoundList.add(dtf.getName());
			
			
//			 String patternsInput=dtf.getPatterns().replaceAll(",", "|").replaceAll("d","\\\\d");
//			 
//			Pattern pattern = Pattern.compile(patternsInput);
//			Matcher matcher = pattern.matcher(text);
// 
//			if(matcher.find(0)) {
// 				
// 				 patternsInput="(?i)"+dtf.getContextKeywords().replaceAll(",", "|");
//
//				pattern = Pattern.compile(patternsInput);
//				 matcher = pattern.matcher(text);
//				 if(matcher.find(0)) {
//					 dataTypesFoundList.add(dtf.getName());
//				 }
//			}
		}
		
		logger.debug("dataTypesFoundList:" +dataTypesFoundList);
		
		return dataTypesFoundList.toArray(new String[dataTypesFoundList.size()]);
	}

	@Override
	public String[] scanFile(String filePath) throws IOException {
		
		String data =   new String(Files.readAllBytes(Paths.get(filePath)));
		scanText(  data);
		return scanText(  data);
	}
	 
	
 

}
