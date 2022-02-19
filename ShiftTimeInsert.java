import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ShiftTimeInsert extends JFrame implements ActionListener,ItemListener{
	JLabel l1,l2,l3,l4;
	JButton bt1,bt2;
	JTextField t1,t2,t3;
	JComboBox c1;
	JTextArea ta1;
	public ShiftTimeInsert() {
		setLayout(null);
		l1=new JLabel("Shift Time_id..");
		l1.setBounds(200,100,100,40);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(500,100,200,30);
		add(t1);
		
		l2=new JLabel("Shift master _id..");
		l2.setBounds(200,200,100,40);
		add(l2);
		
		c1 = new JComboBox();
		c1.setBounds(500,200,200,30);
		add(c1);
		c1.addItem("Empty");
		filldata();
		c1.addItemListener(this);
		
		
		l3=new JLabel("Shift from.. ");
		l3.setBounds(200,300,100,40);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(500,300,200,30);
		add(t2);
		
		l4=new JLabel("Shift to.. ");
		l4.setBounds(200,400,100,40);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(500,400,200,30);
		add(t3);		
		
		bt1=new JButton("Save");
		bt1.setBounds(400,550,100,40);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("Cancel");
		bt2.setBounds(600,550,100,40);
		add(bt2);
		bt2.addActionListener(this);
		ta1=new JTextArea();
		ta1.setBounds(750,200,600,100);
		add(ta1);
		
		setVisible(true);
		setSize(1350,750);
		setTitle("Shift time tabel");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
	}
	void filldata() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select SHIFT_ID from Shift_master";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				c1.addItem(rs.getString(1));
			}
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}

	public static void main(String[] e) {
		// TODO Auto-generated method stub
		new ShiftTimeInsert();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1) {
			String a=t1.getText();
			String b=String.valueOf(c1.getSelectedItem());
			String c=t2.getText();
			String d=t3.getText();
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="insert into Shift_time values(?,?,?,?,1)";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					st.setString(2,b);
					st.setString(3,c);
					st.setString(4,d);
									
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Saved");
					conn.close();
					t1.setText("");
					c1.setSelectedItem("Empty");
					t2.setText("");
					t3.setText("");
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}
		if(e.getSource()==bt2) {
			this.hide();		
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
				String sql="select MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY from SHIFT_MASTER where SHIFT_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
				ta1.setText("Shift from Monday to Sunday"+"\n"+"Mon->"+rs.getString(1)+"\t"+"Tues->"+rs.getString(2)+"\t"+"Wed->"+rs.getString(3)+"\t"+"Thurs->"+rs.getString(4)+"\t"+"Fri->"+rs.getString(5)+"\t"+"Sat->"+rs.getString(6)+"\t"+"Sun->"+rs.getString(7)+"\t");
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