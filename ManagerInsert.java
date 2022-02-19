import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
public class ManagerInsert  extends JFrame  implements ActionListener,FocusListener,ItemListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11;
	JTextField t1,t2,t3,t4,lp,t5,t7,t8;
	JButton b1,b2;
	JComboBox t6,c1,td5,tm5,ty5;
	JTextArea ta1;
	public ManagerInsert() {
		setLayout(null);
		setVisible(true);
		setSize(1350,750);
		setTitle("Manager Details");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		l11=new JLabel("Manager Details");
		l11.setBounds(700, 30, 250, 40); add(l11);
		l1=new JLabel("Manager ID:");
		l1.setBounds(70, 90, 150, 40);
		Font lf11= new Font("Times New Roman",Font.CENTER_BASELINE,26);
		l11.setFont(lf11);
		add(l1); Font lf1= new Font("Times New Roman",Font.BOLD,20);
		l1.setFont(lf1);
		t1=new JTextField();
		t1.setBounds(250,100,300,30);
		add(t1);
		t1.addFocusListener(this);
		
		l2=new JLabel("Manager Name:");
		l2.setBounds(70, 160, 150, 40);
		add(l2); Font lf2= new Font("Times New Roman",Font.BOLD,20);
		l2.setFont(lf2);
		t2=new JTextField();
		t2.setBounds(250,170,300,30);
		add(t2);
		t2.addFocusListener(this);
		
		l3=new JLabel("Manager E-mail:");
		l3.setBounds(70, 230, 150, 40);
		add(l3); Font lf3= new Font("Times New Roman",Font.BOLD,20);
		l3.setFont(lf3);
		t3=new JTextField();
		t3.setBounds(250,240,300,30);
		add(t3);
		t3.addFocusListener(this);
		
		l4=new JLabel("Manager Phone No.:"); 
		l4.setBounds(70, 300, 200, 30);
		add(l4); Font lf4= new Font("Times New Roman",Font.BOLD,20);
		l4.setFont(lf4);
		lp=new JTextField(" +91 "); 
		lp.setBounds(250, 310,50, 30);
		add(lp);	lp.setEditable(false);
		t4=new JTextField();
		t4.setBounds(310,310,240,30);
		add(t4);
		t4.addFocusListener(this);
		
		l5=new JLabel("Date Of Joining:");
		l5.setBounds(70, 370, 150, 30);
		add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf2);
		
		String Days[]= {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String Months[]= {"","january","febrary","march","april","may","june","july","august","september","october","november","december"};
		String years[]= {"","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
		
		td5=new JComboBox(Days);
		td5.setBounds(250,380,70,40);
		add(td5);
		tm5=new JComboBox(Months);
		tm5.setBounds(330,380,100,40);
		add(tm5);
		ty5=new JComboBox(years);
		ty5.setBounds(440,380,70,40);
		add(ty5);
/*		t5=new JTextField();
		t5.setBounds(250,380,300,30);
		add(t5);
*/		
		l6=new JLabel("Manager ID Type:");
		l6.setBounds(750, 120, 250, 30);
		add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf2);
		t6=new JComboBox();
		t6.setBounds(1000,125,300,30);
		t6.addItem("");
		t6.addItem("AADHAR CARD");
		t6.addItem("PAN CARD");
		t6.addItem("OTHER");
		add(t6);
		
		l7=new JLabel("Manager ID Details:");
		l7.setBounds(750, 190, 250, 30);
		add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf2);
		t7=new JTextField();
		t7.setBounds(1000,195,300,30);
		add(t7);
		t7.addFocusListener(this);
		
		l8=new JLabel("Manager Shift time-ID: ");
		l8.setBounds(750, 270, 250, 30);
		add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf2);
		c1=new JComboBox();
		c1.addItem("Empty");
		filldata();
		c1.setBounds(1000,275,300,30);
		add(c1);
		c1.addItemListener(this);
		
		ta1=new JTextArea();
		ta1.setBounds(750,330,500,200);
		add(ta1);
		
		b1=new JButton("Save");   
		b1.setBounds(800,600,150,60); add(b1);
		b1.addActionListener(this);
		b2=new JButton("Close");   
		b2.setBounds(1000,600,150,60); add(b2);
		b2.addActionListener(this);
	}
		void filldata()
		{
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select shifttime_id from shift_time";
				PreparedStatement st=con.prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				while(rs.next())
				{
					c1.addItem(String.valueOf(rs.getString(1)));
				}
			}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
	}
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		ManagerInsert obj=new ManagerInsert();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String a=t1.getText();//id
			String b=t2.getText();//name
			String c=t3.getText();//email
			String d=lp.getText()+t4.getText();//doj  phone
			String e=String.valueOf(td5.getSelectedItem())+"-"+String.valueOf(tm5.getSelectedItem())+"-"+String.valueOf(ty5.getSelectedItem());//id_type  doj
			String f=String.valueOf(t6.getSelectedItem());//id
			String g=t7.getText();//phone_no
			String h=t8.getText();//shift_id	
	//		int i=Integer.parseInt(t9.getText());//status
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="insert into manager values(?,?,?,?,?,?,?,?,1)";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					st.setString(2,b);
					st.setString(3,c);
					st.setString(4,e);
					st.setString(5,f);
					st.setString(6,g);
					st.setString(7,d);
					st.setString(8,h);// st.setInt(9,i);					
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Saved");
					conn.close();
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					td5.setSelectedItem(""); tm5.setSelectedItem(""); ty5.setSelectedItem("");
					
					//t5.setText("");
					t6.setSelectedItem("");
					t7.setText("");
					t8.setText("");
//					t9.setText("");
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}		
		
      if(ae.getSource()==b2) {
        	//System.exit(1);	
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
					String sql="select MNAME from manager where Manager_Id=?";
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
		if(e.getSource()==t7) {
			if(t6.getSelectedItem()=="AADHAR CARD") {
				if(t7.getText().length()<12 || t7.getText().length()>12) {
					JOptionPane.showMessageDialog(this,"AADHAR CARD number must be contain 12 digits");
					t6.grabFocus();
				}
			}
			if(t6.getSelectedItem()=="PAN CARD") {
				if(t7.getText().length()<7 || t7.getText().length()>7) {
					JOptionPane.showMessageDialog(this,"PAN CARD Number must have length 7");
					t6.grabFocus();
				}
			}
			if(t6.getSelectedItem()=="OTHER") {
				if(t7.getText().length()>15) {
					JOptionPane.showMessageDialog(this,"Number must have length 15");
					t6.grabFocus();
				}
			}
			if(t6.getSelectedItem()=="") {
				t7.setText("");
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==c1) {
			String a=String.valueOf(c1.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select SHIFTMaster_ID,SHIFTTFROM,SHIFTTTO from shift_time where SHIFTTIME_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
				ta1.setText("Shift time"+"\n"+"SHIFTMASTER_ID:"+rs.getString(1)+" \t"+"SHIFT_FROM:"+rs.getString(2)+"\t"+"SHIFT_TO:"+rs.getString(3)+"\t");
				}
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(c1.getSelectedItem()=="Empty")
				ta1.setText("");
		}
	}	
}