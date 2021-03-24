package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestSpell {

	public static void main(String[] args) {
	Dictionary dizionario = new Dictionary();
	dizionario.loadDictionary("English");
	RichWord d;
	ArrayList<String> parole= new ArrayList<String>();
	parole.add("a");
	parole.add("hello");
	
	String s="ciao come staa,cs";
	s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
//	System.out.println(s.replaceAll("\"[$&+,:;=?@#|'<>.-^*()%!]\"", ""));
	 System.out.println(s);
	ArrayList<RichWord> words= new ArrayList<RichWord>();
	System.out.println(dizionario.spellCheckTextDichotomic(parole).toString());
	//System.out.println(d.toString());
	
//	/*System.out.println(dizionario.toString());
/*	ArrayList<String> parole= new ArrayList<String>();
	parole.add("a");
	//System.out.println(dizionario.spellCheckText(parole));
	ArrayList<RichWord> words= new ArrayList<RichWord>();
	try {
		FileReader fr= new FileReader("src/main/resources/Italian.txt");
		BufferedReader br= new BufferedReader(fr);
		String word;
		while((word=br.readLine())!=null) {
			dizionario.dizionario.add(word);
		}System.out.println("File letto");
		br.close();
		}catch(IOException e) {
			System.out.println("Errore file");
		}*/
	
	//System.out.println(dizionario.dizionario.toString());
	//System.out.println(parole.toString());
	//System.out.println(dizionario.toString());
//	StringTokenizer st = new StringTokenizer(inputText, " ");


	}

}
