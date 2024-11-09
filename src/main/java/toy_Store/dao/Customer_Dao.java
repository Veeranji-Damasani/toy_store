package toy_Store.dao;

import java.sql.Statement;  

import toy_Store.dto.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer_Dao {
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	public void createTable() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists customer(cid int AUTO_INCREMENT primary key,cemail varchar(45) unique,cpwd varchar(45),cwallet double)");
	}
	
	public int customerRegister(Customer cus) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("insert into customer(cemail,cpwd,cwallet) values(?,?,?)");
		ps.setString(1, cus.getCemail());
		ps.setString(2, cus.getCpwd());
		ps.setDouble(3, cus.getCwallet());
		return ps.executeUpdate();
	}
	
	public boolean cuLogin(Customer cus) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select cemail,cpwd from customer where cemail=?");
		ps.setString(1, cus.getCemail());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getString("cemail").equalsIgnoreCase(cus.getCemail())&&rs.getString("cpwd").equalsIgnoreCase(cus.getCpwd()))
			{
				return true;
			}
		}
		rs.close();
		ps.close();
		con.close();
		return false;
	}
	public int cupdate(Customer cus) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("update customer set cpwd=?,cwallet=? where cemail=?");
		ps.setString(1, cus.getCpwd());
		ps.setDouble(2, cus.getCwallet());
		ps.setString(3, cus.getCemail());
		return ps.executeUpdate();
	}
	
	
	public int cdelete(Customer cus) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("delete from customer where cemail=?");
		ps.setString(1, cus.getCemail());
		return ps.executeUpdate();
	}
	
	public void cprofile(Customer cus) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from customer where cemail=?");
		ps.setString(1, cus.getCemail());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your id :"+rs.getInt("cid")+"\n"+"Your email :"+rs.getString("cemail")+"\n"+"Your password :"+rs.getString("cpwd")+"\n"+"Your wallet money :"+rs.getString("cwallet"));
		}
	}

}
