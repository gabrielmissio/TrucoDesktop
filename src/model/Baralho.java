package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
	
	List<Carta> list_baralho = new ArrayList<Carta>();
	
	public Baralho() {
		gerarBaralho();
	}
	
	private void gerarBaralho() {
		for(int i = 0; i < 4; i++) {
			for(int j = 4; j < 13; j++) {//cartas do 4 ao 12 (sem 8 e 9 eh claro)
				if(!(j == 8 || j == 9)) {
					Carta carta = new Carta(String.valueOf(j), j-3, i);
					list_baralho.add(carta);
				}//7 de faca 4 de tras para frente index 24
				//index 12 7 belo	
			}
			for(int j = 1; j < 4; j++) {//cartas do um ao 3
				if(!((j == 1 && i == 3) || (j == 1 && i == 2))) {//12 peso = 9
					Carta carta = new Carta(String.valueOf(j), j + 9, i);
					list_baralho.add(carta);
				}	
			}
		}
		list_baralho.remove(32);
		list_baralho.remove(13);
		cartasEspeciais();
		System.out.println(list_baralho.toString());
		System.out.println(list_baralho.size());
	}
	
	//0 - copas | 1 - ouro | 2 - paus | 3 - espada
	private void cartasEspeciais() {
		//String nome, int peso, int naipe
		Carta espadadao = new Carta("espadao", 16, 3);
		Carta pauzao = new Carta("pauzao", 15, 2);
		Carta sete_faca = new Carta("7 faca", 14, 3);
		Carta sete_belo = new Carta("7 belo", 13, 1);
		list_baralho.add(espadadao);
		list_baralho.add(pauzao);
		list_baralho.add(sete_belo);
		list_baralho.add(sete_faca);
	}
	
	List<Carta> getBaralho(){
		List<Carta> novoBaralho = new ArrayList<Carta>(list_baralho);
		Collections.shuffle(novoBaralho);//embaralha
		return novoBaralho;
	}
	
}
