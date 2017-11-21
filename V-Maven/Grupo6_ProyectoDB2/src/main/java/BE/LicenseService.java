package BE;
import CORE.Community;
import CORE.Fish;
import CORE.License;
import CORE.Material;
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
import java.util.List;
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
        this.collection = database.getCollection("license");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            FishService  fishService = new FishService(client, database);
            String name = document.get("name").toString();
            String _id = document.get("_id").toString();
            double price = Double.parseDouble(document.get("price").toString());
            String idCommunity = document.get("idCommunity").toString();
            String idPlace =  document.get("idPlace").toString();
            ArrayList<Fish> fishes = new ArrayList();
            List<Document> Fishes = (List<Document>) document.get("fishes");
            
            for (Document fish : Fishes) {
                if (fish.get("fishID") != null) {
                    if (fishService.find(fish.getString("fishID")).size() > 0) {
                        fishes.add(fishService.find(fish.getString("fishID")).get(0));
                    }
                }
            }
            
            PlaceService places  = new PlaceService(client, database);
            Place place = places.find(new Place(idPlace)).get(0);
            License temporal = new License(_id, name, price);
            CommunityService communityService  = new CommunityService(client, database);
            Community community = communityService.find(new Community(idCommunity)).get(0);
            temporal.setPlace(place);
            temporal.setCommunity(community);
            temporal.setFishes(fishes);
            results.add(temporal);
        }
    };
    
      public ArrayList<License> find(String id) {
        Document filters = new Document();
        filters.append("_id", new ObjectId(id));
        results = new ArrayList();
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<License> find(License parameters) {
        Document filters = new Document();
        results = new ArrayList();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        results = new ArrayList();
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(License parameters) {
        Document data = new Document();
        if ((parameters.getName() != null)&& parameters.getId()==null) {
            data.append("name", parameters.getName());
            data.append("idCommunity", parameters.getCommunity().getId());
            data.append("idPlace", parameters.getPlace().getId());
            data.append("price", parameters.getPrice());
        }
        if(parameters.getId()!= null){
            data.append("_id", new ObjectId(parameters.getId()));
        }
        BasicDBList listdb = new BasicDBList();
        for (Fish fish : parameters.getFishes()) {
            listdb.add(new BasicDBObject("fishID", fish.getId()));
        }
        
        data.append("fishes", listdb);
        
       
       
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