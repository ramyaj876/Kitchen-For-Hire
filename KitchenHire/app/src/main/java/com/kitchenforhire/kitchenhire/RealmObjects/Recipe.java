package com.kitchenforhire.kitchenhire.RealmObjects;

import io.realm.RealmObject;

class Recipe extends RealmObject {
	public String name;
	public String type;
	public float cost;
	public String description;
}