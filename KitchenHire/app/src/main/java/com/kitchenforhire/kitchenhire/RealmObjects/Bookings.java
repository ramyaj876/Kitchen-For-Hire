package com.kitchenforhire.kitchenhire.RealmObjects;

import io.realm.RealmObject;

class Bookings extends RealmObject
{
	public int ID;
	public String startTime;
	public String endTime;
	public String typeOfPackage; //select either kitchen or delivery
	public float totalCost;
}