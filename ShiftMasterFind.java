import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ShiftMasterFind extends JFrame implements ActionListener{
	JLabel l1,s,m,t,w,th,fr,sat;
	JTextField t1;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton bt1,bt2;
	public ShiftMasterFind() {
		setLayout(null);	
		
		l1 = new JLabel("Shift id");
		l1.setBounds(150,100,150,50);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(400,100,200,30);
		add(t1);
		
		s = new JLabel("SUNDAY");
		s.setBounds(350,200,150,50);
		add(s);
		
		c1 = new JCheckBox();
		c1.setBounds(590,200,150,40);
		add(c1);
		c1.setEnabled(false);
		
		m = new JLabel("MONDAY");
		m.setBounds(350,250,150,50);
		add(m);
		
		c2 = new JCheckBox();
		c2.setBounds(590,250,150,40);
		add(c2);
		c2.setEnabled(false);
		
		t = new JLabel("TUESDAY");
		t.setBounds(350,300,150,50);
		add(t);
		
		c3 = new JCheckBox();
		c3.setBounds(590,300,150,40);
		add(c3);
		c3.setEnabled(false);
		
		w = new JLabel("WEDNESDAY");
		w.setBounds(350,350,150,50);
		add(w);
		
		c4 = new JCheckBox();
		c4.setBounds(590,350,150,40);
		add(c4);
		c4.setEnabled(false);
		
		th = new JLabel("THURSDAY");
		th.setBounds(350,400,150,50);
		add(th);
		
		c5 = new JCheckBox();
		c5.setBounds(590,400,150,40);
		add(c5);
		c5.setEnabled(false);
		
		fr = new JLabel("FRIDAY");
		fr.setBounds(350,450,150,50);
		add(fr);
		
		c6 = new JCheckBox();
		c6.setBounds(590,450,150,40);
		add(c6);
		c6.setEnabled(false);
		
		sat = new JLabel("SATURDAY");
		sat.setBounds(350,500,150,50);
		add(sat);
		
		c7 = new JCheckBox();
		c7.setBounds(590,500,150,40);
		add(c7);
		c7.setEnabled(false);
		
		bt1 = new JButton("Find");
		bt1.setBounds(500,600,100,40);
		add(bt1);
		bt1.addActionListener(this);
		
		bt2 = new JButton("Cancel");
		bt2.setBounds(700,600,100,40);
		add(bt2);
		bt2.addActionListener(this);	
		
		setSize(1350,750);
		setVisible(true);		
		setTitle("Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ShiftMasterFind();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt1) {
			String a=t1.getText();
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="select * from Shift_master where SHIFT_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(1,a);
					ResultSet rs=st.executeQuery();
					rs.next();
					if(rs.getInt(2)==1)
						c2.setSelected(true);
					if(rs.getInt(3)==1)
						c3.setSelected(true);
					if(rs.getInt(4)==1)
						c4.setSelected(true);
					if(rs.getInt(5)==1)
						c5.setSelected(true);
					if(rs.getInt(6)==1)
						c6.setSelected(true);
					if(rs.getInt(7)==1)
						c7.setSelected(true);
					if(rs.getInt(8)==1)
						c1.setSelected(true);
					conn.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}
		if(ae.getSource()==bt2) {
			this.hide();
			
		}		
	}
}