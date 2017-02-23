package com.kitchenforhire.kitchenhire.RealmObjects;

import io.realm.RealmObject;

class Employee extends RealmObject
{
	public String name;
	public int id;
	public long phoneNumber;
	public int position;
}