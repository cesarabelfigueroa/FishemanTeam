/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Company;
import CORE.Fish;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
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

    public FishService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("fish");
        this.results = new ArrayList();
    }

    public void create(Fish parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }
        collection.insertOne(data);
    }
    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            String name = document.get("name").toString();
            String id = document.get("_id").toString();
            Fish temporal = new Fish(id, name);
            results.add(temporal);
        }
    };
    public ArrayList<Fish> find(Fish parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null) && (parameters.getId() == null)) {
            filters.append("name", parameters.getName());
        } else {
            filters.append("_id", parameters.getId());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }
    public void update(Fish parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName())));
    }

    public void delete(Fish parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
