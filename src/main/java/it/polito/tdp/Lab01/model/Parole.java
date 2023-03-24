package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> words;
		
	public Parole() {
		//TODO
		//words = new ArrayList<String>();
		words = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		this.words.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		//List<String> wordsOrdineAlfabetico = new ArrayList<>();
		List<String> wordsOrdineAlfabetico = new LinkedList<>();
		if(!words.isEmpty()) {
			for(String s: words) {
				wordsOrdineAlfabetico.add(s);
			}
			Collections.sort(wordsOrdineAlfabetico, new Parole.ComparatoreParole());
			
			return wordsOrdineAlfabetico;
		}

		return null;
	}
	
	public void reset() {
		// TODO
		words.clear();
	}
	
	public void cancellaParola(String p) {
		
		words.remove(p);
	}
	
	static class ComparatoreParole implements Comparator<String>{
			
			public int compare(String arg0, String arg1){
				if(arg0.compareTo(arg1)<0)
					return -1;
				else if(arg0.compareTo(arg1)>0)
					return 1;
			return 0;
			}
	}

	
}