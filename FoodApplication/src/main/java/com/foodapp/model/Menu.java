package com.foodapp.model;

public class Menu 
{
	private int MenuId;
	private int ResturantId;
	private String Name;
	private String Description;
	private int Price;
	private boolean isAvailable;
	private String ImagePath;
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public Menu() {
		super();
	}
	public Menu(int menuId, int resturantId, String name, String description, int price, boolean isAvailable,
			String imagePath) {
		super();
		MenuId = menuId;
		ResturantId = resturantId;
		Name = name;
		Description = description;
		Price = price;
		this.isAvailable = isAvailable;
		ImagePath = imagePath;
	}
	@Override
	public String toString() {
		return  MenuId + "   " + ResturantId + "   " + Name + "   "+ Description + "   " + Price + "   " + isAvailable + "   " + ImagePath ;
				
	}
	
}
