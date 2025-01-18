package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.OrderItemsDAOimpl;
import com.foodapp.model.OrderItems;

public class OrItemsLaunch 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		OrderItemsDAOimpl oidao=new OrderItemsDAOimpl();
		
		System.out.println("Welcome to the OrderItems app\n"
				+ "1. Insert OrderItems\n"
				+ "2. View OrderItems List\n"
				+ "3. View Specific OrderItems\n"
				+ "4. Update OrderItems\n"
				+ "5. Delete OrderItems");
		
		int ch=scan.nextInt();
		
		if(ch==1)
		{
			System.out.println("Enter the OrderItemsId : ");
			int id=scan.nextInt();
			System.out.println("Enter the OrderId : ");
			int orid=scan.nextInt();
			System.out.println("Enter the MenuId : ");
			int Menuid=scan.nextInt();
			System.out.println("Enter the Quantity : ");
			int quantity=scan.nextInt();
			System.out.println("Enter the ItemTotal : ");
			int itemtotal=scan.nextInt();
			
			OrderItems oi=new OrderItems(id,orid,Menuid,quantity,itemtotal);
			
			System.out.println(oidao.insert(oi)==1?"Data Inserted":"Data Is Not Inserted");
		}
		else if(ch==2)
		{
			ArrayList<OrderItems >oilist=oidao.fetchall();		
			for(OrderItems oi:oilist)
			{
				System.out.println(oi);
			}
		}
		else if(ch==3)
		{
			System.out.println("Enter the id: ");
			int id=scan.nextInt();
			System.out.println(oidao.fetchone(id));
		}
		else if(ch==4)
		{
			System.out.println("Enter the id: ");
			int id=scan.nextInt();
			System.out.println("Enter the Quantity: ");
			int quantity=scan.nextInt();
			System.out.println(oidao.update(quantity, id)==1?"Update Sucess":"Update Failure");
		}
		else if(ch==5)
		{
			System.out.println("Enter the id : ");
			int id=scan.nextInt();
			System.out.println(oidao.delete(id)==1?"Delete Success":"Delete Failure");
		}
	}

}
