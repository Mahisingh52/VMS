import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class VisitorInsert extends JFrame implements ActionListener,FocusListener,ItemListener{ 
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,ln7,l8,l9,l10,l11,l12,l13; 
	JTextField t1,t2,t3,tp4,t4,t6,tn7,t9,t10,t11,t12;
	JComboBox t5,t7;		JTextArea t8;
	Connection con;PreparedStatement st;ResultSet rs;
	public VisitorInsert() {
		setTitle("Insert Screen");
		setLayout(null);
		l13=new JLabel("Visitor Details");
		l13.setBounds(350,10,100,50);
		add(l13);
		l1=new JLabel("Visitor Id :");
		l1.setBounds(50,90,100,50);
		add(l1);
		l2=new JLabel("Visitor Name :");
		l2.setBounds(50,140,100,50);
		add(l2);
		l3=new JLabel("Visitor Email:");
		l3.setBounds(50,190,100,50);
		add(l3);
		l4=new JLabel("Visitor Phone no. :");
		l4.setBounds(50,240,120,50);
		add(l4);
		l5=new JLabel("Visitor Id Type :");
		l5.setBounds(50,290,100,50);
		add(l5);
		l6=new JLabel("Visitor Id Details :");
		l6.setBounds(50,340,100,50);
		add(l6);
		l7=new JLabel("Staff Id :");
		l7.setBounds(500,150,100,50);
		add(l7);
		ln7=new JLabel("Staff Name :");
		ln7.setBounds(500,200,100,50);
		add(ln7);
		l8=new JLabel("Purpose :");
		l8.setBounds(500,300,100,50);
		add(l8);
		l9=new JLabel("Date In :");
		l9.setBounds(500,250,100,50);
		add(l9);
		l10=new JLabel("Time In :");
		l10.setBounds(50,390,100,50);
		add(l10);
		l11=new JLabel("Expected Time Out :");
		l11.setBounds(50,440,120,50);
		add(l11);
		l12=new JLabel("Is Out :");
		l12.setBounds(50,490,100,50);
		add(l12);
		t1=new JTextField("");
		t1.setBounds(230,100,200,30);
		add(t1);
		t2=new JTextField("");
		t2.setBounds(230,150,200,30);
		add(t2);
		t3=new JTextField("");
		t3.setBounds(230,200,200,30);
		add(t3);
		tp4=new JTextField(" +91 ");
		tp4.setBounds(230,250,50,30);
		add(tp4);
		t4=new JTextField("");
		t4.setBounds(290,250,140,30);
		add(t4);
		t4.addFocusListener(this);
		t5=new JComboBox();
		t5.setBounds(230,300,200,30);
		t5.addItem("");
		t5.addItem("AADHAR CARD");
		t5.addItem("PAN CARD");
		t5.addItem("OTHER");
		add(t5);
		t6=new JTextField("");
		t6.setBounds(230,350,200,30);
		add(t6);
		t6.addFocusListener(this);
		t7=new JComboBox();
		t7.setBounds(630,160,200,30);
		t7.addItem("Empty");
		filldata();
		add(t7);
		t7.addItemListener(this);
		tn7=new JTextField("");
		tn7.setBounds(630,210,200,30);
		add(tn7);
		tn7.setEditable(false);
		t8=new JTextArea("");
		t8.setBounds(500,350,300,180);
		add(t8);
		t9=new JTextField("");
		t9.setBounds(630,260,200,30);
		add(t9);
		t10=new JTextField("");
		t10.setBounds(230,400,200,30);
		add(t10);
		t11=new JTextField("");
		t11.setBounds(230,450,200,30);
		add(t11);
		t12=new JTextField("");
		t12.setBounds(230,500,200,30);
		add(t12);
		b1=new JButton("Save");
		b1.setBounds(300,550,100,50);
		add(b1);
		b2=new JButton("Close");
		b2.setBounds(450,550,100,50);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
	}
	void filldata() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String sql="select STAFF_ID from staff";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			t7.addItem(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new VisitorInsert();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			int a=Integer.parseInt(t1.getText());
			String b=t2.getText();
			String c=t3.getText();
			String d=tp4.getText()+t4.getText();
			String z=String.valueOf(t5.getSelectedItem());
			String f=t6.getText();
			String g=String.valueOf(t7.getSelectedItem());
			String h=t8.getText();
			String i=t9.getText();
			String j=t10.getText();
			String k=t11.getText();
			int l=Integer.parseInt(t12.getText());
			// TODO Auto-generated method stub
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
				String sql="insert into visitor values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				st.setInt(1, a);
				st.setString(2, b);
				st.setString(3, c);
				st.setString(4, d);
				st.setString(5, z);
				st.setString(6, f);
				st.setString(7, g);
				st.setString(8, h);
				st.setString(9, i);
				st.setString(10, j);
				st.setString(11, k);
				st.setInt(12, l);
				int x=st.executeUpdate();
				JOptionPane.showMessageDialog(this,"Record Saved");
				con.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setSelectedItem("");
				t6.setText("");
				t7.setSelectedItem("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t12.setText("");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}		
		}
		if(e.getSource()==b2)
		 {
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
		if(e.getSource()==t6) {
			if(t5.getSelectedItem()=="AADHAR CARD") {
				if(t6.getText().length()<12 || t6.getText().length()>12) {
					JOptionPane.showMessageDialog(this,"AADHAR CARD number must be contain 12 digits");
					t5.grabFocus();
				}
			}
			if(t5.getSelectedItem()=="PAN CARD") {
				if(t6.getText().length()<7 || t6.getText().length()>7) {
					JOptionPane.showMessageDialog(this,"PAN CARD Number must have length 7");
					t5.grabFocus();
				}
			}
			if(t5.getSelectedItem()=="OTHER") {
				if(t6.getText().length()>15) {
					JOptionPane.showMessageDialog(this,"Number must have length 15");
					t5.grabFocus();
				}
			}
			if(t5.getSelectedItem()=="") {
				t6.setText("");
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==t7) {
			String a=String.valueOf(t7.getSelectedItem());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select SFNAME from staff where STAFF_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				rs.next();
				tn7.setText(rs.getString(1));
				conn.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			if(t7.getSelectedItem()=="Empty")
				tn7.setText("");
		}
	}
}