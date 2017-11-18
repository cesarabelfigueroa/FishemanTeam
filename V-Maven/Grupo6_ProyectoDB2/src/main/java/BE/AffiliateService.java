package BE;

import CORE.AffiliateTest;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import java.util.Arrays;
import java.util.ArrayList;
import org.bson.Document;

public class AffiliateService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<AffiliateTest> results = new ArrayList();

    public AffiliateService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("affiliate");
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

    public ArrayList<AffiliateTest> find(AffiliateTest parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(AffiliateTest parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }

        collection.insertOne(data);
    }
}
