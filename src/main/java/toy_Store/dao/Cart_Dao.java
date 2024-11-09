package toy_Store.dao;
import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;


import toy_Store.dto.Cart;
public class Cart_Dao {
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	
	public void cpayment(Cart cart) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select ca_tcost from cart where ca_cemail=?");
		PreparedStatement pss=con.prepareStatement("select cwallet from customer where cemail=?");
		pss.setString(1,cart.getCa_cemail());
		ResultSet rss=pss.executeQuery();
		double dd=0;
		while(rss.next())
		{
			dd=rss.getDouble("cwallet");
			System.out.println("Your wallet amount is :"+dd);
		}
		ps.setString(1, cart.getCa_cemail());
		ResultSet rs=ps.executeQuery();
		double pa=0;
		while(rs.next())
		{
			pa=pa+rs.getDouble("ca_tcost");
		}
		System.out.println("Your payment bill is :"+pa);
		System.out.println("1-You want to pay bill click\n 2-no");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		if(ch==1)
		{
			if(dd>=pa)
			{
				System.out.println("Toys purchased successfully--------");
				PreparedStatement psss=con.prepareStatement("update customer set cwallet=? where cemail=?");
				double o=(dd-pa);
				psss.setDouble(1, o);
				psss.setString(2, cart.getCa_cemail());
				psss.executeUpdate();
				System.out.println("Now your wallet balance are :"+o);
			}
			else
			{
				System.out.println("You do not have enough amount to pay");
			}
		}
		else
		{
			System.out.println("Payment cancelled");
		}
	}
	public void fetchCart(Cart cart) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from cart where ca_cemail=?");
		ps.setString(1, cart.getCa_cemail());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your cart items are: \n");
			System.out.println(rs.getInt("caid")+" "+rs.getInt("ca_tid")+" "+rs.getDouble("ca_tcost"));
		}
		rs.close();
		ps.close();
		con.close();
	}
	

}
