package com.kitchenforhire.kitchenhire;

import io.realm.RealmObject;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import android.util.Log;
import android.content.Context;
import com.kitchenforhire.kitchenhire.RealmObjects.*;

class CreateRealmObjects {
	
	private Realm realm;
	CreateRealmObjects(Context appContext) {
		Realm.init(appContext);
		realm = Realm.getDefaultInstance();
	}

	User addUser(final String name, final long phoneNo, final String address, final String email) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				User newUser = realm.createObject(User.class);
				newUser.name = name;
				newUser.phoneNumber = phoneNo;
				newUser.address = address;
				newUser.email = email;
			}
		});
		final User U = realm.where(User.class).findFirst();
		return U;
	}

	Employee addEmployee(final String name, final int ID, final long phoneNo, final int position) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Employee newEmployee = realm.createObject(Employee.class);
				newEmployee.name = name;
				newEmployee.id = ID;
				newEmployee.phoneNumber = phoneNo;
				newEmployee.position = position;
			}
		});
		final Employee E = realm.where(Employee.class).findFirst();
		return E;
	}

	Bookings addBookings(final int ID, final String startTime, final String endTime, final String typeOfPackage, final float totalCost) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Bookings newBookings = realm.createObject(Bookings.class);
				newBookings.ID = ID;
				newBookings.startTime = startTime;
				newBookings.endTime = endTime;
				newBookings.typeOfPackage = typeOfPackage;
				newBookings.totalCost = totalCost;
			}
		});
		final Bookings B = realm.where(Bookings.class).findFirst();
		return B;
	}

	Address addAddress(final String address) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Address newAddress = realm.createObject(Address.class);
				newAddress.address = address;
			}
		});
		final Address Add = realm.where(Address.class).findFirst();
		return Add;
	}

	Accessories addAccessories(final String name, final int quantity) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Accessories newAccessories = realm.createObject(Accessories.class);
				newAccessories.name = name;
				newAccessories.quantity = quantity;
			}
		});
		final Accessories A = realm.where(Accessories.class).findFirst();
		return A;
	}

	Ingredients findIngredient(final String name)
	{	//returns ingredient if found, otherwise returns null
		RealmResults<Ingredients> reqIngredient = realm.where(Ingredients.class).equalTo("Ingredients.name", name).findAll();
		if (reqIngredient.size() != 0)
			return reqIngredient.first();
		else
			return null;
	}

	Ingredients addNewIngredientToRecipe(final String name, final String unit, final String unitQuantity, final Recipe newRecipe) {
		//creating a new ingredient in the database
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Ingredients newIngredient = realm.createObject(Ingredients.class);
				newIngredient.name = name;
				newIngredient.unit = unit;
				newIngredient.unitQuantity = unitQuantity;

				//adding to a recipe
				newRecipe.ingredients.add(newIngredient);
			}
		});
		final Ingredients I = realm.where(Ingredients.class).findFirst();
		return I;
	}

	Recipe addIngredientToRecipe(final Recipe newRecipe, final Ingredients reqIngredient)
	{
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				newRecipe.ingredients.add(reqIngredient);
			}
		});
		return newRecipe;
	}

	Recipe addRecipe(final String name, final String type, final float cost) {
		final Recipe newRecipe = realm.createObject(Recipe.class);
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				newRecipe.name = name;
				newRecipe.type = type;
				newRecipe.cost = cost;
			}
		});
		final Recipe r = realm.where(Recipe.class).findFirst();
		return newRecipe;
	}
}