/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import util.MyConnection;
import models.Rendezvous;
import models.OrdennanceLigne;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AMIRA
 */
public class RendezvousService {

    public void AddRendezvous(Rendezvous rdv){
          try {
            String req = "INSERT INTO `rendez_vous`(`date_rv`, `hour_rv`,  `date_passage_rv`, `hour_passage_rv`,`state`,`fromuser_id`,`todoctor_id`,`note`,`ordennance_id`)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(req);
            pst.setDate(1, rdv.getDate_rv());
            pst.setString(2, rdv.getHour_rv());
            pst.setDate(3, rdv.getDate_passage_rv());
            pst.setString(4, rdv.getHour_passage_rv());
            pst.setInt(6, rdv.getFromuser_id());
            pst.setInt(5, rdv.getTodoctor_id());
            pst.setString(5, rdv.getNote());
            pst.setInt(5, rdv.getOrdennance_id());
            pst.executeUpdate();
            System.out.println("rendez_vous created");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
}
     public ArrayList<Rendezvous> RendezvousListe() {
        ArrayList<Rendezvous> liste = new ArrayList<>();
        OrdennanceLigneService ordennanceligneservice = new OrdennanceLigneService();
        try {
            String req = "SELECT * FROM `rendezvous` ";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Rendezvous rdv = new Rendezvous();
                rdv.setId(rs.getInt(1));
                rdv.setDate_rv(rs.getDate("date_rv"));
                rdv.setNote(rs.getString("note"));
                rdv. setDate_passage_rv(rs.getDate("passage_rv"));
                rdv.setHour_rv(rs.getString("hour_rv"));
                rdv.setHour_passage_rv(rs.getString("Hour_passage"));
                rdv.setState(rs.getString("state"));
                rdv.setFromuser_id(rs.getInt(1));
                rdv.setTodoctor_id(rs.getInt(1));
                rdv.setOrdennance_id(rs.getInt(1));
                rdv.setNote(rs.getString("state"));
                liste.add(rendezvous);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return liste;
    }

    
}
