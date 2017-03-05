package com.kitchenforhire.kitchenhire.RealmObjects;

import io.realm.RealmObject;
import io.realm.RealmList;

public class Recipe extends RealmObject {
	
	public String name;
	public String type;
	public float cost;
	public String description;					//providing instructions
	public RealmList<Ingredients> ingredients;	//stores the list of ingredients

	Recipe()
	{
		ingredients = new RealmList<Ingredients>();
	}
}