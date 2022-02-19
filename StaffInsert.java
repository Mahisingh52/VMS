import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StaffInsert extends JFrame  implements ActionListener,FocusListener,ItemListener {
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ln9,l10,l13; 
	JTextField t1,t2,t3,tp4,t4,t5,t6,t8,tn9,t10;
	JComboBox t9,td6,tm6,ty6,t7,c1;
	JTextArea ta1;
	public StaffInsert() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1350,750);
		setTitle("Staff Details");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		l13=new JLabel("Staff Details");
		l13.setBounds(900, 50, 300, 60); getContentPane().add(l13);
		Font lf13= new Font("Times New Roman",Font.CENTER_BASELINE,32);
		l13.setFont(lf13);
		
		l1=new JLabel("Staff ID:");
		l1.setBounds(70, 90, 150, 30);
		getContentPane().add(l1); Font lf1= new Font("Times New Roman",Font.BOLD,20);
		l1.setFont(lf1);
		t1=new JTextField();
		t1.setBounds(250,95,300,30);
		getContentPane().add(t1);
		t1.addFocusListener(this);
		
		l2=new JLabel("Staff Name:");
		l2.setBounds(70, 160, 150, 30);
		getContentPane().add(l2); Font lf2= new Font("Times New Roman",Font.BOLD,20);
		l2.setFont(lf2);
		t2=new JTextField();
		t2.setBounds(250,165,300,30);
		getContentPane().add(t2);
		t2.addFocusListener(this);
		
		l3=new JLabel("Staff E-mail:");
		l3.setBounds(70, 230, 150, 30);
		getContentPane().add(l3); Font lf3= new Font("Times New Roman",Font.BOLD,20);
		l3.setFont(lf3);
		t3=new JTextField();
		t3.setBounds(250,235,300,30);
		getContentPane().add(t3);
		t3.addFocusListener(this);
		
		l4=new JLabel("Staff Phone No.");
		l4.setBounds(70, 300, 150, 30);
		getContentPane().add(l4); Font lf4= new Font("Times New Roman",Font.BOLD,20);
		l4.setFont(lf4);
		tp4=new JTextField(" +91 ");
		tp4.setBounds(250,305,50,30);
		getContentPane().add(tp4); tp4.setEditable(false);
		t4=new JTextField();
		t4.setBounds(310,305,240,30);
		getContentPane().add(t4);
		t4.addFocusListener(this);
		
		l5=new JLabel("Staff Address:");
		l5.setBounds(70, 370, 150, 30);
		getContentPane().add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf5);
		t5=new JTextField();
		t5.setBounds(250,375,300,30);
		getContentPane().add(t5);
		
		l6=new JLabel("Date Of Joining:");
		l6.setBounds(70, 440, 200, 30);
		getContentPane().add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf6);
		String Days[]= {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String Months[]= {"","january","febrary","march","april","may","june","july","august","september","october","november","december"};
		String years[]= {"","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
		
		td6=new JComboBox(Days);
		td6.setBounds(250,440,70,40);
		add(td6);
		tm6=new JComboBox(Months);
		tm6.setBounds(330,440,100,40);
		add(tm6);
		ty6=new JComboBox(years);
		ty6.setBounds(440,440,70,40);
		add(ty6);

		l7=new JLabel("Staff-ID Type:");
		l7.setBounds(70, 510, 250, 30);
		getContentPane().add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf7);
		t7=new JComboBox();
		t7.setBounds(250,515,300,30);
		t7.addItem("");
		t7.addItem("AADHAR CARD");
		t7.addItem("PAN CARD");
		t7.addItem("OTHER");
		getContentPane().add(t7);
		
		l8=new JLabel("ID Details:");
		l8.setBounds(70, 580, 250, 30);
		getContentPane().add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf8);
		t8=new JTextField();
		t8.setBounds(250,585,300,30);
		getContentPane().add(t8);
		t8.addFocusListener(this);
		
		l9=new JLabel("Manager ID");
		l9.setBounds(750, 130, 250, 30);
		getContentPane().add(l9); Font lf9= new Font("Times New Roman",Font.BOLD,20);
		l9.setFont(lf9);
		t9=new JComboBox();
		t9.addItem("Empty");
		filldata();
		t9.setBounds(1000,130,300,30);
		getContentPane().add(t9);
		t9.addItemListener(this);
		
		ln9=new JLabel("Manager Name");
		ln9.setBounds(750, 200, 250, 30);
		getContentPane().add(ln9);
		ln9.setFont(lf9);
		tn9=new JTextField();
		tn9.setBounds(1000,200,300,30);
		getContentPane().add(tn9);		
		tn9.setEditable(false);
		
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
		Font lf11= new Font("Times New Roman",Font.BOLD,20);
		Font lf12= new Font("Times New Roman",Font.BOLD,20);
		 
		
		 b1=new JButton("Save");   
		 b1.setBounds(790,522,150,60); getContentPane().add(b1);
		 b1.addActionListener(this);
		 b2=new JButton("Close");   
		 b2.setBounds(1123,522,150,60); getContentPane().add(b2);
 
 
 
  
		 b2.addActionListener(this);
		}
		
	void filldata() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select Manager_Id from Manager";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			t9.addItem(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	void filldata2() {
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
     new StaffInsert();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
		String a=t1.getText();//id
		String b=t2.getText();//name
		String c=t3.getText();//email
		String d=tp4.getText()+t4.getText();//phone
		String e=t5.getText();//address
		String f=String.valueOf(td6.getSelectedItem())+"-"+String.valueOf(tm6.getSelectedItem())+"-"+String.valueOf(ty6.getSelectedItem());//doj
		String g=String.valueOf(t7.getSelectedItem());//id_type
		String h=t8.getText();//id_detail
		String i=String.valueOf(t9.getSelectedItem());//manager_id
		String j=String.valueOf(c1.getSelectedItem());//shift_time_id
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				
				String sql="insert into staff values(?,?,?,?,?,?,?,?,?,?,1)";
				PreparedStatement st=conn.prepareStatement(sql);
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
				//st.setInt(11,k);
				int x=st.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Saved");
				conn.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				td6.setSelectedItem("");
				tm6.setSelectedItem("");
				ty6.setSelectedItem("");
				t7.setSelectedItem("");
				t8.setText("");
				t9.setSelectedItem("Empty");
				t10.setText("");
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
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t1) {
			String a=t1.getText();//id
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select SFNAME from staff where STAFF_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					ResultSet rs=st.executeQuery();
					rs.next();
					t2.setText(rs.getString(1));
					t2.setEditable(false);
					conn.close();
					JOptionPane.showMessageDialog(this,"Manager Id Already exists.");
					t1.grabFocus();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(this,"Manager ID Confirms.");
					t2.setEditable(true);
					t2.setText("");
				}
			}
		if(e.getSource()==t2) {
			if(!((t2.getText()!=null)&&(!t2.getText().equals(""))&&(t2.getText().matches("^[a-zA-Z]*$")))) {
				JOptionPane.showMessageDialog(this,"Manager Name contains Alphabets only");
				t2.grabFocus();
			}
		}
		if(e.getSource()==t3) {
			Pattern p= Pattern.compile("^(.+)@(.+)$");
			Matcher m=p.matcher(t3.getText());
			if(!m.find()) {
				JOptionPane.showMessageDialog(this,"Email not in correct form");
				t3.grabFocus();
			}
		}
		if(e.getSource()==t4) {
			if(t4.getText().length()<10 || t4.getText().length()>10) {
				JOptionPane.showMessageDialog(this,"Phone number must be contain 10 digits");
				t4.grabFocus();
			}	
		}
		if(e.getSource()==t8) {
			if(t7.getSelectedItem()=="AADHAR CARD") {
				if(t8.getText().length()<12 || t8.getText().length()>12) {
					JOptionPane.showMessageDialog(this,"AADHAR CARD number must be contain 12 digits");
					t7.grabFocus();
				}
			}
			if(t7.getSelectedItem()=="PAN CARD") {
				if(t8.getText().length()<7 || t8.getText().length()>7) {
					JOptionPane.showMessageDialog(this,"PAN CARD Number must have length 7");
					t7.grabFocus();
				}
			}
			if(t7.getSelectedItem()=="OTHER") {
				if(t8.getText().length()>15) {
					JOptionPane.showMessageDialog(this,"Number must have length 15");
					t7.grabFocus();
				}
			}
			if(t7.getSelectedItem()=="") {
				t8.setText("");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t9) {
			String a=String.valueOf(t9.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select MNAME,SHIFTTIME_ID from manager where manager_id=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				rs.next();
				tn9.setText(rs.getString(1));
				c1.setSelectedItem(rs.getString(2));
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
			if(t9.getSelectedItem()=="Empty")
			{	tn9.setText("");
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
				 
				 ta1.setText("ShiftMaster_id:-"+rs.getString(1)+"\n"+"ShifttFrom:-"+rs.getString(2)+"\n"+"Shifttto:-"+rs.getString(3));
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