package model;

import java.util.ArrayList;
import java.util.List;

import utils.Itemvalues;

public class Model {

	public List<Itemvalues> itemvalues = new ArrayList<Itemvalues>();
	public int totalCost = 0;
	public String name1 = "Eingabe Vorname";
	public String name2 = "Eingabe Nachname";
	public String street = "Eingabe Strasse";
	public String streetNumber = "Eingabe Hausnummer";
	public String city = "Eingabe Stadt";
	public String postalcode = "Eingabe PLZ";
	public String country = "Eingabe Land";
	public String paymentOption = "";

	public Model() {

	}

	public void reset() {
		this.itemvalues = new ArrayList<Itemvalues>();
		this.totalCost = 0;
		this.name1 = "Eingabe Vorname";
		this.name2 = "Eingabe Nachname";
		this.street = "Eingabe Strasse";
		this.streetNumber = "Eingabe Hausnummer";
		this.city = "Eingabe Stadt";
		this.postalcode = "Eingabe PLZ";
		this.country = "Eingabe Land";
		this.paymentOption = "";
	}

	public int totalCost() {
		int amount = 0;
		for (Itemvalues itemvalues : itemvalues) {
			amount += itemvalues.amount * itemvalues.cost;
		}
		totalCost = amount;
		return amount;
	}

	public boolean itemExists(String name) {
		for (Itemvalues itemvalues : itemvalues) {
			if (itemvalues.name == name) {
				return true;
			}
		}
		return false;
	}

	public Itemvalues getItem(String name) {
		for (Itemvalues itemvalues : itemvalues) {
			if (itemvalues.name == name) {
				return itemvalues;
			}
		}
		return null;
	}

}
