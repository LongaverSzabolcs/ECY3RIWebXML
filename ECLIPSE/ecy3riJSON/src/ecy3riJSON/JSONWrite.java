package ecy3riJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JSONWrite {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Megis miert kell az exceptionoket is kulon importalnom? Milyen remalomnyelv ez?
		Reader myFile = new FileReader("orarend.json");
		Writer outputFile = new FileWriter("output.txt");
		
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
				
				/*
				System.out.println("ID: " 
						+ oraId + "\n"
						+ oraNev + "\n"
						+ oraIdeje + "\nHelyszin: "
						+ helyszin + "\nOktato: "
						+ oktato + "\nSzak: "
						+ szak + "\n");
				*/
				
				outputFile.write("ID: " 
						+ oraId + "\n"
						+ oraNev + "\n"
						+ oraIdeje + "\nHelyszin: "
						+ helyszin + "\nOktato: "
						+ oktato + "\nSzak: "
						+ szak + "\n\n");
			}
			System.out.println("Writing possibly successful!");
			outputFile.close();
			System.out.println("FileWriter closed!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
