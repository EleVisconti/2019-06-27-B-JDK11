/**
 * Sample Skeleton for 'Crimes.fxml' Controller Class
 */

package it.polito.tdp.crimes;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.crimes.model.Adiacenza;
import it.polito.tdp.crimes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class CrimesController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxCategoria"
    private ComboBox<String> boxCategoria; // Value injected by FXMLLoader

    @FXML // fx:id="boxMese"
    private ComboBox<String> boxMese; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="boxArco"
    private ComboBox<Adiacenza> boxArco; // Value injected by FXMLLoader

    @FXML // fx:id="btnPercorso"
    private Button btnPercorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Crea grafo...\n");
    	String c = boxCategoria.getValue();
    	String m = boxMese.getValue();
    	int mese =0;
    	if(m.compareTo("Gennaio")==0) {
    		mese=1;
    	}
    	if(m.compareTo("Febbraio")==0) {
    		mese=2;
    	}
    	if(m.compareTo("Marzo")==0) {
    		mese=3;
    	}
    	if(m.compareTo("Aprile")==0) {
    		mese=4;
    	}
    	if(m.compareTo("Maggio")==0) {
    		mese=5;
    	}
    	if(m.compareTo("Giugno")==0) {
    		mese=6;
    	}
    	if(m.compareTo("Luglio")==0) {
    		mese=7;
    	}
    	if(m.compareTo("Agosto")==0) {
    		mese=8;
    	}
    	if(m.compareTo("Settembre")==0) {
    		mese=9;
    	}
    	if(m.compareTo("Ottobre")==0) {
    		mese=10;
    	}
    	if(m.compareTo("Novembre")==0) {
    		mese=11;
    	}
    	if(m.compareTo("Dicembre")==0) {
    		mese=12;
    	}
    	this.model.creaGrafo(c,mese);
    	txtResult.appendText("Grafo creato con "+this.model.nVertici()+" vertici e "+this.model.nArchi()+" archi");
    	
    	boxArco.getItems().clear();
    	boxArco.getItems().addAll(this.model.getArchi());
    }
    
    @FXML
    void doCalcolaPercorso(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Calcola percorso...\n");
    	Adiacenza a = boxArco.getValue();
    	txtResult.appendText(this.model.trovaPercorso(a.getR1(), a.getR2()));
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxCategoria != null : "fx:id=\"boxCategoria\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert boxArco != null : "fx:id=\"boxArco\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert btnPercorso != null : "fx:id=\"btnPercorso\" was not injected: check your FXML file 'Crimes.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Crimes.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	boxCategoria.getItems();
    	boxCategoria.getItems().addAll(this.model.getCategorie());
    	boxMese.getItems().clear();
    	boxMese.getItems().add("Gennaio");
    	boxMese.getItems().add("Febbraio");
    	boxMese.getItems().add("Marzo");
    	boxMese.getItems().add("Aprile");
    	boxMese.getItems().add("Maggio");
    	boxMese.getItems().add("Giugno");
    	boxMese.getItems().add("Luglio");
    	boxMese.getItems().add("Agosto");
    	boxMese.getItems().add("Settembre");
    	boxMese.getItems().add("Ottobre");
    	boxMese.getItems().add("Novembre");
    	boxMese.getItems().add("Dicembre");
    }
    
  
}
