package toy_Store.Controller;

import java.util.Scanner; 

import toy_Store.dao.Cart_Dao;
import toy_Store.dao.Customer_Dao;
import toy_Store.dao.Payment_Dao;
import toy_Store.dao.Shop_Dao;
import toy_Store.dao.Toys_Dao;
import toy_Store.dao.Vendor_Dao;
import toy_Store.dto.Cart;
import toy_Store.dto.Customer;
import toy_Store.dto.Shop;
import toy_Store.dto.Toys;
import toy_Store.dto.Vendor;

public class Toy_Store_Main {
	static Scanner sc=new Scanner(System.in);
	static Customer_Dao cdao=new Customer_Dao();
	static Vendor_Dao vdao=new Vendor_Dao();
	static Shop_Dao sdao=new Shop_Dao();
	static Toys_Dao tdao=new Toys_Dao();
	static Cart_Dao cadao=new Cart_Dao();
	static Payment_Dao pdao=new Payment_Dao();
	private static String cuemail=null;
	private static String veemail=null;
	public static void main(String[] args) throws Exception {
		cdao.createTable();
		vdao.createTable();
		sdao.createTable();
		tdao.createTable();
		tdao.createTables();
		pdao.createTable();
		System.out.println("+++++++++++   WELCOME TO THE 'TOY STORE'   +++++++++++");
		boolean check=true;
		while(check)
		{
			System.out.println("Please choose \n 1-Customer \n 2-Vendor \n 3-Exit");
			int key=sc.nextInt();
			switch (key) {
			case 1:
			{
				boolean b=true;
				while(b)
				{
					System.out.println("Please choose \n 1-Register \n 2-Login \n 3-Exit");
					int ke=sc.nextInt();
					switch (ke) {
					case 1:
					{
						createCregister();
					}
					break;
					case 2:
					{
						boolean hello=cLogin();
						if(hello==true)
						{
							boolean bo=true;
							while(bo)
							{
								System.out.println("Please choose \n 1-Shopping \n 2-Profile \n 3-Exit");
								int k=sc.nextInt();
								switch (k) {
								case 1:
								{
									fetchAlll();
									System.out.println();
									boolean boo=true;
									while(boo)
									{
										System.out.println("Please choose \n 1-Browse Toys \n 2-Bucket/Add To Cart \n 3-Payment \n 4-Exit");
										int kee=sc.nextInt();
										switch (kee) {
										case 1:
										{
											System.out.println("enter 1-Browse toy by brand \n 2-Browse toy by cost");
											int bro=sc.nextInt();
											switch(bro)
											{
											case 1:
											{
												tbrowsing();
											}
											break;
											case 2:
											{
												tbrowsingg();
											}
											break;
											default:System.out.println("You have entered a wrong choice");
											break;
											}
										}
										break;
										case 2:
										{
											fetchAlll();
											System.out.println("---------------------------------\n");
											System.out.println("1-Add to cart \n 2-see your cart \n 3-Remove from cart");
											int pp=sc.nextInt();
											switch(pp)
											{
											case 1:
											{
												acart(cuemail);
											}
											break;
											case 2:
											{
												cCart(cuemail);
												System.out.println("---------------------------------\n");
											}
											break;
											case 3:
											{
												cCart(cuemail);
												System.out.println("---------------------------------\n");
												rcart();
											}
											break;
											default:System.out.println("Invalid choice");
											}
										}
										break;
										case 3:
										{
											payment(cuemail);
										}
										break;
										case 4:boo=false;
										break;
										default:System.out.println("Please choose valid choice");
										break;
										}
									}
								}
								break;
								case 2:
								{
									boolean boo=true;
									while(boo)
									{
										System.out.println("Please choose \n 1-Update \n 2-Delete \n 3-Profile \n 4-Exit");
										int kee=sc.nextInt();
										switch (kee) {
										case 1:
										{
											cuupdate(cuemail);
										}
										break;
										case 2:
										{
											cudelete(cuemail);
										}
										break;
										case 3:
										{
											cuprofile(cuemail);
										}
										break;
										case 4:boo=false;
										break;
										default:System.out.println("Please choose valid choice");
										break;
										}
									}
								}
								break;
								case 3:bo=false;
								break;
								default:System.out.println("Please choose valid choice");
								break;
								}
							}
						}
						else
						{
							System.err.println("You have entered wrong email or password please try again");
						}
					}
					break;
					case 3:b=false;
					break;
					default:System.out.println("Please choose valid choice");
					break;
					}
				}
			}
			break;
			case 2:
			{
				boolean b=true;
				while(b)
				{
					System.out.println("Please choose \n 1-Register \n 2-Login \n 3-Exit");
					int ke=sc.nextInt();
					switch (ke) {
					case 1:
					{
						createVRegister();
					}
					break;
					case 2:
					{
						boolean hi=vLogin();
						if(hi==true)
						{
							
							boolean bo=true;
							while(bo)
							{
								System.out.println("Please choose \n 1-Shop \n 2-Profile \n 3-Exit");
								int k=sc.nextInt();
								switch (k) {
								case 1:
								{
									boolean booo=true;
									while(booo)
									{
										System.out.println("Please choose \n 1-Create Shop \n 2-Update Shop \n 3-Delete Shop \n 4-Fetch Shop \n 5-Create Toys \n 6-Update Toys \n 7-Delete Toys \n 8-Exit");
										int keee=sc.nextInt();
										switch (keee) {
										case 1:
										{
											cshop(veemail);
										}
										break;
										case 2:
										{
											ushop(veemail);
										}
										break;
										case 3:
										{
											dshop(veemail);
										}
										break;
										case 4:
										{
											fshop(veemail);
										}
										break;
										case 5:
										{
											ctoys(veemail);
										}
										break;
										case 6:
										{
											utoys(veemail);
										}
										break;
										case 7:
										{
											dtoys(veemail);
										}
										break;
										case 8:booo=false;
										break;
										default:System.out.println("Please choose valid choice");
										break;
										}
									}
								}
								break;
								case 2:
								{
									boolean boo=true;
									while(boo)
									{
										System.out.println("Please choose \n 1-Update \n 2-Delete \n 3-Profile \n 4-Exit");
										int kee=sc.nextInt();
										switch (kee) {
										case 1:
										{
											veupdate(veemail);
										}
										break;
										case 2:
										{
											vedelete(veemail);
										}
										break;
										case 3:
										{
											veprofile(veemail);
										}
										break;
										case 4:boo=false;
										break;
										default:System.out.println("Please choose valid choice");
										break;
										}
									}
								}
								break;
								case 3:bo=false;
								break;
								default:System.out.println("Please choose valid choice");
								break;
								}
							}
						}
					}
					break;
					case 3:b=false;
					break;
					default:System.out.println("Please choose valid choice");
					break;
					}
				}
			}
			break;
			case 3:	check=false;
			break;
			default:System.out.println("Please choose valid choice");
			break;
			}
		}
		System.out.println("+++++++++++   THANK YOU PLEASE VISIT AGAIN   ++++++++++");
		
	}
	
	/*
	 * customer module starts from here
	 */

	//  creating  customer registration
	private static void createCregister() {
		System.out.println("Enter your email :");
		String email=sc.next();
		System.out.println("Enter your password :");
		String pwd=sc.next();
		System.out.println("Enter your wallet amount :");
		Double wallet=sc.nextDouble();
		Customer cus=new Customer(email,pwd,wallet);
		try {
			int a=cdao.customerRegister(cus);
			if(a>0)
			{
				System.out.println("Your registration successfully---------");
			}
		} catch (Exception e) {
			System.err.println("The data is already exist please try again---");
			createCregister();
			
		}
	}
	
	// creating login
	private static boolean cLogin() throws Exception
	{
		while(true)
		{
			System.out.println("Enter your email :");
			String email=sc.next();
			System.out.println("Enter your password :");
			String pwd=sc.next();
			Customer cus=new Customer(email,pwd, null);
		    if(cdao.cuLogin(cus))
		    {
		    	cuemail=email;
		    	return true;
		    }
		    else
		    {
		    	System.err.println("You have entered wrong email or password please try again");
		    }
		}
	}
	
	//creating update
	
	private static void cuupdate(String cuemail) throws Exception
	{
		System.out.println("Enter your new password");
		String pwd=sc.next();
		System.out.println("Enter your new wallet money");
		double wall=sc.nextDouble();
		Customer cus=new Customer(cuemail, pwd, wall);
		int a=cdao.cupdate(cus);
		if(a>0)
		{
			System.out.println("Your profile updated successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	//creating delete
	private static void cudelete(String cuemail) throws Exception
	{
		Customer cus=new Customer(cuemail, null, null);
		int a=cdao.cdelete(cus);
		if(a>0)
		{
			System.out.println("Your profile deleted successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	// creating profile
		private static void cuprofile(String cuemail) throws Exception
		{
			Customer cus=new Customer(cuemail, null, null);
			cdao.cprofile(cus);
		}
		
		//fetchcart
		private static void cCart(String cuemail) throws Exception
		{
			Cart cart=new Cart(0, 0, cuemail);
			cadao.fetchCart(cart);
		}
	//creating browsing
		private static void tbrowsing() throws Exception
		{
			System.out.println("Enter toy brand");
			String brand=sc.next();
			Toys toys=new Toys(brand, null, null, null, 0, null);
			tdao.browseToys(toys);
		}
		
		private static void tbrowsingg() throws Exception
		{
			System.out.println("Enter toy cost");
			Double cost=sc.nextDouble();
			Toys toys=new Toys(null, cost, null, null, 0, null);
			tdao.browseToyss(toys);
		}
		
		private static void acart(String cuemail) throws Exception
		{
			System.out.println("Enter toy id");
			int id=sc.nextInt();
			Cart cart=new Cart(id, 0, cuemail);
			int a=tdao.addToCart(cart);
			if(a>0)
			{
				System.out.println("Toy added to cart successfully-----");
			}
			else
			{
				System.out.println("You have entered wrong toy id-----");
			}
		}
		private static void rcart() throws Exception
		{
			System.out.println("Enter toy id");
			int id=sc.nextInt();
			Cart cart=new Cart(id, 0, null);
			int a=tdao.removeCart(cart);
			if(a>0)
			{
				System.out.println("Toy removed from cart successfully-----");
			}
			else
			{
				System.out.println("You have entered wrong toy id-----");
			}
		}
		
		private static void payment(String cuemail) throws Exception
		{
			Cart cart=new Cart(0, 0, cuemail);
			pdao.cpayment(cart);
		}
		
		private static void fetchAlll() throws Exception
		{
			tdao.fetchAll();
		}
	
/*
 *  vendor module starts from here
 */
	
	//  creating vendor registration
	private static void createVRegister() {
		System.out.println("Enter your email :");
		String email=sc.next();
		System.out.println("Enter your password :");
		String pwd=sc.next();
		Vendor ven=new Vendor(email,pwd);
		try {
			int a=vdao.vendorRegister(ven);
			if(a>0)
			{
				System.out.println("Your registration successfully---------");
			}
		} catch (Exception e) {
			System.err.println("The data is already exist please try again---");
			createVRegister();
		}
	}
	
	// creating login
	private static boolean vLogin() throws Exception
	{
		while(true)
		{
			System.out.println("Enter your email :");
			String email=sc.next();
			System.out.println("Enter your password :");
			String pwd=sc.next();
			Vendor ven=new Vendor(email,pwd);
		    if(vdao.veLogin(ven))
		    {
		    	veemail=email;
		    	return true;
		    }
		    else
		    {
		    	System.err.println("You have entered wrong email or password please try again");
		    }
		}
	}
	// creating update
	private static void veupdate(String veemail) throws Exception
	{
		System.out.println("Enter your new password");
		String pwd=sc.next();
		Vendor ven=new Vendor(veemail, pwd);
		int a=vdao.vupdate(ven);
		if(a>0)
		{
			System.out.println("Your profile updated successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	
	// creating delete
	
	private static void vedelete(String veemail) throws Exception
	{
		Vendor ven=new Vendor(veemail, null);
		int a=vdao.vdelete(ven);
		if(a>0)
		{
			System.out.println("Your profile deleted successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	// creating profile
	private static void veprofile(String veemail) throws Exception
	{
		Vendor ven=new Vendor(veemail, null);
		vdao.vprofile(ven);
	}
	// creating shop
	private static void cshop(String veemail) throws Exception
	{
		System.out.println("Enter shop name");
		String name=sc.next();
		System.out.println("Enter shop address");
		String address=sc.next();
		Shop shop=new Shop(name,address,veemail);
		int a=sdao.createShop(shop);
		if(a>0)
		{
			System.out.println("Your shop created successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	//creating update
	private static void ushop(String veemail) throws Exception
	{
		System.out.println("Enter new shop name");
		String name=sc.next();
		System.out.println("Enter new shop address");
		String address=sc.next();
		Shop shop=new Shop(name,address,veemail);
		int a=sdao.updateShop(shop);
		if(a>0)
		{
			System.out.println("Your shop updated successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	//creating delete shop
	private static void dshop(String veemail) throws Exception
	{
		Shop shop=new Shop(null,null,veemail);
		int a=sdao.deleteShop(shop);
		if(a>0)
		{
			System.out.println("Your shop deleted successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	// creating fetching shop
	
	private static void fshop(String veemail) throws Exception
	{
		Shop shop=new Shop(null,null,veemail);
		sdao.fetchShop(shop);
	}
	
	//creating toys
	private static void ctoys(String veemail) throws Exception
	{
		System.out.println("Enter toy brand");
		String brand=sc.next();
		System.out.println("Enter toy cost");
		double cost=sc.nextDouble();
		System.out.println("Enter toy type");
		String type=sc.next();
		System.out.println("Enter toy color");
		String color=sc.next();
		System.out.println("Enter toy quantity");
		int quantity=sc.nextInt();
		Toys toys=new Toys(brand, cost, type, color, quantity, veemail);
		int a=tdao.createToys(toys);
		if(a>0)
		{
			System.out.println("Your toys created successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
		
	}
	// creating update
	private static void utoys(String veemail) throws Exception
	{
		System.out.println("Enter new toy brand");
		String brand=sc.next();
		System.out.println("Enter new toy cost");
		double cost=sc.nextDouble();
		System.out.println("Enter new toy type");
		String type=sc.next();
		System.out.println("Enter new toy color");
		String color=sc.next();
		System.out.println("Enter new toy quantity");
		int quantity=sc.nextInt();
		Toys toys=new Toys(brand, cost, type, color, quantity, veemail);
		int a=tdao.updateToys(toys);
		if(a>0)
		{
			System.out.println("Your toys created successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
		
	}
	//creating delete
	private static void dtoys(String veemail) throws Exception
	{
		Toys toys=new Toys(null, null, null, null,0, veemail);
		int a=tdao.deleteToys(toys);
		if(a>0)
		{
			System.out.println("Your toys deleted successfully----------");
		}
		else
		{
			System.err.println("You have enterd wrong email");
		}
	}
	
}
