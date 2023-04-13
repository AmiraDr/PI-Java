/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Medcecin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AMIRA
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField desctxt;
    @FXML
    private Button bttnajoutermedic;
    @FXML
    private TextField nomtxt;
    @FXML
    private TextField qttext;
    @FXML
    private TextField prixtxt;
    @FXML
    private Button editbttn;
    @FXML
    private Button supbttn;
    @FXML
    private TableView<?> tablemedicament;
    @FXML
    private TableColumn<?, ?> namecol;
    @FXML
    private TableColumn<?, ?> descCol;
    @FXML
    private TableColumn<?, ?> Qtcol;
    @FXML
    private TableColumn<?, ?> prixcol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createMedicament(ActionEvent event) {
    }
    
}
