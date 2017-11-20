package BE;
import CORE.License;
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

public class LicenseService {
    
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<License> results = new ArrayList();

    public LicenseService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("licdnse");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            String name = document.get("name").toString();
            String _id = document.get("_id").toString();
            double price = Double.parseDouble(document.get("price").toString());
            String idCommunity = document.get("idCommunity").toString();
            String idPlace =  document.get("idPlace").toString();
            License temporal = new License(_id, name, price);
            results.add(temporal);
        }
    };

    public ArrayList<License> find(License parameters) {
        Document filters = new Document();
        results = new ArrayList();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(License parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }
        
        if ((parameters.getPrice() != 0)) {
            data.append("price", parameters.getPrice());
        }
        
       
        
        collection.insertOne(data);
    }

    public void update(License parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName()), set("price", parameters.getPrice())));
    }

    public void delete(License parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}