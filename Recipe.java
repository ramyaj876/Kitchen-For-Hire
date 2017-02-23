package KitchenForHire;

import io.realm.RealmObject;

class Recipe extends RealmObject {
	String name;
	String type;
	float cost;
}