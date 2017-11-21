package BE;

import CORE.Community;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.Arrays;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CommunityService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Community> results = new ArrayList();

    public CommunityService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("community");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            String name = document.get("name").toString();
            String _id = document.get("_id").toString();
            Community temporal = new Community(_id, name);
            results.add(temporal);
        }
    };

    public ArrayList<Community> find(Community parameters) {
        results = new ArrayList();
        Document filters = new Document();
        if ((parameters.getName() != null) && parameters.getId() == null) {
            filters.append("name", parameters.getName());
        }
        
        if ((parameters.getId() != null)) {
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        results = new ArrayList();
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(Community parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }

        collection.insertOne(data);
    }

    public void update(Community parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName())));
    }

    public void delete(Community parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }

}