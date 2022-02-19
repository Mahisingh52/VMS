import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginPage extends JFrame implements ItemListener{
	JLabel jlb,jlb1,jlb2,jlb3;
	JComboBox cb;
	public LoginPage(){		
		setTitle("Login Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jlb=new JLabel("VISITOR");
		jlb.setBounds(250,50,300,40);
		add(jlb);
		Font Ifjlb=new Font("ALGERIAN",Font.BOLD,50);
		jlb.setFont(Ifjlb);
		jlb1=new JLabel(" MANAGEMENT  SYSTEM");
		jlb1.setBounds(30,105,700,40);
		add(jlb1);
		Font Ifjlb1=new Font("ALGERIAN",Font.BOLD,50);
		jlb1.setFont(Ifjlb1);
		
		jlb2=new JLabel("LOGIN PAGE");
		jlb2.setBounds(170,270,500,40);
		add(jlb2);
		Font Ifjlb2=new Font("Broadway",Font.BOLD,40);
		jlb2.setFont(Ifjlb2);
		jlb3=new JLabel("   Select the type of login you would like to use:");
		jlb3.setBounds(50,350,700,40);
		add(jlb3);
		Font Ifjlb3=new Font("Forte",Font.BOLD,25);
		jlb3.setFont(Ifjlb3);
		
		cb=new JComboBox();
		cb.addItem("");
		cb.addItem("ADMIN LOGIN");
		cb.addItem("USER LOGIN");
		cb.setBounds(250,450,150,50);
		add(cb);
		cb.addItemListener(this);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon
				("D:\\Ecjava\\ProjectTwo\\LoginPage.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		LoginPage obj=new LoginPage();
		// TODO Auto-generated method stub
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cb) {
			if(cb.getSelectedItem()=="ADMIN LOGIN") {
				new AdminLogin();
			}
			if(cb.getSelectedItem()=="USER LOGIN") {
				new UserLogin();
			}
		}
	}
}