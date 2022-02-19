import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ShiftMasterUpdate extends JFrame implements ActionListener{
	JLabel l1,s,m,t,w,th,fr,sat;
	JTextField t1;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton bt1,bt2,bt3;
	public ShiftMasterUpdate() {
		setLayout(null);	
		
		l1 = new JLabel("Shift id");
		l1.setBounds(150,100,150,50);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(400,100,200,30);
		add(t1);
		
		bt3=new JButton("Find");
		bt3.setBounds(700,100,100,40);
		add(bt3);
		bt3.addActionListener(this);
		
		s = new JLabel("SUNDAY");
		s.setBounds(350,200,150,50);
		add(s);
		
		c1 = new JCheckBox();
		c1.setBounds(590,200,150,40);
		add(c1);
		
		m = new JLabel("MONDAY");
		m.setBounds(350,250,150,50);
		add(m);
		
		c2 = new JCheckBox();
		c2.setBounds(590,250,150,40);
		add(c2);
		
		t = new JLabel("TUESDAY");
		t.setBounds(350,300,150,50);
		add(t);
		
		c3 = new JCheckBox();
		c3.setBounds(590,300,150,40);
		add(c3);
		
		w = new JLabel("WEDNESDAY");
		w.setBounds(350,350,150,50);
		add(w);
		
		c4 = new JCheckBox();
		c4.setBounds(590,350,150,40);
		add(c4);
		
		th = new JLabel("THURSDAY");
		th.setBounds(350,400,150,50);
		add(th);
		
		c5 = new JCheckBox();
		c5.setBounds(590,400,150,40);
		add(c5);
		
		fr = new JLabel("FRIDAY");
		fr.setBounds(350,450,150,50);
		add(fr);
		
		c6 = new JCheckBox();
		c6.setBounds(590,450,150,40);
		add(c6);
		
		sat = new JLabel("SATURDAY");
		sat.setBounds(350,500,150,50);
		add(sat);
		
		c7 = new JCheckBox();
		c7.setBounds(590,500,150,40);
		add(c7);
		
		bt1 = new JButton("Update");
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
		new ShiftMasterUpdate();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt1) {
			String a=t1.getText();
			int b=0,c=0,d=0,e=0,f=0,g=0,h=0;
			if(c1.isSelected())
				b=1;
			if(c2.isSelected())
				c=1;
			if(c3.isSelected())
				d=1;
			if(c4.isSelected())
				e=1;
			if(c5.isSelected())
				f=1;
			if(c6.isSelected())
				g=1;
			if(c7.isSelected())
				h=1;
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String sql="update Shift_master set MONDAY=?,TUESDAY=?,WEDNESDAY=?,THURSDAY=?,FRIDAY=?,SATURDAY=?,SUNDAY=?,STATUS=1 where SHIFT_ID=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setString(8,a);
					st.setInt(1,c);
					st.setInt(2,d);
					st.setInt(3,e);
					st.setInt(4,f);
					st.setInt(5,g);
					st.setInt(6,h);
					st.setInt(7,b);
									
					int x=st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Updated");
					conn.close();
					t1.setText("");
					c1.setSelected(false);
					c2.setSelected(false);
					c3.setSelected(false);
					c4.setSelected(false);
					c5.setSelected(false);
					c6.setSelected(false);
					c7.setSelected(false);
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
		}
		if(ae.getSource()==bt2) {
			this.hide();
		}
		if(ae.getSource()==bt3) {
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
	}
}