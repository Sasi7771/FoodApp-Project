package com.foodapp.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.daoimpl.UserDAOimpl;
import com.foodapp.model.User;

public class Launch 
{
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args)
	{
		UserDAOimpl udao=new UserDAOimpl();
		
		System.out.println("Welcome to the User app\n"
				+ "1. Insert User\n"
				+ "2. View User List\n"
				+ "3. View Specific User\n"
				+ "4. Update User\n"
				+ "5. Delete User");
		
			int ch=scan.nextInt();
			
			if(ch==1)
			{
				System.out.println("Enter the ID : ");
				int id=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the Name : ");
				String name=scan.nextLine();
				System.out.println("Enter the Password : ");
				String password=scan.nextLine();
				System.out.println("Enter the Email : ");
				String email=scan.nextLine();
				System.out.println("Enter the Address : ");
				String address=scan.nextLine();
				
				User u=new User(id,name,password,email,address);
				
				int x=udao.insert(u);
				
				if(x==1)
				{
					System.out.println("Data is inserted with status "+x);
				}
				else
				{
					System.out.println("Data is not inserted with status "+x);
				}
			}
		else if(ch==2)
			{
				ArrayList<User> ulist=udao.fetchall();
				
				for(User us : ulist)
				{
					System.out.println(us);
				}
			}
		else if(ch==3)
		{
			System.out.println("Enter the ID : ");
			int id=scan.nextInt();
			System.out.println(udao.fetchone(id));
		}
	   else if(ch==4)
		{
		System.out.println("Enter the Id : ");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the Address");
		String Address=scan.nextLine();
		System.out.println(udao.update(id, Address)==1?"Update Sucess":"Update Failure");
		
		}
	   else if(ch==5)
	   {
		   System.out.println("Enter the Id : ");
			int id=scan.nextInt();
			System.out.println(udao.delete(id)==1?"Delete sucess":"Delete Failure");
			
	   }
	
	}
	
	
}
