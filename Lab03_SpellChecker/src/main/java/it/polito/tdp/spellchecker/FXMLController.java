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
    	model.clearDictionary();

    }



    @FXML
   void doSpellCheck(ActionEvent event) {
    	String s;
   	try {
   	language=wdwLanguage.getValue();
   	s=txtWords.getText();
   	}catch(NullPointerException npe) {
   		txtWords.setEditable(false);
   		txtResult.setText("Selezionare una lingua prima di procedere ");
   		return;
   	}
   	String parole[];
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
    ArrayList<RichWord> elenco1= new ArrayList<RichWord>();
    //long startTime = System.nanoTime();
    long startTime= System.currentTimeMillis();
  elenco1=(ArrayList<RichWord>) model.spellCheckText(worded);
//  elenco1=(ArrayList<RichWord>) model.spellCheckTextLinear(worded);
//    elenco1=(ArrayList<RichWord>) model.spellCheckTextDichotomic(worded);
    //long endTime=System.nanoTime();
    long endTime=System.currentTimeMillis();
    System.out.println(endTime-startTime);
    txtResult.setText("");
    boolean flag=false;
    for(RichWord rs: elenco1) {
    	System.out.println(rs.isCorretto());
    	if(rs.isCorretto()==false) {
    		txtResult.appendText(rs.getWord().toString()+"  "+"wrong word"+"\n");
    		flag=true;
    	}
    }
    if(flag==false) {
    	txtResult.setText("Parole corrette");
    }
   model.clearDictionary();
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
        assert wdwLanguage != null : "fx:id=\"wdwLanguage\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Dictionary model) {
    	this.model=model;
    }
}


