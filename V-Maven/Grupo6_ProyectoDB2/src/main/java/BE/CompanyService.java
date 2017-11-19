/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Company;
import CORE.Company;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Agile
 */
public class CompanyService {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Company> results;

    public CompanyService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("company");
        this.results = new ArrayList();
    }
    
     Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            String name = document.get("name").toString();
            String id = document.get("_id").toString();
            Company temporal = new Company(id,name);
            results.add(temporal);
        }
    };
     
    public String create(Company parameters){
        Document data = new Document();
        if((parameters.getName()!=null)){
            data.append("name",parameters.getName());
        }
        collection.insertOne(data);
        ObjectId id = collection.find().sort(new BasicDBObject("_id",-1)).first().get("_id", ObjectId.class);
        return id.toString();
    }
    
    public ArrayList<Company> find(Company parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null)&& (parameters.getId()== null)) {
            filters.append("name", parameters.getName());
        }else{
            filters.append("_id", parameters.getId());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }
}
