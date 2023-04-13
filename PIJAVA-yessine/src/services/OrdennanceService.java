/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Ordennance;
import models.OrdennanceLigne;
import services.OrdennanceLigneService ;
import util.MyConnection;

/**
 *
 * @author AMIRA
 */
public class OrdennanceService {
     public void AddOrdennance(Ordennance orden) {
        try {
            String req = "INSERT INTO `ordennance`( `dateordennance`, `amount`, `rendez_vous_id`)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setDate(1, (Date) orden.getDateordenance());
            pst.setInt(2, (int) orden. getAmount());
            pst.setInt(3,orden.getRendez_vous_id());
            pst.executeUpdate();
            System.out.println("ordennance created");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /* int idOrdennance = this.OrdennanceByRendez_vous_id(orden.getRendez_vous_id());
          orden.setId(idOrdennance);
            for (OrdennanceLigne ordennanceligne : ordennancelignes) {
                ordennanceligne.setRelatedOrder(ordennance);
                ordennanceligneService.addOrdennanceligne(ordennanceligne);
            }
            System.out.println(" Ordennance ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
     }
  public ArrayList<Ordennance> OrdennanceListe() {
        ArrayList<Ordennance> liste = new ArrayList<>();
        OrdennanceLigneService ordennanceligneservice = new OrdennanceLigneService();
        try {
            String req = "SELECT * FROM `ordennance` ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Ordennance ordennance = new Ordennance();
                ordennance .setId(rs.getInt(1));
                ordennance .setDateordenance (rs.getDate("date_ordennance"));
                ordennance.setAmount(rs.getInt("amount"));
                ordennance.setRendez_vous_id(rs.getInt("1"));
                ordennance. setOrdennanceligne(ordennanceligneservice.ordennanceligneListe(rs.getInt(1)));
                liste.add(ordennance);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return liste;
    }
   public int OrderIDByReference(String reference) {
        int id = 0;
        try {
            String req = "SELECT * FROM `order` WHERE reference = ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setString(1, reference);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    } public int OrderIDByRendez_VOus_Id(String rende_vous_id) {
        int id = 0;
        try {
            String req = "SELECT * FROM `ordennance` WHERE rendez_vous_id = ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setString(1, rende_vous_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
     public Ordennance ordennanceByID(int id) {
        OrdennanceLigneService ordennanceligneservice = new OrdennanceLigneService();
        Ordennance ordennance = new Ordennance();
        try {
            String req = "SELECT * FROM `ordenance` WHERE id = ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

               ordennance .setId(rs.getInt(1));
               ordennance .setDateordenance (rs.getDate("date_ordennance"));
               ordennance.setAmount(rs.getInt("amount"));
               ordennance.setRendez_vous_id(rs.getInt("1"));
               ordennance. setOrdennanceligne(ordennanceligneservice.ordennanceligneListe(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ordennance;
    }

          public void updateStateOrdennance(int id, String state) {

        try {
            String req = "UPDATE `ordennance` SET `state`= ? WHERE id = ?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setInt(2, id);
            pst.setString(1, state);
            pst.executeUpdate();
            System.out.println("Ordennance Updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   

}
