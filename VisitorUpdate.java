import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class VisitorUpdate extends JFrame implements ActionListener{ 
	JButton b1,b2,b3;JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13; 
	JTextField t1,t2,t3,t4,t5,t6,t8,t7,t9,t10,t11,t12;JComboBox c1;
	public VisitorUpdate() {
		setTitle("Update Screen");
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
		l7.setBounds(500,200,100,50);
		add(l7);
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
		t2=new JTextField();
		t2.setBounds(230,150,200,30);
		add(t2);
		t3=new JTextField("");
		t3.setBounds(230,200,200,30);
		add(t3);
		t4=new JTextField("");
		t4.setBounds(230,250,200,30);
		add(t4);
		t5=new JTextField("");
		t5.setBounds(230,300,200,30);
		add(t5);
		t6=new JTextField("");
		t6.setBounds(230,350,200,30);
		add(t6);
		t7=new JTextField("");
		t7.setBounds(630,210,200,30);
		add(t7);
		t8=new JTextField("");
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
		b1=new JButton("Find");
		b1.setBounds(200,550,100,50);
		add(b1);
		b2=new JButton("Update");
		b2.setBounds(350,550,100,50);
		add(b2);
		b3=new JButton("Close");
		b3.setBounds(500,550,100,50);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
	                   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new VisitorUpdate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
				int a=Integer.parseInt(t1.getText());
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","manager");
				String sql="select Vname,Vemail,Vphone,Vid_type,Vid_detail,Staff_id,Vpurpose,Vdatein,Vtimein,Vexpectedtimeout,Visout from visitor where Visitor_id=?";
				PreparedStatement st=con.prepareStatement(sql);
				st.setInt(1, a);
				ResultSet rs=st.executeQuery();
				rs.next();
				t2.setText(rs.getString(1));
				t3.setText(rs.getString(2));
				t4.setText(rs.getString(3));
				t5.setText(rs.getString(4));
				t6.setText(String.valueOf(rs.getString(5)));
				t7.setText(rs.getString(6));
				t8.setText(rs.getString(7));
				t9.setText(rs.getString(8));
				t10.setText(rs.getString(9));
				t11.setText(rs.getString(10));
				t12.setText(String.valueOf(rs.getString(11)));
				
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			
		}
		if(e.getSource()==b2) {
			
			try {
				int a=Integer.parseInt(t1.getText());
				String b=t2.getText();
				String c=t3.getText();
				String d=t4.getText();
				String z=t5.getText();
				String f=t6.getText();
				String g=t7.getText();
				String h=t8.getText();
				String i=t9.getText();
				String j=t10.getText();
				String k=t11.getText();
				int l=Integer.parseInt(t12.getText());
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="update visitor set Vname=?,Vemail=?,Vphone=?,Vid_type=?,Vid_detail=?,Staff_id=?,Vpurpose=?,Vdatein=?,Vtimein=?,Vexpectedtimeout=?,Visout=? where Visitor_id=?";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, b);
				st.setString(2, c);
				st.setString(3, d);
				st.setString(4, z);
				st.setString(5, f);
				st.setString(6, g);
				st.setString(7, h);
				st.setString(8, i);
				st.setString(9, j);
				st.setString(10, k);
				st.setInt(11, l);
				st.setInt(12, a);
				int p=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Update...");
				con.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
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
		
		if(e.getSource()==b3)
		 {
			this.hide();
		}
	}

}