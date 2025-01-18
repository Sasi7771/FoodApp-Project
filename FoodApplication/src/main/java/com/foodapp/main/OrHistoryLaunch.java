package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.OrderHistoryDAOimpl;
import com.foodapp.model.OrderHistory;

public class OrHistoryLaunch 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		OrderHistoryDAOimpl ohdao=new OrderHistoryDAOimpl();
		
		
		System.out.println("Welcome to the OrderHistory app\n"
				+ "1. Insert OrderHistory\n"
				+ "2. View OrderHistory List\n"
				+ "3. View Specific OrderHistory\n"
				+ "4. Update OrderHistory\n"
				+ "5. Delete OrderHistory");
		
		int ch=scan.nextInt();
		
		
		if(ch==1)
		{
			
			System.out.println("Enter the OrderHistoryId : ");
			int orderhistoryid=scan.nextInt();
			System.out.println("Enter the OrderId : ");
			int orderid=scan.nextInt();
			System.out.println("Enter the UserId : ");
			int userid=scan.nextInt();
			System.out.println("Enter the TotalAmount : ");
			int totalamount=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Status : ");
			String status=scan.nextLine();
			
			OrderHistory oh=new OrderHistory(orderhistoryid,orderid,userid,totalamount,status);
			
			System.out.println(ohdao.insert(oh)==1?"Success":"Failure");
		}
		else if(ch==2)
		{	
			ArrayList<OrderHistory> oh=ohdao.fetchall();
			for(OrderHistory res:oh)
			{
				System.out.println(res);
			}
		}
		else if(ch==3)
		{
			System.out.println("Enter the Id : ");
			int id=scan.nextInt();
			System.out.println(ohdao.fetchone(id));
		}
		else if(ch==4)
		{
			System.out.println("Enter the Id : ");
			int id=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Status : ");
			String status=scan.nextLine();
			System.out.println(ohdao.update(id, status)==1?"Update Success":"Update Failure");
		}
		
		else if(ch==5)
		{
			System.out.println("Enter the Id : ");
			int id=scan.nextInt();
			System.out.println(ohdao.delete(id)==1?"Delete Success":"Delete Failure");
		}
		
	}

}
