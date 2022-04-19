package gob.pe.pvn;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		String jsonString = "{\"Name\":\"Raja\",\"EmployeeId\":\"115\",\"Age\":\"30\"}";
	      JSONParser parser = new JSONParser();
	      JSONObject obj;
	      try {
	         obj = (JSONObject)parser.parse(jsonString);
	         System.out.println(obj.get("Name"));
	         System.out.println(obj.get("EmployeeId"));
	         System.out.println(obj.get("Age"));
	      } catch(ParseException e) {
	         e.printStackTrace();
	      }
		
    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     *
     * @param requestURL
     * @param charset
     * @throws IOException
     */
   
    /**
     * Adds a header field to the request.
     *
     * @param name  - name of the header field
     * @param value - value of the header field
     */
   
	}}
