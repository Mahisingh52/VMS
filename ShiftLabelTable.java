import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ShiftLabelTable extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30;
	JButton bt1;
	public ShiftLabelTable() {
		setLayout(null);
		
		l1=new JLabel("Shift Time_id..");
		l1.setBounds(100,100,100,40);
		add(l1);
		l2=new JLabel("Shift master _id..");
		l2.setBounds(230,100,100,40);
		add(l2);
		l3=new JLabel("Shift from.. ");
		l3.setBounds(380,100,100,40);
		add(l3);
		l4=new JLabel("Shift to.. ");
		l4.setBounds(510,100,100,40);
		add(l4);
		
		l5=new JLabel();
		l5.setBounds(100,150,100,40);
		add(l5);
		l6=new JLabel();
		l6.setBounds(230,150,100,40);
		add(l6);
		l7=new JLabel();
		l7.setBounds(380,150,100,40);
		add(l7);
		l8=new JLabel();
		l8.setBounds(510,150,100,40);
		add(l8);
		
		l9=new JLabel();
		l9.setBounds(100,200,100,40);
		add(l9);
		l10=new JLabel();
		l10.setBounds(230,200,100,40);
		add(l10);
		l11=new JLabel();
		l11.setBounds(380,200,100,40);
		add(l11);
		l12=new JLabel();
		l12.setBounds(510,200,100,40);
		add(l12);
		
		l13=new JLabel();
		l13.setBounds(100,250,100,40);
		add(l13);
		l14=new JLabel();
		l14.setBounds(230,250,100,40);
		add(l14);
		l15=new JLabel();
		l15.setBounds(380,250,100,40);
		add(l15);
		l16=new JLabel();
		l16.setBounds(510,250,100,40);
		add(l16);
		
		l17=new JLabel();
		l17.setBounds(100,300,100,40);
		add(l17);
		l18=new JLabel();
		l18.setBounds(230,300,100,40);
		add(l18);
		l19=new JLabel();
		l19.setBounds(380,300,100,40);
		add(l19);
		l20=new JLabel();
		l20.setBounds(510,300,100,40);
		add(l20);
		
		l21=new JLabel();
		l21.setBounds(100,350,100,40);
		add(l21);
		l22=new JLabel();
		l22.setBounds(230,350,100,40);
		add(l22);
		l23=new JLabel();
		l23.setBounds(380,350,100,40);
		add(l23);
		l24=new JLabel();
		l24.setBounds(510,350,100,40);
		add(l24);
		
		l25=new JLabel("Status..");
		l25.setBounds(600,100,100,40);
		add(l25);
		l26=new JLabel();
		l26.setBounds(560,150,100,40);
		add(l6);
		l27=new JLabel();
		l27.setBounds(560,200,100,40);
		add(l7);
		l28=new JLabel();
		l28.setBounds(560,250,100,40);
		add(l8);
		l29=new JLabel();
		l29.setBounds(560,300,100,40);
		add(l8);
		l30=new JLabel();
		l30.setBounds(560,350,100,40);
		add(l8);
		
		bt1=new JButton("Display all");
		bt1.setBounds(40,40,50,20);
		add(bt1);
		bt1.addActionListener(this);
		
		setVisible(true);
		setSize(800,700);
		setTitle("Shift time id tabel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] e) {
		// TODO Auto-generated method stub
		ShiftLabelTable obj=new ShiftLabelTable();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			Statement st=con.createStatement();
			String sql="select * from Shift_Time";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));
				System.out.println(rs.getInt(5));
				
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}	
	}
}