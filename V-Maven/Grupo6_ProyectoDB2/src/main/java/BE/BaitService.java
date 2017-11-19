/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Bait;
import CORE.Material;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Agile
 */
public class BaitService {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Bait> results;
    ArrayList<Material> materials;
    BasicDBList listdb;

    public BaitService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("fish");
        this.results = new ArrayList();
        this.listdb = new BasicDBList();
    }
    
    public void create(Bait parameters){
        Document data = new Document();
        if(parameters.getName()!= null){
            if(parameters.getMaterials().size() > 0){
                listdb = new BasicDBList();
                for(Material material: parameters.getMaterials()){
                    listdb.add(new BasicDBObject("materialID:",material.getId()));
                }
                data.append("name", parameters.getName());
                data.append("materials",listdb);
                collection.insertOne(data);
            }
        }
    }
}
