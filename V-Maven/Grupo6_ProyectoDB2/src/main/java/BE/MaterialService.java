/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.AffiliateTest;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Agile
 */
public class MaterialService {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<AffiliateTest> results;

    public MaterialService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("material");
        this.results = new ArrayList();
    }
    
    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            String name = document.get("name").toString();
            AffiliateTest temporal = new AffiliateTest(name);
            // System.out.println(name);
            results.add(temporal);
        }
    };
}
