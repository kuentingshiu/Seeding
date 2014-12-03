import java.net.UnknownHostException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class ImportMongo {

	private DBCollection collection;
	
	// Initiate connection of MongoDB
	ImportMongo (String mongoServer, int mongoPort, String database, String collection) {
		try {
			MongoClient mongoClient = new MongoClient(mongoServer,mongoPort);
			DB db = mongoClient.getDB(database);
			this.collection = db.getCollection(collection);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
	
	// Save JSON array into the collection of MongoDB
	public void SaveToMongo (JSONArray jsonArray) {
		Iterator<JSONObject> itr = jsonArray.iterator();
		while (itr.hasNext()) {
			DBObject dbObject = (DBObject) JSON.parse(itr.next().toJSONString());
			//dbObject.put("_id", 123);
			collection.insert(dbObject);
		}
	}		
}
