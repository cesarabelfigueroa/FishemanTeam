/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Bait;
import CORE.Company;
import CORE.Fish;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Agile
 */
public class FishService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Fish> results;
    BaitService baitserv;
    BasicDBList listdb;
    ArrayList<Bait> baits;

    public FishService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("fish");
        this.results = new ArrayList();
        this.listdb = new BasicDBList();
        this.baits = new ArrayList();
        this.baitserv = new BaitService(client,database);
    }

    public void create(Fish parameters) {
        Document data = new Document();
        this.listdb = new BasicDBList();
        for (Bait bait : parameters.getBaits()) {
            listdb.add(new BasicDBObject("baitID", bait.getId()));
        }
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName())
                .append("baits", listdb);
        }
        collection.insertOne(data);
    }
    
    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            baits = new ArrayList();
            String name = document.get("name").toString();
            String id = document.get("_id").toString();
            List<Document> baitsd = (List<Document>)document.get("baits");
            if(baits.size()>0){
                for(Document bait: baitsd){
                    if(bait.get("baitID")!= null){
                        if(baitserv.find(bait.getString("baitID")).size()>0){
                            baits.add(baitserv.find(bait.getString("baitID")).get(0));
                        }
                    }
                }
            }
            Fish temporal = new Fish(id, name, baits);
            results.add(temporal);
        }
    };

    public ArrayList<Fish> find(Fish parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null) && (parameters.getId() == null)) {
            filters.append("name", parameters.getName());
        } else {
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }
    
    public ArrayList<Fish> find(ObjectId id) {
        Document filters = new Document();
        filters.append("_id", id);
        collection.find(filters).forEach(printBlock);
        return results;
    }
    public ArrayList<Fish> find(String id) {
        Document filters = new Document();
        filters.append("_id", new ObjectId(id));
        collection.find(filters).forEach(printBlock);
        return results;
    }
    
    public void update(Fish parameters) {
        this.listdb = new BasicDBList();
        for (Bait bait : parameters.getBaits()) {
            listdb.add(new BasicDBObject("baitID", bait.getId()));
        }
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName()),set("baits",listdb)));
    }

    public void delete(Fish parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
