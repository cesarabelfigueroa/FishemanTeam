package src.main;

import BE.MaterialService;
import CORE.Material;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;



public class Application extends javax.swing.JFrame {
    MongoClient client = new MongoClient(new MongoClientURI("mongodb://cfigue:Sheldoncooper@ds259305.mlab.com:59305/fisheman"));
    MongoDatabase database = client.getDatabase("fisheman");


 

    public Application() {
        
        initComponents();
        
        Material example  = new Material("lechuga",'V');   
        MaterialService materialService = new MaterialService(client, database);
        //materialService.create(example);
        ArrayList<Material> results =  materialService.find(example);
        for (Material a : results) {
            System.out.println(a.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
