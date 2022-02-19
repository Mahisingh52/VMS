import javax.swing.*;

import com.DataUtil.DataBase;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ShiftTimeDelete extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
	JButton bt1,bt2,bt3;
	JTextField t1,t2,t3,t4;
	public ShiftTimeDelete() {
		setLayout(null);
		l1=new JLabel("Shift Time_id..");
		l1.setBounds(250,100,100,40);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(550,100,200,30);
		add(t1);
		
		l2=new JLabel("Shift master _id..");
		l2.setBounds(250,200,100,40);
		add(l2);
		
		t4 = new JTextField();
		t4.setBounds(550,200,200,30);
		add(t4);
		t4.setEditable(false);
		
		l3=new JLabel("Shift from.. ");
		l3.setBounds(250,300,100,40);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(550,300,200,30);
		add(t2);
		t2.setEditable(false);
		
		l4=new JLabel("Shift to.. ");
		l4.setBounds(250,400,100,40);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(550,400,200,30);
		add(t3);		
		t3.setEditable(false);

		bt3=new JButton("Find");
		bt3.setBounds(850,100,100,40);
		add(bt3);
		bt3.addActionListener(this);
		bt1=new JButton("Delete");
		bt1.setBounds(400,550,100,40);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("Cancel");
		bt2.setBounds(600,550,100,40);
		add(bt2);
		bt2.addActionListener(this);
		
		setVisible(true);
		setSize(1350,750);
		setTitle("Shift time tabel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] e) {
		// TODO Auto-generated method stub
		new ShiftTimeDelete();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1) {
			String a=t1.getText();
			DataBase obj=new DataBase();
			obj.makeConnection();
			String str=obj.deleteData("shift_time","shifttime_id" , a);
			JOptionPane.showMessageDialog(this,str);
			t1.setText("");
			t4.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(e.getSource()==bt2) {
			this.hide();		
		}
		if(e.getSource()==bt3) {
			String a=t1.getText();
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select * from Shift_time where SHIFTTIME_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					
					ResultSet rs=st.executeQuery();
					rs.next();
					t4.setText(rs.getString(2));
					t2.setText(rs.getString(3));
					t3.setText(rs.getString(4));
					conn.close();
					
			}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}

	}
}