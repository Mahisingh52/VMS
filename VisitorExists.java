import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class VisitorExists extends JFrame implements ActionListener{
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextArea tm;
	JButton bt;
	public VisitorExists() {
		setTitle("Find Screen");
		setLayout(null);
		l=new JLabel("List of Inside Visitors :");
		l.setBounds(50,50,500,50);
		add(l);	Font fl=new Font("ALGERIAN",Font.BOLD,32);
		l.setFont(fl);
		
		l1=new JLabel("VISITOR ID");
		l1.setBounds(20,100,100,50);
		add(l1); Font fll=new Font("Times New Roman",Font.BOLD,16);
		l1.setFont(fll);
		
		l2=new JLabel("VISITOR NAME");
		l2.setBounds(130,100,150,50);
		add(l2); 
		l2.setFont(fll);

		l3=new JLabel("VISITOR EMAIL");
		l3.setBounds(290,100,150,50);
		add(l3); 
		l3.setFont(fll);
		
		l4=new JLabel("VISITOR PHONE No");
		l4.setBounds(470,100,150,50);
		add(l4); 
		l4.setFont(fll);
		
		l5=new JLabel("VISITOR ID TYPE");
		l5.setBounds(650,100,150,50);
		add(l5); 
		l5.setFont(fll);

		l6=new JLabel("VISITOR ID DETAIL");
		l6.setBounds(810,100,200,50);
		add(l6); 
		l6.setFont(fll);

		l7=new JLabel("STAFF ID");
		l7.setBounds(990,100,150,50);
		add(l7); 
		l7.setFont(fll);
		
		l8=new JLabel("TIME IN");
		l8.setBounds(1100,100,150,50);
		add(l8); 
		l8.setFont(fll);
		
		l9=new JLabel("EXPECTED TIME");
		l9.setBounds(1200,100,150,50);
		add(l9); 
		l9.setFont(fll);
		
		bt=new JButton("VISITOR INSERT");
		bt.setBounds(1100,30,150,30);
		add(bt);
		bt.addActionListener(this);
		
		tm=new JTextArea();
		tm.setBounds(30,150,1300,600);
		add(tm); 
		tm.setEditable(false);
		refresh();
		
		setSize(1350,750);
		setVisible(true);
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);

	}
	void refresh() {
		String str="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			Statement st=con.createStatement();
			String sql="select * from visitor";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getInt(12)==0) {
				str=str+"     "+rs.getString(1)+"\t";
				str=str+rs.getString(2)+"\t";
				str=str+rs.getString(3)+"\t";
				str=str+rs.getString(4)+"\t\t";
				str=str+rs.getString(5)+"\t\t";
				str=str+rs.getString(6)+"\t\t";
				str=str+rs.getString(7)+"\t";
				str=str+rs.getString(10)+"\t\t";
				str=str+rs.getString(11)+"\n";
				
			}	}
			tm.setText(str);
			con.close();
		}
			catch(Exception ex) {
				System.out.println(ex);
		}

	}
	public static void main(String[] args) {
		new VisitorExists();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt)
			new VisitorInsert();
	}

}