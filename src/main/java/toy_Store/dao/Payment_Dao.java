package toy_Store.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import toy_Store.dto.Cart;

public class Payment_Dao {
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	public void createTable() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists payment(pid int AUTO_INCREMENT primary key,pbill double,p_cus_id int)");
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
				PreparedStatement pssss=con.prepareStatement("select cid from customer where cemail=?");
				pssss.setString(1, cart.getCa_cemail());
				ResultSet rsss=pssss.executeQuery();
				int idd=0;
				while(rsss.next())
				{
					idd=rsss.getInt("cid");
				}
				PreparedStatement pt=con.prepareStatement("insert into payment(pbill,p_cus_id) values(?,?)");
				pt.setDouble(1, pa);
				pt.setInt(2, idd);
				pt.execute();
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

}
