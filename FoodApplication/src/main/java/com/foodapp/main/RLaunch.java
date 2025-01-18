package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.ResturantDAOimpl;
import com.foodapp.model.Resturant;

public class RLaunch 
{
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		ResturantDAOimpl rdao=new ResturantDAOimpl();
		
		System.out.println("Welcome to the Resturant app\n"
				+ "1. Insert Resturant\n"
				+ "2. View Resturant List\n"
				+ "3. View Specific Resturat\n"
				+ "4. Update Resturant\n"
				+ "5. Delete Resturant");
		
			int ch=scan.nextInt();
			
			if(ch==1)
			{
				System.out.println("Enter the Id : ");
				int id=scan.nextInt();
				scan.nextLine();
				System.out.println("Entre the Name : ");
				String name=scan.nextLine();
				System.out.println("Entre the CuisineType : ");
				String cuisineType=scan.nextLine();
				System.out.println("Enter the DeliveryTime : ");
				int deliveryTime=scan.nextInt();
				scan.nextLine();
				System.out.println("Entre the Address : ");
				String address=scan.nextLine();
				System.out.println("Enter the ratings : ");
				float ratings=scan.nextFloat();
				System.out.println("Enter the isActive : ");
				boolean isActive=scan.nextBoolean();
				scan.nextLine();
				System.out.println("Enter the ImagePath : ");
				String imagePath=scan.nextLine();
				
				
				Resturant r=new Resturant(id,name,cuisineType,deliveryTime,address,ratings,isActive,imagePath);
				
				int x=rdao.insert(r);
				
				if(x==1)
				{
					System.out.println("Data is inserted with statux "+x);
				}
				else
				{
					System.out.println("Data is not inserted with statux "+x);
				}
			}
			else if(ch==2)
			{
				ArrayList<Resturant> rlist=rdao.fetchall();
				
				for(Resturant r:rlist)
				{
					System.out.println(r);
				}
			}
			else if(ch==3)
			{
				System.out.println("Enter the Id : ");
				int id=scan.nextInt();
				System.out.println(rdao.fetchone(id));
			}
			else if(ch==4)
			{
				System.out.println("Enter the Id :");
				int id=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the ImagePath : ");
				String imagePath=scan.nextLine();
				System.out.println(rdao.update(id, imagePath)==1?"Update Sucesss":"Update Failure");
			}
			else if(ch==5)
			{
				System.out.println("Enter the Id :");
				int id=scan.nextInt();
				System.out.println(rdao.delete(id)==1?"Delete Sucess" :"Delete Failure ");
			}
		
		
		
		
	}
	
}
