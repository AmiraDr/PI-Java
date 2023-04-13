/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Medcecin;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Disponibility;
import models.Medicamment;
import services.MedicammentService;

/**
 * FXML Controller class
 *
 * @author AMIRA
 */
public class MedicammentListeController implements Initializable {

  
    @FXML
    private TextField desctxt;
    @FXML
    private TextField nomtxt;
    @FXML
    private TextField qttext;
    @FXML
    private TextField prixtxt;
    ObservableList<Medicamment> MedicList = FXCollections.observableArrayList();
    @FXML
    private TableView<Medicamment> tablemedicament;
    @FXML
    private TableColumn<Medicamment, String> namecol;
    @FXML
    private TableColumn<Medicamment, String> descCol;
    @FXML
    private TableColumn<Medicamment, String> Qtcol;
    @FXML
    private TableColumn<Medicamment, String> prixcol;
    @FXML
    private Button bttnajoutermedic;
    @FXML
    private Button editbttn;
    @FXML
    private Button supbttn;
    private int idToUpdate ; 

    public void setIdToUpdate(int idToUpdate) {
        this.idToUpdate = idToUpdate;
    }

    public int getIdToUpdate() {
        return idToUpdate;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void GoToMedicamment(ActionEvent event) {
        System.out.println("medicamment Liste");
    }
    @FXML
    private void createMedicament(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Medecin/AddDMedicamment.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      private void refreshTable() {
        MedicammentService medicservice = new MedicammentService();
        MedicList.clear();
        MedicList.addAll(medicservice.medicammentListe(1));
       tablemedicament.setItems(MedicList);
        namecol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        Qtcol.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prixcol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        

         tablemedicament.setRowFactory(tv -> {
            TableRow<Medicamment> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    int myIndex = tablemedicament.getSelectionModel().getSelectedIndex();
                    int id = Integer.parseInt(String.valueOf(tablemedicament.getItems().get(myIndex).getId()));
                    setIdToUpdate(id);
                   desctxt.setText(tablemedicament.getItems().get(myIndex).getDescription().toString());
                    qttext.setText(String.valueOf(tablemedicament.getItems().get(myIndex).getQuantite()));
                    prixtxt.setText(String.valueOf(tablemedicament.getItems().get(myIndex).getPrix()));
                     nomtxt.setText(String.valueOf(tablemedicament.getItems().get(myIndex).getNom()));
                }
            });
            return myRow;
        });
      }
     @FXML
    private void modifierMedicamment(ActionEvent event) {
        String nom=nomtxt.getText();
        String description =desctxt.getText();
        String quantite =qttext.getText();
        String prix=prixtxt.getText();
           
        Medicamment medic = new Medicamment();
        medic.setNom(nomtxt.getText());
        medic.setDescription(desctxt.getText());
        medic.setQuantite(Integer.parseInt(qttext.getText()));
       medic.setPrix(Integer.parseInt(prixtxt.getText()));
        
        

        Medicamment medicamment=Medicamment();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de modifier ?");
        Optional<ButtonType> action = alert.showAndWait();

           MedicammentService medicservice=new MedicammentService();
          medicservice.modifierMedicamment(IDMedicammentToUpdate,medic);
  
            refreshTable();
System.out.println(medicamment);
System.out.println(IDMedicammentToUpdate);

        
        
    
    }
   
    private void clearForms() {
       nomtxt.setText("");
        desctxt.setText("");
        qttext.setText("");
        prixtxt.setText("");
       

    }

    private Medicamment Medicamment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
