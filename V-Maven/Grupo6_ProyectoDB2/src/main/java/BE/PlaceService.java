package BE;

import CORE.Place;
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

public class PlaceService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Place> results = new ArrayList();

    public PlaceService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("place");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            String name = document.get("name").toString();
            String _id = document.get("_id").toString();
            String idComunity = document.get("name").toString();
            Place temporal = new Place(_id, name);
            results.add(temporal);
        }
    };

    public ArrayList<Place> find(Place parameters) {
        Document filters = new Document();
        results = new ArrayList();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(Place parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)) {
            data.append("name", parameters.getName());
        }
        
        /* if ((parameters.getIdcommunity() != null)) {
            data.append("idComunity", parameters.getIdcommunity());
        } */

        collection.insertOne(data);
    }

    public void update(Place parameters) {
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                /*combine(*/set("name", parameters.getName())/*, set("idComunity", parameters.getIdcommunity()))*/);
    }

    public void delete(Place parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
