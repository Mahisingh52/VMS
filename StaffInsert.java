import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class StaffInsert extends JFrame  implements ActionListener,FocusListener,ItemListener {
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ln9,l10,l11,l12,l13; 
	JTextField t1,t2,t3,tp4,t4,t5,t6,t8,tn9,t10,t11,t12;
	JComboBox t9,t7;
	public StaffInsert() {
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
		t1=new JTextField();
		t1.setBounds(250,95,300,30);
		add(t1);
		
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
		tp4=new JTextField(" +91 ");
		tp4.setBounds(250,305,50,30);
		add(tp4); tp4.setEditable(false);
		t4=new JTextField();
		t4.setBounds(310,305,240,30);
		add(t4);
		t4.addFocusListener(this);
		
		l5=new JLabel("Staff Address:");
		l5.setBounds(70, 370, 150, 30);
		add(l5); Font lf5= new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(lf5);
		t5=new JTextField();
		t5.setBounds(250,375,300,30);
		add(t5);
		
		l6=new JLabel("Date Of Joining:");
		l6.setBounds(70, 440, 200, 30);
		add(l6); Font lf6= new Font("Times New Roman",Font.BOLD,20);
		l6.setFont(lf6);
		t6=new JTextField();
		t6.setBounds(250,445,300,30);
		add(t6);
		
		l7=new JLabel("Staff-ID Type:");
		l7.setBounds(70, 510, 250, 30);
		add(l7); Font lf7= new Font("Times New Roman",Font.BOLD,20);
		l7.setFont(lf7);
		t7=new JComboBox();
		t7.setBounds(250,515,300,30);
		t7.addItem("");
		t7.addItem("AADHAR CARD");
		t7.addItem("PAN CARD");
		t7.addItem("OTHER");
		add(t7);
		
		l8=new JLabel("ID Details:");
		l8.setBounds(70, 580, 250, 30);
		add(l8); Font lf8= new Font("Times New Roman",Font.BOLD,20);
		l8.setFont(lf8);
		t8=new JTextField();
		t8.setBounds(250,585,300,30);
		add(t8);
		t8.addFocusListener(this);
		
		l9=new JLabel("Manager ID");
		l9.setBounds(750, 130, 250, 30);
		add(l9); Font lf9= new Font("Times New Roman",Font.BOLD,20);
		l9.setFont(lf9);
		t9=new JComboBox();
		t9.addItem("Empty");
		filldata();
		t9.setBounds(1000,130,300,30);
		add(t9);
		t9.addItemListener(this);
		
		ln9=new JLabel("Manager Name");
		ln9.setBounds(750, 200, 250, 30);
		add(ln9);
		ln9.setFont(lf9);
		tn9=new JTextField();
		tn9.setBounds(1000,200,300,30);
		add(tn9);		
		tn9.setEditable(false);
		
		l10=new JLabel("Shift-Time ID");
		l10.setBounds(750, 270, 250, 30);
		add(l10); Font lf10= new Font("Times New Roman",Font.BOLD,20);
		l10.setFont(lf10);
		t10=new JTextField();
		t10.setBounds(1000,270,300,30);
		add(t10);
		
		l11=new JLabel("Status");
		l11.setBounds(750,340,300,30); add(l11);
		Font lf11= new Font("Times New Roman",Font.BOLD,20);
		l11.setFont(lf11);
		t11=new JTextField();
		t11.setBounds(1000,340,300,30);
		add(t11);
		
		l12=new JLabel("Active");
		l12.setBounds(750,410,300,30); add(l12);
		Font lf12= new Font("Times New Roman",Font.BOLD,20);
		l12.setFont(lf12);
		t12=new JTextField();
		t12.setBounds(1000,410,300,30);
		add(t12);
		 
		
		 b1=new JButton("Save");   
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
		String f=t6.getText();//doj
		String g=String.valueOf(t7.getSelectedItem());//id_type
		String h=t8.getText();//id_detail
		String i=String.valueOf(t9.getSelectedItem());//manager_id
		String j=t10.getText();//shift_time_id
		int k=Integer.parseInt(t11.getText());//status
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				
				String sql="insert into staff values(?,?,?,?,?,?,?,?,?,?,?)";
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
				st.setInt(11,k);
				int x=st.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Saved");
				conn.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setSelectedItem("");
				t8.setText("");
				t9.setSelectedItem("Empty");
				t10.setText("");
				t11.setText("");
				t12.setText("");
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
				String sql="select MNAME from manager where manager_id=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				rs.next();
				tn9.setText(rs.getString(1));
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(t9.getSelectedItem()=="Empty")
				tn9.setText("");
		}
	}
}