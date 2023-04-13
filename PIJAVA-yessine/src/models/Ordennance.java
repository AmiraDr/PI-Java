/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AMIRA
 */
public class Ordennance {
    private int id;
    private Date dateordenance;
    private float amount;
    private User doctor ; 
    private int rendez_vous_id;
     private ArrayList<OrdennanceLigne> ordennanceligne ; 

    public Ordennance() {
    }

    public Ordennance(int id, Date dateordenance, float amount, User doctor, int rendez_vous_id, ArrayList<OrdennanceLigne> ordennanceligne) {
        this.id = id;
        this.dateordenance = dateordenance;
        this.amount = amount;
        this.doctor = doctor;
        this.rendez_vous_id = rendez_vous_id;
        this.ordennanceligne = ordennanceligne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateordenance() {
        return dateordenance;
    }

    public void setDateordenance(Date dateordenance) {
        this.dateordenance = dateordenance;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public int getRendez_vous_id() {
        return rendez_vous_id;
    }

    public void setRendez_vous_id(int rendez_vous_id) {
        this.rendez_vous_id = rendez_vous_id;
    }

    public ArrayList<OrdennanceLigne> getOrdennanceligne() {
        return ordennanceligne;
    }

    public void setOrdennanceligne(ArrayList<OrdennanceLigne> ordennanceligne) {
        this.ordennanceligne = ordennanceligne;
    }

    @Override
    public String toString() {
        return "Ordennance{" + "id=" + id + ", dateordenance=" + dateordenance + ", amount=" + amount + ", doctor=" + doctor + ", rendez_vous_id=" + rendez_vous_id + ", ordennanceligne=" + ordennanceligne + '}';
    }

    public void setAmount(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
   