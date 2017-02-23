class Bookings extends RealmObject
{
	int id;
	String startTime;
	String endTime;
	String typeOfPackage; //select either kitchen or delivery
	float totalCost;
}
