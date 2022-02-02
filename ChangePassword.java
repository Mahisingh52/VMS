import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;
public class ChangePassword extends JFrame implements ActionListener, FocusListener{
	JLabel jlb, jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
	JTextField jlt,jlt1;
	JPasswordField jpf,jpf1,jpf2;
	JButton bt,bt1,bt2;
	public ChangePassword() {
		setLayout(null);
		jlb3=new JLabel("Change Password");
		jlb3.setBounds(250,50,550,40);
		add(jlb3);
		jlb=new JLabel("Admin Id");
		jlb.setBounds(150,200,300,40);
		add(jlb);
		jlt=new JTextField();
		jlt.setBounds(350,200,250,40);
		add(jlt);
		jlb2=new JLabel("Admin Name");
		jlb2.setBounds(750,200,150,40);
		add(jlb2);
		jlt1=new JTextField();
		jlt1.setBounds(1000,200,250,40);
		add(jlt1);
		jlt1.setEditable(false);
		jlb4=new JLabel("Old Password");
		jlb4.setBounds(150,330,150,40);
		add(jlb4);
		jpf=new JPasswordField();
		jpf.setBounds(350,330,250,40);
		add(jpf);
		jlb5=new JLabel("New Password :");
		jlb5.setBounds(150,430,150,40);
		add(jlb5);
		jpf1=new JPasswordField();
		jpf1.setBounds(350,430,250,40);
		add(jpf1);
		jlb5=new JLabel("Confirm New Password :");
		jlb5.setBounds(750,430,350,40);
		add(jlb5);
		jpf2=new JPasswordField();
		jpf2.setBounds(1000,430,250,40);
		add(jpf2);
		jpf2.addFocusListener(this);
		bt=new JButton("CONFRIM");
		bt.setBounds(500,250,100,30);
		add(bt);
		bt.addActionListener(this);
		bt1=new JButton("SAVE");
		bt1.setBounds(300,550,100,50);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("Cancel");
		bt2.setBounds(600,550,100,50);
		add(bt2);
		bt2.addActionListener(this);
		
		setSize(1350,750);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		setTitle("Admin Register");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangePassword();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt) {
			String a=jlt.getText();//id
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select ADMIN_NAME from admin where admin_id=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					ResultSet rs=st.executeQuery();
					rs.next();
					jlt1.setText(rs.getString(1));
					conn.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(this,"Wrong Admin ID");
					System.out.println(ex);
				}
			}
		if(e.getSource()==bt1) {
			String a=jlt.getText();//id
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select PASSWORD from admin where admin_id=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,a);
				ResultSet rs=st.executeQuery();
				rs.next();
				if(jpf.getText().equals(rs.getString(1))&&jpf1.getText().equals(jpf2.getText())){
					String b=jpf1.getText();
					String sql1="update admin set PASSWORD=? where admin_id=?";
					st=conn.prepareStatement(sql1);
					st.setString(1,b);
					st.setString(2,a);
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Password has been changed");
				}
				conn.close();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this,"Wrong Admin ID");
				System.out.println(ex);
			}
		}
		if(e.getSource()==bt2) {
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
		if(e.getSource()==jpf2) {
			if(!jpf1.getText().equals(jpf2.getText())) {
				jpf2.setBackground(Color.RED);
			}
			else
				jpf2.setBackground(Color.WHITE);
		}
	}

}
