package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.MenuDAOimpl;
import com.foodapp.model.Menu;

public class MLaunch 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		MenuDAOimpl mdao=new MenuDAOimpl();
		
		System.out.println("Welcome to the Menu app\n"
				+ "1. Insert Menu\n"
				+ "2. View Menu List\n"
				+ "3. View Specific Menu\n"
				+ "4. Update Menu\n"
				+ "5. Delete Menu\n"
				+ "6.View menu by resturant id");
		
			int ch=scan.nextInt();
			
			if(ch==1)
			{
				System.out.println("Enter the MenuId : ");
				int Menuid=scan.nextInt();
				System.out.println("Enter the ResturantId : ");
				int resturantid=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the Name : ");
				String name=scan.nextLine();
				System.out.println("Enter the Description : ");
				String description=scan.nextLine();
				System.out.println("Enter the Price : ");
				int price=scan.nextInt();
				System.out.println("Is it Available ?");
				boolean isavailable=scan.nextBoolean();
				scan.nextLine();
				System.out.println("Enter the ImagePath : ");
				String imagePath=scan.nextLine();
				
				Menu m=new Menu(Menuid,resturantid,name,description,price,isavailable,imagePath);
				
				int x=mdao.insert(m);
				
				if(x==1)
				{
					System.out.println("Data is inserted with status"+x);
				}
				else
				{
					System.out.println("Data is not inserted with status"+x);
				}
			}
			else if(ch==2)
			{
				ArrayList<Menu> mlist=mdao.fetchall();
				for(Menu m: mlist)
				{
					System.out.println(m);
				}
			}
			else if(ch==3)
			{
				System.out.println("Enter the id : ");
				int id=scan.nextInt();
				System.out.println(mdao.fetchone(id));
			}
			else if(ch==4)
			{
				System.out.println("Enter the Id : ");
				int id=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the ImagePath");
				String imagepath=scan.nextLine();
				System.out.println(mdao.update(id, imagepath)==1?"Update Sucess": "Update Failure");
			}
			else if(ch==5)
			{
				System.out.println("Enter the Id : ");
				int id=scan.nextInt();
				System.out.println(mdao.delete(id)==1?"Delete Sucess":"Delete Failure");
			}
			else if(ch==6)
			{
				System.out.println("Enter the ResturantId ");
				int resid=scan.nextInt();
				ArrayList<Menu> mlist=mdao.fetchMenuByResturant(resid);
				for(Menu m : mlist)
				{
					System.out.println(m);
				}
			}
	} 

}
