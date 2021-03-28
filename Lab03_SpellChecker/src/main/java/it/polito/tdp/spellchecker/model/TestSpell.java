package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestSpell {

	public static void main(String[] args) {
	Dictionary dizionario = new Dictionary();
	dizionario.clearDictionary();
	dizionario.loadDictionary("Italian");
	RichWord d;
	ArrayList<String> parole= new ArrayList<String>();
	parole.add("ciao");
//	parole.add("hellvar");
	//String s ="ciao";
	//String p="paro";
	//System.out.println(p.compareTo(s));
	
	//String s="ciao come staa,cs";
	//s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
//	System.out.println(s.replaceAll("\"[$&+,:;=?@#|'<>.-^*()%!]\"", ""));
	// System.out.println(s);
	ArrayList<RichWord> words= new ArrayList<RichWord>();
	System.out.println(dizionario.spellCheckTextDichotomic(parole));
	dizionario.clearDictionary();
//	StringTokenizer st = new StringTokenizer(inputText, " ");


	}

}
