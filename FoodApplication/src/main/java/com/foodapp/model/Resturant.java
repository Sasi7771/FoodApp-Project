package com.foodapp.model;

public class Resturant 
{
	private int ResturantId;
	private String Name;
	private String CuisineType;
	private int DeliveryTime;
	private String Address;
	private float Ratings;
	private boolean isActive;
	private String ImagePath;
	public int getResturantId() {
		return ResturantId;
	}
	public void setResturantId(int resturantId) {
		ResturantId = resturantId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCuisineType() {
		return CuisineType;
	}
	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}
	public int getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public float getRatings() {
		return Ratings;
	}
	public void setRatings(float ratings) {
		Ratings = ratings;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public Resturant() {
		super();
	}
	public Resturant(int resturantId, String name, String cuisineType, int deliveryTime, String address, float ratings,
			boolean isActive, String imagePath) {
		super();
		ResturantId = resturantId;
		Name = name;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		Address = address;
		Ratings = ratings;
		this.isActive = isActive;
		ImagePath = imagePath;
	}
	@Override
	public String toString() {
		return  ResturantId + "   " + Name + "   " + CuisineType
				+ "   " + DeliveryTime + "   " + Address + "   " + Ratings + "   "
				+ isActive + "   " + ImagePath ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
