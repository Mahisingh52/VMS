import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class ChangePassword extends JFrame implements ActionListener,FocusListener{
	JLabel jlb, jlb1,jlb2,jlb3,jlb4,jlbc4,jlb5;
	JTextField jlt,jlt1;
	JPasswordField jpf,jpf1,jpf2;
	JButton bt,bt1,bt2;
	public ChangePassword() {
		setLayout(null);
		jlb3=new JLabel("Admin Change Password");
		jlb3.setBounds(250,50,550,40);
		add(jlb3);Font lf11= new Font("Times New Roman",Font.CENTER_BASELINE,32);
		jlb3.setFont(lf11);
		jlb=new JLabel("Admin Id :");
		jlb.setBounds(150,200,300,40);
		add(jlb);Font lf1= new Font("Times New Roman",Font.BOLD,20);
		jlb.setFont(lf1);
		jlt=new JTextField();
		jlt.setBounds(350,200,250,40);
		add(jlt);

		jlb5=new JLabel("Admin Name :");
		jlb5.setBounds(750,200,150,40);
		add(jlb5);
		jlb5.setFont(lf1);
		jlt1=new JTextField();
		jlt1.setBounds(1000,200,250,40);
		add(jlt1);
		jlt1.setEditable(false);

		jlb2=new JLabel("Old Password :");
		jlb2.setBounds(150,280,150,40);
		add(jlb2);
		jlb2.setFont(lf1);
		jpf=new JPasswordField();
		jpf.setBounds(350,280,250,40);
		add(jpf);
		bt=new JButton("Confim");
		bt.setBounds(500,330,100,30);
		add(bt);
		bt.addActionListener(this);
		
		jlb4=new JLabel("New Password :");
		jlb4.setBounds(150,430,150,40);
		add(jlb4);
		jlb4.setFont(lf1);
		jpf1=new JPasswordField();
		jpf1.setBounds(350,430,250,40);
		add(jpf1);
		jpf1.setEditable(false);
		jpf1.addFocusListener(this);
		
		jlbc4=new JLabel("Confirm New Password :");
		jlbc4.setBounds(750,430,350,40);
		add(jlbc4);
		jlbc4.setFont(lf1);
		jpf2=new JPasswordField();
		jpf2.setBounds(1000,430,250,40);
		add(jpf2);
		jpf2.setEditable(false);
		jpf2.addFocusListener(this);
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
					String sql="select ADMIN_NAME,PASSWORD from admin where admin_id=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					ResultSet rs=st.executeQuery();
					rs.next();
					if((jpf.getText()).equals(rs.getString(2))) {
						jlt1.setText(rs.getString(1));
						jlt.setEditable(false);
						jpf.setEditable(false);
						JOptionPane.showMessageDialog
						(this,"Admin Id Confirms.");
						jpf1.setEditable(true);
						jpf2.setEditable(true);
						
					}				
					else
						JOptionPane.showMessageDialog(this,"Wrong Old password");
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
				jlt.setText("");
				jlt1.setText("");
				jpf.setText("");
				jpf1.setText("");
				jpf2.setText("");
				jlt.setEditable(true);
				jpf.setEditable(true);
				jpf1.setEditable(false);
				jpf2.setEditable(false);
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
		if(e.getSource()==jpf1) {
			String pass=jpf1.getText();
			Pattern p= Pattern.compile("[^a-zA-z0-9]");
			Matcher m=p.matcher(pass);
			if(!(m.find()&&jpf1.getText().length()>8)) {
				JOptionPane.showMessageDialog(this,"Password mustbe contain Capital letters,Small letters,\nSpecial character and numeric values and\n length must be 9");
				jpf1.grabFocus();
			}
		}
		if(e.getSource()==jpf2) {
			if(!jpf1.getText().equals(jpf2.getText())) {
				jpf2.setBackground(Color.RED);
			}
			else
				jpf2.setBackground(Color.WHITE);
		}
	}
}