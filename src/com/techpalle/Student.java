package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student 
{
	
	private final String url = "jdbc:mysql://localhost:3306/Palle";
	private final String userName = "root";
	private final String password = "Shravan@844";
	
	private Connection con = null;
	private Statement s = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void creating() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			s = con.createStatement();
			String quer = "create table student(sno int primary key auto_increment, sname varchar(80)not null, sub varchar (40), email varchar(80) unique)";
			s.executeUpdate(quer);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null)
					s.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}		
	}
	
	public void inserting(String sname, String sub, String email) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, userName, password);
			
			ps = con.prepareStatement("insert into student(sname, sub, email)values(?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null)
					s.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}	
	}
	
	public void update(int sno, String email, String sub) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			ps = con.prepareStatement("update student set email=?,sub=? where sno = ?");
			ps.setString(1, email);
			ps.setString(2, sub);
			ps.setInt(3, sno);
			 
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null)
					s.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}	
	}
	
	public void delete(int sno) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
		
			ps = con.prepareStatement("delete from student where sno=?");
			 
			ps.setInt(1, sno);
			 
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(s!=null)
					s.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}
	}
	
	public ArrayList<StudentData> reading() 
	{
		ArrayList<StudentData>allDept= new ArrayList<>();
			
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			 
			
			 String qry = "select * from student";
			 
			 s = con.createStatement();
			  
			 rs = s.executeQuery(qry);
			  
			 while(rs.next()) 
			 {
				  int sno = rs.getInt("sno");
				  String sname = rs.getString("sname");
				  String sub = rs.getString("sub");
				  String email = rs.getString("email");
				  
				 StudentData d = new StudentData(sno, sname, sub,email);	
				 
				 allDept.add(d);
			 }
		} 
		catch (ClassNotFoundException e) 
		{ 
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		}
		finally 
		{
			 try 
			 {
				 if(rs!=null)
					 rs.close();
				 if(s!=null)
					 s.close();
				 if(con!=null)
					 con.close();
			} 
			 catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		}		
		return allDept;	
	}
	 
	
	public void read()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			s = con.createStatement();
			
			 String qry = "select * from student";
			
			 rs = s.executeQuery(qry);
			 
			 while(rs.next()) 
			 {
				  int sno = rs.getInt("sno");
				  String sname = rs.getString("sname");
				  String sub = rs.getString("sub");
				  String email = rs.getString("email");
				  
				  StudentData d = new StudentData(sno, sname, sub,email);	
				 
					 System.out.println(d); 
			 }
		
		} 
		catch (ClassNotFoundException e) 
		{ 
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		}
		finally 
		{
			 try {
				 if(rs!=null)
					 rs.close();
				 if(s!=null)
					 s.close();
				 if(con!=null)
					 con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}		
	}
}
