package com.kitchenforhire.kitchenhire.RealmObjects;

import io.realm.RealmObject;

public class User extends RealmObject
{
 	public String name;
 	public long phoneNumber;
	public String address;
	public String email;
}