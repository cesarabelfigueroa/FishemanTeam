/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Company;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
            String name = document.get("name").toString();
            String id = document.get("_id").toString();
            Company temporal = new Company(id, name);
            results.add(temporal);
        }
    };

    public void create(Company parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }
        collection.insertOne(data);
    }

    public ArrayList<Company> find(Company parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null) && (parameters.getId() == null)) {
            filters.append("name", parameters.getName());
        } else {
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Company> find(String id) {
        Document filters = new Document();
        filters.append("_id", new ObjectId(id));
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Company> find(ObjectId id) {
        results = new ArrayList();
        Document filters = new Document();
        filters.append("_id",id);
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Company> findAll() {
        ArrayList<Company> company = new ArrayList();
        FindIterable<Document> docs = collection.find();
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            company.add(find((ObjectId) doc.get("_id")).get(0));
        }
        return company;
    }

    public void update(Company parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName())));
    }

    public void delete(Company parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
