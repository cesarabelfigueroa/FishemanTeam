package BE;

import CORE.Affiliate;
import CORE.Fish;
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
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class AffiliateService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    ArrayList<Affiliate> results = new ArrayList();

    public AffiliateService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.collection = database.getCollection("affiliate");
    }

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            String name = document.get("name").toString();
            String id = document.get("_id").toString();

            LicenseService licenseService = new LicenseService(client, database);

            ArrayList<License> licenses = new ArrayList();
            List<Document> Licenses = (List<Document>) document.get("licenses");

            if (Licenses != null && Licenses.size() > 0) {
                for (Document License : Licenses) {
                    if (License.get("licenseID") != null) {
                        if (licenseService.find(License.getString("licenseID")).size() > 0) {
                            licenses.add(licenseService.find(License.getString("licenseID")).get(0));
                        }
                    }
                }
            }
            Affiliate temp = new Affiliate(id, name);
            temp.setLicenses(licenses);
            results.add(temp);
        }
    };

    public ArrayList<Affiliate> find(Affiliate parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null)) {
            filters.append("name", parameters.getName());
        }
        results = new ArrayList();
        collection.find(filters).forEach(printBlock);
        return results;
    }

    public void create(Affiliate parameters) {
        Document data = new Document();
        results = new ArrayList();
        if ((parameters.getName() != null) && parameters.getId() == null) {
            data.append("name", parameters.getName());
        }
        if (parameters.getId() != null) {
            data.append("_id", new ObjectId(parameters.getId()));
        }
        BasicDBList listdb = new BasicDBList();
        for (License license : parameters.getLicenses()) {
            listdb.add(new BasicDBObject("licenseID", license.getId()));
        }

        data.append("licenses", listdb);
        collection.insertOne(data);
    }

    public void update(Affiliate parameters) {
        BasicDBList listdb = new BasicDBList();
        for (License lic : parameters.getLicenses()) {
            listdb.add(new BasicDBObject("licenseID", lic.getId()));
        }
        collection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName()), set("licenses", listdb)));
    }

    public void delete(Affiliate parameters) {
        collection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
