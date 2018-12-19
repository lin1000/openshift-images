package tw.ibm.gbs.poc.springcloud.appfrontend.controller;

import java.util.Arrays;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@RestController
class AppController {
		

	@RequestMapping("/dashboard")
	public String dashboard() {
		
		MongoCredential credential = MongoCredential.createCredential("lin1000", "votedb", "q1w2e3r4".toCharArray());		
		MongoClient mongoClient = new MongoClient(new ServerAddress("mongodb", 27017),Arrays.asList(credential));
		MongoDatabase database = mongoClient.getDatabase("votedb");
		MongoCollection<Document> collection = database.getCollection("vote");
		
		
		StringBuffer sb = new StringBuffer();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		        sb.append(cursor.next().toString());
		        sb.append("</br>");
		    }
		} finally {
		    cursor.close();
		}		
		
		return "This is demo page of dashboard. </br>" + 
				"Total Number of Documents in MongoDB :"+ String.valueOf(collection.count()) +"</br>" +
				"==================================================</br>" + 
				sb.toString();
	}
	
	
	@RequestMapping("/add")
	public String add() {
		MongoCredential credential = MongoCredential.createCredential("lin1000", "votedb", "q1w2e3r4".toCharArray());		
		MongoClient mongoClient = new MongoClient(new ServerAddress("mongodb", 27017),Arrays.asList(credential));
		MongoDatabase database = mongoClient.getDatabase("votedb");
		MongoCollection<Document> collection = database.getCollection("vote");
		
		Document doc = new Document("link", "www.ibm.com").append("score", 100);
		collection.insertOne(doc);
		mongoClient.close();
		return doc.toString();
	}
}