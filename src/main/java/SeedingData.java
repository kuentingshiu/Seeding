import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SeedingData {

	public static void main(String[] args) {
		
		String rootPath = "/home/kuentingshiu";
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = new JSONArray();

		ImportMongo importMongo;
		
		try {
			/***** Activity *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/activity.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Activity");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Activity data ready!");
			
			/***** Family *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/family.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Family");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Family data ready!");
			
			/***** Gossip *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/gossip.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Gossip");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Gossip data ready!");
			
			/***** Item *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/item.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Item");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Item data ready!");
			
			/***** Member *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/member.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Member");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Member data ready!");
			
			/***** Question *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/question.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Question");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Question data ready!");
			
			/***** Survey *****/	 
			jsonArray = (JSONArray) parser.parse(new FileReader(rootPath+"/survey.json"));;
			importMongo = new ImportMongo("localhost",27017,"xiwamiSeed","Survey");
			importMongo.SaveToMongo(jsonArray);
			System.out.println("Survey data ready!");								
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}


}
