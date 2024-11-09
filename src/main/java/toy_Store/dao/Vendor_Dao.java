package toy_Store.dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import toy_Store.dto.Vendor;
public class Vendor_Dao {
	
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	
	public void createTable() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists vendor(vid int AUTO_INCREMENT primary key,vemail varchar(45) unique,vpwd varchar(45))");
	}
	
	public int vendorRegister(Vendor ven) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("insert into vendor(vemail,vpwd) values(?,?)");
		ps.setString(1, ven.getVemail());
		ps.setString(2, ven.getVpwd());
		return ps.executeUpdate();
	}
	
	public boolean veLogin(Vendor ven) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select vemail,vpwd from vendor where vemail=?");
		ps.setString(1, ven.getVemail());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getString("vemail").equalsIgnoreCase(ven.getVemail())&&rs.getString("vpwd").equalsIgnoreCase(ven.getVpwd()))
			{
				return true;
			}
		}
		rs.close();
		ps.close();
		con.close();
		return false;
	}
	public int vupdate(Vendor ven) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("update vendor set vpwd=? where vemail=?");
		ps.setString(1, ven.getVpwd());
		ps.setString(2, ven.getVemail());
		return ps.executeUpdate();
	}
	
	public int vdelete(Vendor ven) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("delete from vendor where vemail=?");
		ps.setString(1, ven.getVemail());
		return ps.executeUpdate();
	}
	
	public void vprofile(Vendor ven) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from vendor where vemail=?");
		ps.setString(1, ven.getVemail());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your id :"+rs.getInt("vid")+"\n"+"Your email :"+rs.getString("vemail")+"\n"+"Your password :"+rs.getString("vpwd")+"\n");
		}
	}

}
