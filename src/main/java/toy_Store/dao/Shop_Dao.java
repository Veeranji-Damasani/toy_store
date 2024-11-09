package toy_Store.dao;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import toy_Store.dto.Shop;
public class Shop_Dao {
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	public void createTable() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists shop(sid int AUTO_INCREMENT primary key,sname varchar(45),saddress varchar(45),s_ven_email varchar(45))");
	}
	public int createShop(Shop shop) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("insert into shop(sname,saddress,s_ven_email) values(?,?,?)");
		ps.setString(1, shop.getSname());
		ps.setString(2, shop.getSaddress());
		ps.setString(3, shop.getS_ven_email());
		int res=ps.executeUpdate();
		return res;
	}
	
	public int updateShop(Shop shop) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("update shop set sname=?,saddress=? where s_ven_email=?");
		ps.setString(1, shop.getSname());
		ps.setString(2,shop.getSaddress());
		ps.setString(3, shop.getS_ven_email());
		return ps.executeUpdate();
	}
	public int deleteShop(Shop shop) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("delete from shop where s_ven_email=?");
		ps.setString(1, shop.getS_ven_email());
		return ps.executeUpdate();
	}
	public void fetchShop(Shop shop) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from shop where s_ven_email=?");
		ps.setString(1, shop.getS_ven_email());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your shop id :"+rs.getInt("sid")+"\n"+"Your shop name :"+rs.getString("sname")+"\n"+"Your shop address :"+rs.getString("saddress")+"\n"+"Your shop vendor email :"+rs.getString("s_ven_email"));
		}
	}
}
