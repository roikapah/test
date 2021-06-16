import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.proofpoint.ws.dlpservice.impl.DlpServiceImpl;
import com.proofpoint.ws.dlpservice.impl.datatypes.DataTypeFormat;
import com.proofpoint.ws.dlpservice.impl.datatypes.SensitiveDataTypesFormat;

public class test {

	public static void main(String[] args) throws IOException {
//		Gson gson = new Gson(); // Or use new GsonBuilder().create();;
//		
//		File file = ResourceUtils.getFile("classpath:SensitiveDataTypesFormat.json");
//
//				//Read File Content
//				String json = new String(Files.readAllBytes(file.toPath()));
//				System.out.println(json);
//		
//		
//				DataTypeFormat [] dataTypesFormat = gson.fromJson(json, DataTypeFormat [].class);
//		System.out.println(json);
		
		DlpServiceImpl dsi=new DlpServiceImpl();
		String text="My credit card number is 4012 8888 8888 1881";
		List <String > dataTypesFoundList=new ArrayList<String>();
String patternStr = "dddddddddddddddd|dddd dddd dddd dddd|dddd-dddd-dddd-dddd".replaceAll("d", "\\\\d");
		  System.out.println("patternStr "+patternStr);
		//  \d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d|\d\d\d\d \d\d\d\d \d\d\d\d \d\d\d\d|\d\d\d\d-\d\d\d\d-\d\d\d\d-\d\d\d\d
		//  \d\d\d\d\d\d\d\d\d\d\d\d\d\d\d\d|\d\d\d\d \d\d\d\d \d\d\d\d \d\d\d\d|\d\d\d\d-\d\d\d\d-\d\d\d\d-\d\d\d\d
		  // System.out.println("\\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d");
			Pattern pattern = Pattern.compile(patternStr);
			Matcher matcher = pattern.matcher(text);
			//in-case a pattern was found look for key words
			if(matcher.find()) {
				System.out.println("Bingo");
//				pattern = Pattern.compile(dtf.getContextKeywords());
//				 matcher = pattern.matcher(text);
//				 if(matcher.find()) {
//					 dataTypesFoundList.add(dtf.getName());
 				// }
			}
			else
				System.out.println("NOT Bingo");
		 
		
	}

}
