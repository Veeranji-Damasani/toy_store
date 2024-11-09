package toy_Store.dao;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toy_Store.dto.Cart;
import toy_Store.dto.Toys;
public class Toys_Dao {
	public Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_store?createDatabaseIfNotExist=true", "root", "root");
	}
	public void createTable() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists toys(tid int AUTO_INCREMENT primary key,tbrand varchar(45),tcost double,ttype varchar(45),tcolor varchar(45),tquantity int,t_ven_email varchar(45))");
	}
	public void createTables() throws Exception
	{
		Connection con=createConnection();
		Statement s=con.createStatement();
		s.execute("create table if not exists cart(caid int AUTO_INCREMENT primary key,ca_tid int,ca_tcost double,ca_cemail varchar(45))");
	}
	public int createToys(Toys toys) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("insert into toys(tbrand,tcost,ttype,tcolor,tquantity,t_ven_email) values(?,?,?,?,?,?)");
		ps.setString(1,toys.getTbrand());
		ps.setDouble(2, toys.getTcost());
		ps.setString(3, toys.getTtype());
		ps.setString(4, toys.getTcolor());
		ps.setInt(5, toys.getTquantity());
		ps.setString(6, toys.getT_ven_email());
		return ps.executeUpdate();
	}
	public int updateToys(Toys toys) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("update toys set tbrand=?,tcost=?,ttype=?,tcolor=?,tquantity=? where t_ven_email=?");
		ps.setString(1, toys.getTbrand());
		ps.setDouble(2, toys.getTcost());
		ps.setString(3, toys.getTtype());
		ps.setString(4, toys.getTcolor());
		ps.setInt(5, toys.getTquantity());
		ps.setString(6, toys.getT_ven_email());
		return ps.executeUpdate();
	}
	public int deleteToys(Toys toys) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("delete from toys where t_ven_email=?");
		ps.setString(1, toys.getT_ven_email());
		return ps.executeUpdate();
	}
	public void browseToys(Toys toys) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from toys where tbrand=?");
		ps.setString(1, toys.getTbrand());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Toy id :"+rs.getInt("tid")+"\n"+"Toy brand :"+rs.getString("tbrand")+"\n"+"Toy cost :"+rs.getDouble("tcost")+"\n"+"Toy type :"+rs.getString("ttype")+"\n"+"Toy color :"+rs.getString("tcolor")+"\n"+"Toy quantity :"+rs.getInt("tquantity"));
		}
	}
	public void browseToyss(Toys toys) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from toys where tcost<=?");
		ps.setDouble(1, toys.getTcost());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Toy id :"+rs.getInt("tid")+"\n"+"Toy brand :"+rs.getString("tbrand")+"\n"+"Toy cost :"+rs.getDouble("tcost")+"\n"+"Toy type :"+rs.getString("ttype")+"\n"+"Toy color :"+rs.getString("tcolor")+"\n"+"Toy quantity :"+rs.getInt("tquantity"));
		}
	}
	public int addToCart(Cart cart) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO cart (ca_tid, ca_tcost, ca_cemail)" + "SELECT ?, tcost, ? FROM toys WHERE tid = ?");
		ps.setInt(1, cart.getCa_tid());
		ps.setString(2, cart.getCa_cemail());
		ps.setInt(3, cart.getCa_tid());
		return ps.executeUpdate();
	}
	public int removeCart(Cart cart) throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("delete from cart where ca_tid=?");
		ps.setInt(1, cart.getCa_tid());
		return ps.executeUpdate();
	}
	
	public void fetchAll() throws Exception
	{
		Connection con=createConnection();
		PreparedStatement ps=con.prepareStatement("select * from toys");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("tid")+" "+rs.getString("tbrand")+" "+rs.getDouble("tcost")+" "+rs.getString("ttype")+" "+rs.getString("tcolor")+" "+rs.getInt("tquantity"));
		}
		rs.close();
		ps.close();
		con.close();
	}
	
	
}
