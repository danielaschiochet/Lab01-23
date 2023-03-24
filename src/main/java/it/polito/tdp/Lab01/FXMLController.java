package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtTempoEsecuzione"
    private TextField txtTempoEsecuzione; // Value injected by FXMLLoader
       

    @FXML
    void doCancella(ActionEvent event) {
    	
    	String p = this.txtResult.getSelectedText();
    	
    	double startTime = System.nanoTime();
    	
    	elenco.cancellaParola(p);
    	
    	double endTime = System.nanoTime();
    	
    	if(elenco.getElenco()!=null)
    		this.txtResult.setText(elenco.getElenco().toString());
    	else
    		this.txtResult.clear();
    	
    	this.txtParola.clear();
    	
    	double time = (endTime - startTime)*0.000000001;
    	
    	this.txtTempoEsecuzione.setText("Operazione eseguita in "+time+"s");

    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	String p = this.txtParola.getText();
    	
    	double startTime = System.nanoTime();
    	
    	elenco.addParola(p);
    	
    	double endTime = System.nanoTime();
    	
    	this.txtResult.setText(elenco.getElenco().toString());
    	
    	this.txtParola.clear();
    	
    	double time = (endTime - startTime)*0.000000001;
    	
    	this.txtTempoEsecuzione.setText("Operazione eseguita in "+time+"s");
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtParola.clear();
    	this.txtResult.clear();
    	this.txtTempoEsecuzione.clear();
    	
    	double startTime = System.nanoTime();
    	
    	elenco.reset();
    	
    	double endTime = System.nanoTime();
    	
    	double time = (endTime - startTime)*0.000000001;
    	
    	this.txtTempoEsecuzione.setText("Operazione eseguita in "+time+"s");
    	

    }

    @FXML
    void initialize() {
    	  assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtTempoEsecuzione != null : "fx:id=\"txtTempoEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }

}
