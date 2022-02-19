import javax.swing.*;
import java.sql.*;
public class ShowAdminId extends JFrame{
int v=100;
JLabel obj;
JLabel[] al=new JLabel[10];
	public ShowAdminId() {
		setLayout(null);
		setTitle("Admin details screen..");
		obj=new JLabel("Admin ID's");
		obj.setBounds(100,50,100,30);
		add(obj);
		
		for(int i=1;i<=10;i++) {
			al[i]=new JLabel("NULL");
//			for(int v=30;v<=1;v+=25)
				al[i].setBounds(10,v,300,20);
				v+=50;
		}
/*
		for(int i=1;i<=10;i++)
			add(al[i]);

		for(int i=1;i<=10;i++)
			al[i].setText("Hiii");
*/
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
/*	void filldata() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select ADMIN_ID from admin";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			rs.next();
			System.out.println(rs);
			
			conn.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}		
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowAdminId obj=new ShowAdminId();
	}
}