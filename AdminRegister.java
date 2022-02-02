import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AdminRegister extends JFrame implements ActionListener,FocusListener {
	JLabel jlb, jlb1,jlb2,jlb3,jlb4,jlb5;
	JTextField jlt,jlt1,jlt2,jlt3;
	JPasswordField jpf;
	JButton bt,bt1;
	public AdminRegister() {
		setLayout(null);
		jlb3=new JLabel("Admin Registration");
		jlb3.setBounds(250,50,300,40);
		add(jlb3).setForeground(Color.WHITE);Font lf11= new Font("Times New Roman",Font.CENTER_BASELINE,32);
		jlb3.setFont(lf11);
		jlb=new JLabel("Admin Id :");
		jlb.setBounds(150,150,150,40);
		add(jlb).setForeground(Color.WHITE);
		Font lf1= new Font("Times New Roman",Font.BOLD,20);
		jlb.setFont(lf1);

		jlt=new JTextField();
		jlt.setBounds(350,150,150,40);
		add(jlt);
		jlb1=new JLabel("Admin Name :");
		jlb1.setBounds(750,150,150,40);
		add(jlb1).setForeground(Color.WHITE);
		jlb1.setFont(lf1);
		jlt1=new JTextField();
		jlt1.setBounds(950,150,150,40);
		add(jlt1);
		jlb2=new JLabel("Password :");
		jlb2.setBounds(150,250,150,40);
		add(jlb2).setForeground(Color.WHITE);
		jlb2.setFont(lf1);
		jpf=new JPasswordField();
		jpf.setBounds(350,250,150,40);
		add(jpf);
		jlb4=new JLabel("E-Mail :");
		jlb4.setBounds(150,350,150,40);
		add(jlb4).setForeground(Color.WHITE);
		jlb4.setFont(lf1);
		jlt2=new JTextField();
		jlt2.setBounds(350,350,150,40);
		add(jlt2);
		jlb5=new JLabel("Phone Number :");
		jlb5.setBounds(750,350,150,40);
		add(jlb5).setForeground(Color.WHITE);
		jlb5.setFont(lf1);
		jlt3=new JTextField();
		jlt3.setBounds(950,350,150,40);
		add(jlt3);
		jlt3.addFocusListener(this);

		bt=new JButton("SAVE");
		bt.setBounds(400,550,200,50);
		add(bt);
		bt.addActionListener(this);
		bt1=new JButton("CANCEL");
		bt1.setBounds(700,550,200,50);
		add(bt1);
		bt1.addActionListener(this);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon
				("D:\\Ecjava\\ProjectTwo\\LoginRegister.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
	
		setSize(1350,750);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		setTitle("Admin Register");
	}

	public static void main(String[] args)throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
		AdminRegister obj=new AdminRegister();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bt) {
			String a=jlt.getText();
			String b=jlt1.getText();
			String c=jpf.getText();
			String d=jlt2.getText();
			String e=jlt3.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="insert into admin values(?,?,?,?,?,1,1)";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					st.setString(2,b);
					st.setString(3,c);
					st.setString(4,d);
					st.setString(5,e);
									
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Saved");
					conn.close();
					jlt.setText("");
					jlt1.setText("");
					jpf.setText("");
					jlt2.setText("");
					jlt3.setText("");
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}
				 
				if(ae.getSource()==bt1) {
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
		if(e.getSource()==jlt3) {
			if(jlt3.getText().length()<10 || jlt3.getText().length()>10) {
				JOptionPane.showMessageDialog(this,"Phone number must be contain 10 digits");
				jlt3.grabFocus();
			}	
		}
	}
}