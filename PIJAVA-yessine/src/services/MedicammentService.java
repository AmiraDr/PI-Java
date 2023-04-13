/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Medicamment;
import util.MyConnection;

/**
 *
 * @author AMIRA
 */
public class MedicammentService {
    MyConnection cnx2 ; 

    public MedicammentService(MyConnection cnx2) {
       // this.cnx2 = new MyConnection.getInstance(); 
    }

    public MedicammentService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void AddMedicamment(Medicamment medic) {
        try {
            String req = "INSERT INTO `medicamment`(`nom`, `description`,  `quantite`, `prix`)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setString(1, medic.getNom());
            pst.setString(2, medic.getDescription());
            pst.setFloat(3, medic.getQuantite());
            pst.setFloat(4, medic.getPrix());
            pst.executeUpdate();
            System.out.println("medicamment created");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
}
       public ArrayList<Medicamment> medicammentListe(int id) {
        ArrayList<Medicamment> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM `medicamment` WHERE nom= ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Medicamment medic = new Medicamment();
                medic.setId(rs.getInt(1));
                medic.setNom(rs.getString("nom"));
                medic.setDescription(rs.getString("description"));
                medic.setQuantite(rs.getFloat("quantite"));
                medic.setPrix(rs.getFloat("prix"));
                liste.add(medic);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return liste;
    }
 public void modifierMedicamment(int id,Medicamment medicamment) {
        try {
            String requete2="update medicamment set nom=?,description=?,quantite=?,prix=? where id=?";
            PreparedStatement pst =  MyConnection.getInstance().getCnx().prepareStatement(requete2);
            pst.setString(1, medicamment.getNom());
            pst.setString(2, medicamment.getDescription());
            pst.setFloat(3,   medicamment.getQuantite());
            pst.setFloat(4, medicamment.getPrix());
            pst.setInt(6,id);
            pst.executeUpdate();
           
            System.out.println("Medicamment est modifié");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
         public void deleteMedicamment(int id) {
        try {
            String req = "DELETE FROM `medicamment` WHERE id = ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println(" medicamment Deleted !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
}
