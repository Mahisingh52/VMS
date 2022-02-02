import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserScreen extends JFrame implements ActionListener{
	JButton b1,b2,b3;
	
	public UserScreen() {
		
		setTitle("User Screen");
		setSize(800,600);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);	
		b1=new JButton("Insert");
		b1.setBounds(300,100,100,50);
		add(b1);    
		b2=new JButton("Find");
		b2.setBounds(300,200,100,50);
		add(b2);
		b3=new JButton("Update");
		b3.setBounds(300,300,100,50);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon
				("D:\\Ecjava\\ProjectTwo\\UserScreen.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
		
		
		getContentPane().setBackground(Color.YELLOW);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	                   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new UserScreen();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			new VisitorInsert();
		}
		if(e.getSource()==b2){
			new VisitorFind();
		}
		if(e.getSource()==b3){
			new VisitorUpdate();
		}
	}
}