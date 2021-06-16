package com.proofpoint.ws.ui.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proofpoint.ws.dlpservice.DlpService;
import com.proofpoint.ws.ui.model.request.ScanFileRequest;
import com.proofpoint.ws.ui.model.request.ScanTextRequest;
import com.proofpoint.ws.ui.model.response.ScanResultsResponse;

@RestController
@RequestMapping("/dlp")
public class DlpController {

	 	
	@Autowired
	DlpService dlpService;
	
	 
	
	@PostMapping(path="/scan/text",
			consumes =  { 
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public ResponseEntity<ScanResultsResponse> scanText(@Valid @RequestBody ScanTextRequest scanTextRequest)
	{
		
		String [] sensitiveDataTypes= dlpService.scanText(scanTextRequest.getText());
 		ScanResultsResponse returnValue =  new ScanResultsResponse();
		returnValue.setSensitiveDataTypes(sensitiveDataTypes);
		return new ResponseEntity<ScanResultsResponse>(returnValue, HttpStatus.OK);
	}

	@PostMapping(path="/scan/file",
			consumes =  { 
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}, 
			produces =  { 
					MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					}  )
	public ResponseEntity<ScanResultsResponse> scanFile(@Valid @RequestBody ScanFileRequest scanFileRequest) throws IOException
	{
		
		String [] sensitiveDataTypes= dlpService.scanFile(scanFileRequest.getFilePath());
 		ScanResultsResponse returnValue =  new ScanResultsResponse();
		returnValue.setSensitiveDataTypes(sensitiveDataTypes);
		return new ResponseEntity<ScanResultsResponse>(returnValue, HttpStatus.OK);
	}
	
 
	
	 
	 
}
