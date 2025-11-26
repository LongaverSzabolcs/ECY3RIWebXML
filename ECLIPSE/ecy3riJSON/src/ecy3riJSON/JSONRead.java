package ecy3riJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JSONRead {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO I HATE JAVA I HATE JAVA I HATE JAVA I HATE JAVA
		Reader myFile = new FileReader("orarend.json");
		
		JSONParser myParser = new JSONParser();
		try{
			JSONObject root = (JSONObject) myParser.parse(myFile);
			JSONObject orarend = (JSONObject) root.get("orarend");
			JSONArray ora = (JSONArray) orarend.get("ora");
			
			for (Object i : ora) {
				JSONObject obj = (JSONObject) i;
				
				String oraId = (String) obj.get("_id");
				
				//Formatum: "Kozgazdasagtan alapjai (eloadas)"
				//illetve:  "Kozgazdasagtan alapjai (gyakorlat)"
				
				String oraNev = (String) obj.get("targy");
				oraNev += " (";
				oraNev += (String) obj.get("_tipus");
				oraNev += ")";
						
				//Formatum: "Hetfo, 10 - 12"
				JSONObject idopont = (JSONObject) obj.get("idopont");
				String oraIdeje = "";
				oraIdeje += (String) idopont.get("nap");
				oraIdeje += ", ";
				oraIdeje += (String) idopont.get("tol");
				oraIdeje += " - ";
				oraIdeje += (String) idopont.get("ig");
				
				String helyszin = (String) obj.get("helyszin");
				
				String oktato = (String) obj.get("oktato");
				
				String szak = (String) obj.get("szak");
				
				System.out.println("ID: " 
						+ oraId + "\n"
						+ oraNev + "\n"
						+ oraIdeje + "\nHelyszin: "
						+ helyszin + "\nOktato: "
						+ oktato + "\nSzak: "
						+ szak + "\n");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
