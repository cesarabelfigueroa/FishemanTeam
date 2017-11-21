package BE;

import CORE.Bait;
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
import java.util.List;
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
            String id = document.get("_id").toString();

            BaitService baitService = new BaitService(client, database);

            ArrayList<Bait> baits = new ArrayList();
            List<Document> baits2 = (List<Document>) document.get("baits");

            if (baits2 != null && baits2.size() > 0) {
                for (Document bait : baits2) {
                    if (bait.get("baitID") != null) {
                        if (baitService.find(bait.getString("baitID")).size() > 0) {
                            baits.add(baitService.find(bait.getString("baitID")).get(0));
                        }
                    }
                }
            }
            Shop temp = new Shop(id, name);
            temp.setSales(baits);
            results.add(temp);
        }
    };

    public ArrayList<Shop> find(Shop parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null)&& parameters.getId()==null) {
            filters.append("name", parameters.getName());
        }else if(parameters.getId()!= null){
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        results = new ArrayList();
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(Shop parameters) {
       Document data = new Document();
        if ((parameters.getName() != null) && parameters.getId() == null) {
            data.append("name", parameters.getName());
        }
        if (parameters.getId() != null) {
            data.append("_id", new ObjectId(parameters.getId()));
        }
        BasicDBList listdb = new BasicDBList();
        for (Bait bait : parameters.getSales()) {
            listdb.add(new BasicDBObject("baitID", bait.getId()));
        }
        data.append("baits", listdb);
        results = new ArrayList();
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