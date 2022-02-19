import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class StaffUpdate extends JFrame  implements ActionListener,ItemListener {
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13; 
	JTextField t2,t3,t4,t5,t6,t8,t9,t7;
	JComboBox t1,c1;
	JTextArea ta1;
	public StaffUpdate() {
		setLayout(null);
		setVisible(true);
		setSize(1350,750);
		setTitle("Staff Details");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		l13=new JLabel("Staff Details");
		l13.setBounds(900, 50, 300, 60); add(l13);
		Font lf13= new Font("Times New Roman",Font.CENTER_BASELINE,32);
		l13.setFont(lf13);
		
		l1=new JLabel("Staff ID:");
		l1.setBounds(70, 90, 150, 30);
		add(l1); Font lf1= new Font("Times New Roman",Font.BOLD,20);
		l1.setFont(lf1);
		t1=new JComboBox();
		t1.addItem("Empty");
		filldata();
		t1.setBounds(250,95,300,30);
		add(t1);
		t1.addItemListener(this);
		
		l2=new JLabel("Staff Name:");
		l2.setBounds(70, 160, 150, 30);
		add(l2); Font lf2= new Font("Times New Roman",Font.BOLD,20);
		l2.setFont(lf2);
		t2=new JTextField();
		t2.setBounds(250,165,300,30);
		add(t2);
		
		l3=new JLabel("Staff E-mail:");
		l3.setBounds(70, 230, 150, 30);
		add(l3); Font lf3= new Font("Times New Roman",Font.BOLD,20);
		l3.setFont(lf3);
		t3=new JTextField();
		t3.setBounds(250,235,300,30);
		add(t3);
		
		l4=new JLabel("Staff Phone No.");
		l4.setBounds(70, 300, 150, 30);
		add(l4); Font lf4= new Font("Times New Roman",Font.BOLD,20);
		l4.setFont(lf4);
		t4=new JTextField();
		t4.setBounds(250,305,300,30);
		add(t4);
		
		l5=new JLabel("Staff Address:");
		l5.setBounds(70, 370, 150, 30);
		add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf2);
		t5=new JTextField();
		t5.setBounds(250,375,300,30);
		add(t5);
		
		l6=new JLabel("Date Of Joining:");
		l6.setBounds(70, 440, 200, 30);
		add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf2);
		t6=new JTextField();
		t6.setBounds(250,445,300,30);
		add(t6);
		
		l7=new JLabel("Staff-ID Type:");
		l7.setBounds(70, 510, 250, 30);
		add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf2);
		t7=new JTextField();
		t7.setBounds(250,515,300,30);
		add(t7);
		
		l8=new JLabel("ID Details:");
		l8.setBounds(70, 580, 250, 30);
		add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf2);
		t8=new JTextField();
		t8.setBounds(250,585,300,30);
		add(t8);
		
		l9=new JLabel("Manager ID");
		l9.setBounds(750, 200, 250, 30);
		add(l9); Font lf9= new Font("Times New Roman",Font.BOLD,20);
		l9.setFont(lf2);
		t9=new JTextField();
		t9.setBounds(1000,200,300,30);
		add(t9);
		

		l10=new JLabel("Shift-Time ID");
		l10.setBounds(750, 270, 250, 30);
		getContentPane().add(l10); Font lf10= new Font("Times New Roman",Font.BOLD,20);
		l10.setFont(lf10);
		c1=new JComboBox();
		c1.addItem("Empty");
		filldata2();
		c1.setBounds(1000,270,300,30);
		getContentPane().add(c1);
		c1.addItemListener(this);
		
		ta1 = new JTextArea();
		ta1.setBounds(755, 329, 545, 141);
		getContentPane().add(ta1);
	    ta1.setEditable(false);
		
		 
		
		 b1=new JButton("Update");   
		 b1.setBounds(800,550,150,60); add(b1);
		 b1.addActionListener(this);
		 b2=new JButton("Close");   
		 b2.setBounds(1100,550,150,60); add(b2);
		 b2.addActionListener(this);
		}

	void filldata() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select staff_Id from staff";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			t1.addItem(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	void filldata2()
	{
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select SHIFTTIME_ID from shift_time";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			c1.addItem(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new StaffUpdate();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String a=String.valueOf(t1.getSelectedItem());//id
			String b=t2.getText();//name
			String c=t3.getText();//email
			String d=t4.getText();//phone
			String e=t5.getText();//address
			String f=t6.getText();//doj
			String g=t7.getText();//id_type
			String h=t8.getText();//id_detail
			String i=t9.getText();//manager_id
			String j=String.valueOf(c1.getSelectedItem());//shift_time_id
		
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="update staff set SFNAME=?,MANAGER_ID=?,SHIFTTIME_ID=?,SFEMAIL=?,SFPHONE=?,SFADDRESS=?,SFDOJ=?,SFID_TYPE=?,SFID_DETAIL=?,STATUS=? where STAFF_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(10,a);
					st.setString(1,b);
					st.setString(4,c);
					st.setString(5,d);
					st.setString(6,e);
					st.setString(7,f);
					st.setString(8,g);
					st.setString(9,h);
					st.setString(2,i);
					st.setString(3,j);
					
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Updated");
					conn.close();
					t1.setSelectedItem("Empty");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					t9.setText("");
					ta1.setText("");
					
				}
				catch(Exception ex) {
					System.out.println(ex);
				}

		}	 
		if(ae.getSource()==b2) {
			this.hide();	
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t1) {
			String a=String.valueOf(t1.getSelectedItem());//id
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from staff where STAFF_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				int x=st.executeUpdate();
				ResultSet rs=st.executeQuery();
				rs.next();
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(5));
				t4.setText(rs.getString(6));
				t5.setText(rs.getString(7));
				t6.setText(rs.getString(8));
				t7.setText(rs.getString(9));
				t8.setText(rs.getString(10));
				t9.setText(rs.getString(3));
				conn.close();
			}catch(Exception ex) {
				System.out.println(ex);
				}
		}
			if(t1.getSelectedItem()=="Empty") {
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
			}
		if(e.getSource()==c1) {
			String a=String.valueOf(c1.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select SHIFTMaster_ID ,SHIFTTFROM ,SHIFTTTO  from shift_time where SHIFTTIME_ID =?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				
				ResultSet rs=st.executeQuery();
				 while (rs.next()) {
					 
					 ta1.setText("Shift_id:-"+rs.getString(1)+"\n"+"ShifttFrom:-"+rs.getString(2)+"\n"+"Shifttto:-"+rs.getString(3));
				 }
				
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
				
			}
	}
			if(c1.getSelectedItem()=="Empty")
			{	ta1.setText("");
	}
}
}