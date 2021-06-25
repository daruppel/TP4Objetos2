package main;

import dominio.*;

public class main {

	public static void main(String[] args) {
		Combo comboBasico = new ComboBasico("Hamburguesa, Soda", 250);
		Combo comboBasicoConPapas = new Porcion("Papa",50,comboBasico);
		Combo comboBasicoConPapasYTomates = new Porcion("Tomate", 35, comboBasicoConPapas);
		System.out.println(comboBasico.descripcion());
		System.out.println(comboBasico.costo());
		System.out.println(comboBasicoConPapas.descripcion());
		System.out.println(comboBasicoConPapas.costo());
		System.out.println(comboBasicoConPapasYTomates.descripcion());
		System.out.println(comboBasicoConPapasYTomates.costo());
		
		
		Combo comboFamiliar = new ComboFamiliar("4 Hamburguesas, 2 Sodas, 5 Papas", 600);
		Combo comboFamiliarConQueso = new Porcion("Queso", 40, comboFamiliar);
		Combo comboFamiliarConQuesoYTomate = new Porcion("Tomate", 35, comboFamiliarConQueso);
		System.out.println(comboFamiliar.descripcion());
		System.out.println(comboFamiliar.costo());
		System.out.println(comboFamiliarConQueso.descripcion());
		System.out.println(comboFamiliarConQueso.costo());
		System.out.println(comboFamiliarConQuesoYTomate.descripcion());
		System.out.println(comboFamiliarConQuesoYTomate.costo());
	}

}
