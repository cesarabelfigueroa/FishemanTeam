/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Material;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Agile
 */
public class MaterialService {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private ArrayList<Material> results;

    public MaterialService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("material");
        this.results = new ArrayList();
    }

    private Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            String name = document.get("name").toString();
            String id = document.get("_id").toString();
            char type = document.get("type").toString().charAt(0);
            Material temporal = new Material(id, name, type);
            results.add(temporal);
        }
    };

    public ArrayList<Material> find(Material parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null) && (parameters.getId() == null)) {
            filters.append("name", parameters.getName());
        } else {
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Material> find(String id) {
        Document filters = new Document();
        filters.append("_id", new ObjectId(id));
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Material> find(ObjectId id) {
        Document filters = new Document();
        filters.append("_id",id);
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Material> findAll() {
        ArrayList<Material> materials = new ArrayList();
        FindIterable<Document> docs = collection.find();
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            materials.add(find((ObjectId)doc.get("_id")).get(0));
        }
        return materials;
    }
}
