import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class AdminLogin extends JFrame implements ActionListener,FocusListener{
	JLabel jlb,jlb1,jlb2,jlb3;
	JTextField jlt;
	JPasswordField jpf;
	JButton bt1,bt2;
	
	public AdminLogin(){
		
		setTitle("Admin Login Page");
		setSize(700,700);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
	
		jlb=new JLabel("ADMIN");
		jlb.setBounds(250,50,200,40);
		add(jlb);
		Font Ifjlb=new Font("Broadway",Font.BOLD,50);
		jlb.setFont(Ifjlb);
		jlb1=new JLabel("LOGIN PAGE");
		jlb1.setBounds(160,105,700,40);
		add(jlb1);
		Font Ifjlb1=new Font("Broadway",Font.BOLD,50);
		jlb1.setFont(Ifjlb1);
		
		jlb2=new JLabel("ADMIN ID");
		jlb2.setBounds(70,270,500,40);
		add(jlb2);
		Font Ifjlb2=new Font("Script MT Bold",Font.BOLD,25);
		jlb2.setFont(Ifjlb2);
		jlt=new JTextField();
		jlt.setBounds(350,270,200,40);
		add(jlt);
		jlt.addFocusListener(this);
		jlb3=new JLabel("PASSWORD");
		jlb3.setBounds(70,350,700,40);
		add(jlb3);
		Font Ifjlb3=new Font("Script MT Bold",Font.BOLD,25);
		jlb3.setFont(Ifjlb3);
		jpf=new JPasswordField();
		jpf.setBounds(350,350,200,40);
		add(jpf);
		jpf.addFocusListener(this);
		bt1=new JButton("LOGIN");
		bt1.setBounds(300,450,100,50);
		add(bt1);
		bt1.addActionListener(this);
		bt2=new JButton("CANCEL");
		bt2.setBounds(500,450,100,50);
		add(bt2);
		bt2.addActionListener(this);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon
				("D:\\Ecjava\\ProjectTwo\\AULogin.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
		
		setVisible(true);
		setTitle("Login Page");
	}

	public static void main(String[] args) {
		new AdminLogin();
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1) {
			String ui=jlt.getText();
			String ps=jpf.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select PASSWORD from admin where ADMIN_ID=?";
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1,ui);
				ResultSet rs=st.executeQuery();
				rs.next();
				String cps=rs.getString(1);
				if(ps.equals(cps)) {
					new MainPageOne();
				}
				else {
					JOptionPane.showMessageDialog(this, "Wrong Password");
				}
				conn.close();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Wrong User Id");
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
		if(e.getSource()==jlt) {
			if(jlt.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"please Fill User Id");
				jlt.grabFocus();
			}
		}
		else if(e.getSource()==jpf) {
			if(jpf.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"please Enter Password");
				jpf.grabFocus();
			}
		}
	}
}