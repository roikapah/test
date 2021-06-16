package com.proofpoint.ws.dlpservice;

import java.io.IOException;

public interface DlpService {
	 

	String[] scanText(String text);
	String[]  scanFile(String filePath) throws IOException;
}
