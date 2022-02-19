import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminShow extends JFrame {
	JLabel l,l1,l2,l3,l4,l5,l6;
	JTextArea jt;
	
	public AdminShow() {
		setLayout(null);
		
		l=new JLabel("List of Admin details:");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("ADMIN ID");
		l1.setBounds(40,100,150,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("ADMIN NAME");
		l2.setBounds(200,100,150,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("EMAIL");
		l3.setBounds(380,100,150,50);
		add(l3); 
		l3.setFont(fll);
		
		l4=new JLabel("PHONE No");
		l4.setBounds(700,100,150,50);
		add(l4); 
		l4.setFont(fll);
		
		l5=new JLabel("ACTIVE");
		l5.setBounds(900,100,150,50);
		add(l5); 
		l5.setFont(fll);
		
		l6=new JLabel("STATUS");
		l6.setBounds(1200,100,150,50);
		add(l6); 
		l6.setFont(fll);
				
		jt=new JTextArea();
		jt.setBounds(50,150,1500,800);
		add(jt); 
		jt.setEditable(false);
		refresh();
		
		setSize(1700,900);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		}
		void refresh() {
		String str="";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select * from Admin";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) 
			{ 
					str=str+"      "+rs.getString(1)+"\t\t";
					str=str+rs.getString(2)+"\t\t";
		//			str=str+rs.getString(3)+"\t\t";
					str=str+rs.getString(4)+"\t\t\t";
					str=str+rs.getString(5)+"\t\t";
					str=str+rs.getString(6)+"\t\t\t";
					str=str+rs.getString(7)+"\n";		
					str=str+"\n";
							
			}
				jt.setText(str);
				con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}


	
	public static void main(String[] e) {
	// TODO Auto-generated method stub
		new AdminShow();	
	}
}