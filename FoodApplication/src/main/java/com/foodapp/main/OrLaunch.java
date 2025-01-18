package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.OrdersDAOimpl;
import com.foodapp.model.Orders;

public class OrLaunch 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		OrdersDAOimpl odao=new OrdersDAOimpl();
		
		System.out.println("Welcome to the User app\n"
				+ "1. Insert User\n"
				+ "2. View User List\n"
				+ "3. View Specific User\n"
				+ "4. Update User\n"
				+ "5. Delete User");
		
		int ch=scan.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter the OrderId : ");
			int orderid=scan.nextInt();
			System.out.println("Enter the UserId : ");
			int userid=scan.nextInt();
			System.out.println("Enter the ResturantId : ");
			int resturantid=scan.nextInt();
			System.out.println("Enter the TotalAmount : ");
			double totalamount=scan.nextDouble();
			scan.nextLine();
			System.out.println("Enter the Status : ");
			String status=scan.nextLine();
			System.out.println("Enter the PaymentMode : ");
			String paymentmode=scan.nextLine();
			
			Orders o=new Orders(orderid,userid,resturantid,totalamount,status,paymentmode);
			
			int res=odao.insert(o);
			
			if(res==1)
			{
				System.out.println("Data is inserted with status "+res);
			}
			else
			{
				System.out.println("Data is not inserted with status "+res);
			}
			break;
		case 2:
			ArrayList<Orders> olist=odao.fetchall();
			for(Orders or:olist)
			{
				System.out.println(or);
			}
			break;
		case 3:
			System.out.println("Enter the Id : ");
			int id=scan.nextInt();
			System.out.println(odao.fetchone(id));
			break;
		case 4:
			System.out.println("Enter the Id : ");
			int uid=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the PaymentMode");
			String paymentMode=scan.nextLine();
			System.out.println(odao.update(uid, paymentMode)==1?"Update Success":"Update Failure");
			break;
		case 5:
			
			System.out.println("Enter the Id : ");
			int usid=scan.nextInt();
			System.out.println(odao.delete(usid)==1?"Delete Sucess":"Delete Failure");
		}
	
	}

}
