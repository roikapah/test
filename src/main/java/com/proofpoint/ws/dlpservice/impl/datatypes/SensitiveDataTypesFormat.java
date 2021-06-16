package com.proofpoint.ws.dlpservice.impl.datatypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Component;
 
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Component
public class SensitiveDataTypesFormat {

	 

	public SensitiveDataTypesFormat() {
		super();
		Gson gson = new Gson(); // Or use new GsonBuilder().create();;
		
		try  {
			File file = ResourceUtils.getFile("classpath:SensitiveDataTypesFormat.json");

					//Read File Content
					String json = new String(Files.readAllBytes(file.toPath()));
					 
			
					dataTypesFormat = gson.fromJson(json, DataTypeFormat[].class);
//					for (DataTypeFormat dtf:dataTypesFormat) {
//						//update the Keywords String with regular Expression OR between the words
//						dtf.setPatterns(dtf.getPatterns().replaceAll(",", "|").replaceAll("d","\\d"));
//						dtf.setContextKeywords(dtf.getContextKeywords().replaceAll(",", "|"));
//
//					}
					 
					System.out.println();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	DataTypeFormat [] dataTypesFormat;
	
	
	public DataTypeFormat[] getDataTypesFormat() {
		return dataTypesFormat;
	}


	public void setDataTypesFormat(DataTypeFormat[] dataTypesFormat) {
		this.dataTypesFormat = dataTypesFormat;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
