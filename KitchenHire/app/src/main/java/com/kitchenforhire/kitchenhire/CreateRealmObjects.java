package com.kitchenforhire.kitchenhire;

import io.realm.RealmObject;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import android.util.Log;
import android.content.Context;
import com.kitchenforhire.kitchenhire.RealmObjects.User;

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
}