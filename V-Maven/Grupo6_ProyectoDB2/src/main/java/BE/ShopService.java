package BE;

import CORE.Shop;
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

public class ShopService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Shop> results = new ArrayList();

    public ShopService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("shop");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            String name = document.get("name").toString();
            String _id = document.get("_id").toString();
            String idComunity = document.get("name").toString();
            Shop temporal = new Shop(_id, name);
            results.add(temporal);
        }
    };

    public ArrayList<Shop> find(Shop parameters) {
        Document filters = new Document();
        results = new ArrayList();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(Shop parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }

        collection.insertOne(data);
    }

    public void update(Shop parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName())));
    }

    public void delete(Shop parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}