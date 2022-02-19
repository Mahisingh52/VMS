package com.DataUtil;
import java.sql.*;

import javax.swing.JOptionPane;
public class DataBase {
	Connection conn;
	PreparedStatement st;
	Statement s;
	ResultSet rs;
	public void makeConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

	public String AdminInsert(String a,String b,String c,String d,String e) {
		try {
			String sql="insert into admin values(?,?,?,?,?,1,1)";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,a);
			st.setString(2,b);
			st.setString(3,c);
			st.setString(4,d);
			st.setString(5,e);
			int x=st.executeUpdate();
			return "Record Saved";
		}catch(Exception ex) {
			System.out.println(ex);
			return "Error" ;
			}
	}
	
	public String SMInsert(String a,int b,int c,int d,int e,int f,int g,int h) {
		try{
			String sql="insert into Shift_master values(?,?,?,?,?,?,?,?,1)";
			st=conn.prepareStatement(sql);
			st.setString(1,a);
			st.setInt(2,c);
			st.setInt(3,d);
			st.setInt(4,e);
			st.setInt(5,f);
			st.setInt(6,g);
			st.setInt(7,h);
			st.setInt(8,b);						
			int x=st.executeUpdate();
			return "Record Saved";
		}catch(Exception ex) {
			System.out.println(ex);
			return "Error";
		}	
	}
	
	public String STInsert(String a,String b,String c,String d) {
		try {
			String sql="insert into Shift_time values(?,?,?,?,1)";
			st=conn.prepareStatement(sql);
			st.setString(1,a);
			st.setString(2,b);
			st.setString(3,c);
			st.setString(4,d);
							
			int x=st.executeUpdate();
			return "Record Saved";
		}catch(Exception ex) {
			System.out.println(ex);
			return "Error";
		}
	}
	public String MInsert(String a,String b,String c,String d,String e,String f,String g,String h) {
		try {
			String sql="insert into manager values(?,?,?,?,?,?,?,?,1)";
			st=conn.prepareStatement(sql);
			st.setString(1,a);
			st.setString(2,b);
			st.setString(3,c);
			st.setString(4,e);
			st.setString(5,f);
			st.setString(6,g);
			st.setString(7,d);
			st.setString(8,h);// st.setInt(9,i);					
			int x=st.executeUpdate();
			return "Record Saved";
			}catch(Exception ex) {
				System.out.println(ex);
				return "Error";
		}
	}
	
	public String SFInsert(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j) {
		try {
			String sql="insert into staff values(?,?,?,?,?,?,?,?,?,?,1)";
			st=conn.prepareStatement(sql);
			st.setString(1,a);
			st.setString(2,b);
			st.setString(5,c);
			st.setString(6,d);
			st.setString(7,e);
			st.setString(8,f);
			st.setString(9,g);
			st.setString(10,h);
			st.setString(3,i);
			st.setString(4,j);
			int x=st.executeUpdate();
			return "Record Saved";
			}catch(Exception ex) {
				System.out.println(ex);
				return "Error";
			}
		}
			
	public String VInsert(int a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,int l) {
		try {
			String sql="insert into visitor values(?,?,?,?,?,?,?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			st.setInt(1, a);
			st.setString(2, b);
			st.setString(3, c);
			st.setString(4, d);
			st.setString(5, e);
			st.setString(6, f);
			st.setString(7, g);
			st.setString(8, h);
			st.setString(9, i);
			st.setString(10, j);
			st.setString(11, k);
			st.setInt(12, l);
			int x=st.executeUpdate();
			return "Record Saved";
		}catch(Exception ex) {
			System.out.println(ex);
			return "Error";
		}
	}
	public String deleteData(String table,String id,String a) {
		try {
		String sql="delete from "+table+" where "+id+"=?";
		st=conn.prepareStatement(sql);
		st.setString(1,a);
		int x=st.executeUpdate();
//		conn.commit();
		conn.close();
		return "Record Deleted";
		}catch(Exception ex) {
			System.out.println(ex);
			return "Error";
		}	
	}
}	
	