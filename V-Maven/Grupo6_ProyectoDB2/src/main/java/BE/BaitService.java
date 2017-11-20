/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import CORE.Bait;
import CORE.Company;
import CORE.Material;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
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
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Agile
 */
public class BaitService {

    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> baitCollection;
    MongoCollection<Document> baitNatural;
    ArrayList<Bait> results;
    ArrayList<Material> materials;
    BasicDBList listdb;
    CompanyService comService;
    MaterialService materialServ;

    public BaitService(MongoClient client, MongoDatabase database) {
        this.client = client;
        this.database = database;
        this.baitCollection = database.getCollection("bait");
        this.baitNatural = database.getCollection("baitNaturalMaterials");
        this.results = new ArrayList();
        this.listdb = new BasicDBList();
        this.comService = new CompanyService(client, database);
        this.materialServ = new MaterialService(client, database);
        this.materials = new ArrayList();
    }

    public void create(Bait parameters) {
        Document databait = new Document();
        if (parameters.getName() != null) {
            listdb = new BasicDBList();
            for (Material material : parameters.getMaterials()) {
                listdb.add(new BasicDBObject("materialID", material.getId()));
            }
            databait.append("name", parameters.getName())
                    .append("type", parameters.getType())
                    .append("classification", parameters.getClassification())
                    .append("color", parameters.getColor())
                    .append("size", parameters.getSize())
                    .append("price", parameters.getPrice())
                    .append("materials", listdb);
            if (parameters.getGroup() != null && parameters.getCompany() != null) {
                databait.append("group", parameters.getGroup())
                        .append("companyID", parameters.getCompany().getId());
            } else {
                databait.append("group", null)
                        .append("companyID", null);
            }
            baitCollection.insertOne(databait);
        }
    }
    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            results = new ArrayList();
            String name = document.getString("name");
            String id = document.get("_id").toString();
            String type = document.getString("type");
            String classification = document.getString("classification");
            String color = document.getString("color");
            int size = document.getInteger("size");
            double price = document.getDouble("price");
            String group = "";
            if (document.get("group") != null) {
                group = document.get("group").toString();
            } else {
                group = null;
            }
            String companyID = "";
            Company company = null;
            if (document.get("companyID") != null) {
                companyID = document.get("companyID").toString();
                company = comService.find(companyID).get(0);
            } else {
                companyID = null;
            }
            List<Document> mats = (List<Document>) document.get("materials");
            if (mats.size() > 0) {
                for (Document mat : mats) {
                    if (mat.get("materialID") != null) {
                        if (materialServ.find(mat.getString("materialID")).size() > 0) {
                            materials.add(materialServ.find(mat.getString("materialID")).get(0));
                        }
                    }
                }
            }
            Bait temporal = new Bait(id, name, type, classification, color, size, price, materials, group, company);
            results.add(temporal);
        }
    };

    public ArrayList<Bait> find(String id) {
        Document filters = new Document();
        filters.append("_id", new ObjectId(id));
        baitCollection.find(filters).forEach(printBlock);
        return results;
    }

    public ArrayList<Bait> find(ObjectId id) {
        Document filters = new Document();
        filters.append("_id", id);
        baitCollection.find(filters).forEach(printBlock);
        return results;
    }
    public ArrayList<Bait> findAll() {
        ArrayList<Bait> baits = new ArrayList();
        FindIterable<Document> docs = baitCollection.find();
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            baits.add(find((ObjectId) doc.get("_id")).get(0));
        }
        return baits;
    }

    public ArrayList<Bait> find(Bait parameters) {
        Document filters = new Document();
        if ((parameters.getName() != null) && (parameters.getId() == null)) {
            filters.append("name", parameters.getName());
        } else {
            filters.append("_id", new ObjectId(parameters.getId()));
        }
        baitCollection.find(filters).forEach(printBlock);
        return results;
    }

    public void update(Bait parameters) {
        listdb = new BasicDBList();
        for (Material material : parameters.getMaterials()) {
            listdb.add(new BasicDBObject("materialID", material.getId()));
        }
        if(parameters.getCompany()!= null){
            baitCollection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName()), set("materials", listdb),
                        set("type", parameters.getType()), set("size", parameters.getSize()),
                        set("classification", parameters.getClassification()), set("color", parameters.getColor()),
                        set("price", parameters.getPrice()), set("group", parameters.getGroup()), set("companyID", parameters.getCompany().getId())));
        }else{
            baitCollection.updateOne(eq("_id", new ObjectId(parameters.getId())),
                combine(set("name", parameters.getName()), set("materials", listdb),
                        set("type", parameters.getType()), set("size", parameters.getSize()),
                        set("classification", parameters.getClassification()), set("color", parameters.getColor()),
                        set("price", parameters.getPrice()), set("group", parameters.getGroup()), set("companyID", null)));
        }
    }

    public void delete(Bait parameters) {
        baitCollection.deleteOne(eq("_id", new ObjectId(parameters.getId())));
    }
}
