package it.polito.tdp.spellchecker.model;
import java.io.BufferedReader;
import java.lang.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Dictionary {

	List<String> dizionario;
	public Dictionary() {
//		this.dizionario=new ArrayList();
		this.dizionario=new LinkedList();
		}
	
	public void loadDictionary(String language) {
		if(language.equals("Italian")) {
			try {
				FileReader fr= new FileReader("src/main/resources/Italian.txt");
				BufferedReader br= new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					this.dizionario.add(word);
				}
				
			}catch(IOException e){
				System.out.println("Errore da lettura file ");
			}
		}
			
		if(language.equals("English")) {try {
			FileReader fr= new FileReader("src/main/resources/English.txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while((word=br.readLine())!=null) {
				this.dizionario.add(word);
			}
			br.close();
			
		}catch(IOException e){
			System.out.println("Errore da lettura file ");
		}
	}	
		}
	public RichWord spellCheckText(String inputText){
		 	RichWord s;
			if(dizionario.contains(inputText)) {
				 s= new RichWord(inputText,true);
			}
			else {
				s= new RichWord(inputText,false);
			}
			return s;
		}
		
	
	public List<RichWord> spellCheckText(List<String> inputText){
		List<RichWord> parole= new ArrayList<RichWord>();
		for(String word:inputText) {

			if(dizionario.contains(word)) {
				RichWord s= new RichWord(word,true);
				parole.add(s);
			}
			else {
				RichWord s= new RichWord(word,false);
				parole.add(s);
			}}
		return parole;
		}
	public void clearDictionary() {
		dizionario.clear();
	}
	
public List<RichWord> spellCheckTextLinear(List<String> inputText){
	List<RichWord> parole= new ArrayList<RichWord>();
	// può essere fatto tranquillamente con il for each per la lineare 
	// poichè esso parte dall'inizio della lista
	for(String word:inputText) {
		boolean flag=false;
		for(String yy:dizionario) {

		if(yy.equals(word)) {
			RichWord s= new RichWord(word,true);
			parole.add(s);
			flag=true;
		}
		}
		if(flag==false) {
			RichWord s= new RichWord(word,false);
			parole.add(s);
		}
		}
	return parole;
	}
		
public List<RichWord> spellCheckTextDichotomic(List<String> inputText){
	List<RichWord> parole= new ArrayList<RichWord>();
	for(String word:inputText) {
		boolean flag=false;
		int counter= (Integer) (dizionario.size()/2);
		if(word.equals(dizionario.get(counter))) {
			RichWord s= new RichWord(word,true);
			parole.add(s);
			flag=true;
		}
		else {
			if(word.compareTo(dizionario.get(counter))>0) {
				for(int i=counter;i<dizionario.size();i++) {
					if(word.equals(dizionario.get(i))){
						RichWord s= new RichWord(word,true);
						parole.add(s);
						flag=true;
					}
					}
				}
			else {
				for(int i=counter;i>-1;i--) {
					if(word.equals(dizionario.get(i))){
						RichWord s= new RichWord(word,true);
						parole.add(s);
						flag=true;
				}
				
			}
			}
		}
		if(flag==false) {
			RichWord s= new RichWord(word,false);
			parole.add(s);
		}
	}
	return parole;
	}
		
	@Override
	public String toString() {
		String s="";
		for(String word: dizionario) {
			s= s+word+" \n";
		}
		return s;
	}
	
	}
