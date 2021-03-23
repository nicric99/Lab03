package it.polito.tdp.spellchecker.model;

public class RichWord {
	String word;
	boolean corretto;
	
	public RichWord(String word,boolean corretto) {
		this.word = word;
		this.corretto = corretto;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	@Override
	public String toString() {
		return "RichWord [word=" + word + ", corretto=" + corretto + "]";
	}
	
	
	
}
