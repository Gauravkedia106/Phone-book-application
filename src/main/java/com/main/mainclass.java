package com.main;

import java.sql.Connection;
import java.util.*;


import com.conn.DBConnect;
import com.dao.ContactDAO;
import com.entity.contact;

public class mainclass {
	
	public static void main(String[] args)
	{
        boolean f=true;
		
        
        while(f)
        {
        	System.out.println(".............................");
        	System.out.println("1 Create Contact");
        	System.out.println("2 Edit Contact");
        	System.out.println("3 Delete Contact");
        	System.out.println("4 View Contact");
        	System.out.println("5 Exit");
        	
        	System.out.println(".............................");
        	
        	Scanner sc =new Scanner(System.in);
        	System.out.println("Entre No");
        	
        	int no = sc.nextInt();
        	ContactDAO da = new ContactDAO(DBConnect.getConn());
        	
        	switch(no) {
        	
        	case 1:
        		System.out.println("Entre Name");
        		String name =sc.next();
        		
        		System.out.println("Entre Phone no");
        		String phoneNo =sc.next();
        		
        		contact c=new contact();
        		c.setName(name);
        		c.setphone(phoneNo);
        		
        		
        		 boolean s1 = da.Savecontact(c);
        		
        		if(s1)
        		{
        			System.out.println("No Saved Succefully..");
        		}
        		else
        		{
        			System.out.println("Something Wrong on Server..");
        		}
        		
        		
        		break;
        		
        	case 2:
        		
        		System.out.println("Entre Id");
        		int id =sc.nextInt();
        		
        		System.out.println("Entre Name");
        		String name2 =sc.next();
        		
        		System.out.println("Entre Phone no");
        		String phoneNo2 =sc.next();
        		
        		contact c2=new contact();
        		c2.setId(id);
        		c2.setName(name2);
        		c2.setphone(phoneNo2);
        		
        		
        		boolean s2 = da.Editdata(c2);
        		
        		if(s2)
        		{
        			System.out.println("Edit Sucessfully..");
        		}
        		else
        		{
        			System.out.println("User is Not Available..");
        		}
        		
        		
        		
        		
        		
        		break;
        		
        		
        	case 3:
        		
        		System.out.println("Entre Id");
        		int id3 =sc.nextInt();
        		
        	
        		boolean s3 = da.Deletedata(id3);
        		
        		if(s3)
        		{
        			System.out.println("Deleate Sucessfully..");
        		}
        		else
        		{
        			System.out.println("User is Not Available..");
        		}
        		
        		
        		break;
        		
        		
        	case 4:
        		
        		List<contact> list=da.getAllcontact();
        		
        		if(list.isEmpty())
        		{
        			System.out.println("Phone is Not available");
        		}
        		else
        		{
        			for(contact con:list)
        			{
        				System.out.println("Id= "+con.getId());
        				System.out.println("Name= "+con.getName());
        				System.out.println("PhoneNo= "+con.getphone());
        				
        				System.out.println("===================================");
        			}
        		}
        		
        		break;
        		
        		
        	case 5:
        		f=false;
        		System.out.println("Thank You....Visit Again ");
        		break;
        		
        		default:
        			System.out.println("Invalid Number..");
        			System.out.println("Plese Entre Correct NO");
        			break;
        	
        	}
        	
        }
		
	}

}
