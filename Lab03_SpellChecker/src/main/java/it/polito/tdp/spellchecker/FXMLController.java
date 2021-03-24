/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.*;
import javafx.scene.control.ChoiceBox;
import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.fxml.FXML;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FXMLController {
private Dictionary model;
private String language;
ObservableList list= FXCollections.observableArrayList();

@FXML
private ResourceBundle resources;
    @FXML
    private URL location;
    
    @FXML
    private Button btnItalian;

    @FXML
    private Button btnEnglish;

    @FXML
    private ChoiceBox<String> wdwLanguage;

    
    @FXML
    private TextArea txtWords;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lblResult;

    @FXML
    void doClearText(ActionEvent event) {
    	txtResult.clear();
    	txtWords.setEditable(true);
    	txtWords.clear();
    	txtResult.setText("Selezionare la lingua");
    	btnItalian.setDisable(false);
    	btnEnglish.setDisable(false);
    	model.clearDictionary();

    }
    
    @FXML
    void doEnglish(ActionEvent event) {
    	btnItalian.setDisable(true);
    	language="English";
    	txtWords.setEditable(true);

    }

    @FXML
    void doItalian(ActionEvent event) {
    	btnEnglish.setDisable(true);
    	language="Italian";
    	txtWords.setEditable(true);

    }


    @FXML
   void doSpellCheck(ActionEvent event) {
   String s=txtWords.getText();
   	String parole[];
   	language=wdwLanguage.getValue();
   	List<RichWord> elenco;
    s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
   	//s.replaceAll("[$&+,:;=?@#|'<>.-^*()%!]", "");
    s.toLowerCase();
    parole=s.split(" ");
    ArrayList<String> worded= new ArrayList<String>();
    for(String w:parole) {
    	worded.add(w);
    	}
    model.loadDictionary(language);
//   elenco=(List<RichWord>) model.spellCheckText(worded);
//   elenco=(List<RichWord>) model.spellCheckTextLinear(worded);
elenco=(List<RichWord>) model.spellCheckTextDichotomic(worded);
    txtResult.setText("");
    boolean flag=false;
    for(RichWord rs: elenco) {
    	System.out.println(rs.isCorretto());
    	if(rs.isCorretto()==false) {
    		txtResult.appendText(rs.getWord().toString()+"  "+"wrong word"+"\n");
    		flag=true;
    	}
    }
    if(flag==false) {
    	txtResult.setText("Parole corrette");
    }
    }
    private void loadData() {
    	list.removeAll();
    	String a= "English";
    	String b="Italian";
    	list.addAll(a,b);
    	wdwLanguage.getItems().addAll(list);
    	txtWords.setEditable(true);
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        loadData();
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnItalian != null : "fx:id=\"btnItalian\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnEnglish != null : "fx:id=\"btnEnglish\" was not injected: check your FXML file 'Scene.fxml'.";
        assert wdwLanguage != null : "fx:id=\"wdwLanguage\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Dictionary model) {
    	this.model=model;
    }
}


