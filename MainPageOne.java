import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPageOne extends JFrame implements ActionListener {
	JMenuBar vms;
	JMenu ref,ma,st,vis;
	JMenuItem ad,adc,us,mi,mf,mu,md;
	JMenuItem si,sf,su,sd;
	JMenuItem vi,vf,vu;
	JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6;
	JButton bt1;
	public MainPageOne() {
		setSize(1350,750);
		setTitle("Home Page...");
		setDefaultCloseOperation(this.HIDE_ON_CLOSE);
		
		jlb=new JLabel("A customer is the most important visitor on our premises,");
		jlb.setBounds(70,170,500,40);
		add(jlb);
		Font Ifjlb=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb.setFont(Ifjlb);
		jlb1=new JLabel("he is not dependent on us.");
		jlb1.setBounds(160,190,700,40);
		add(jlb1);
		Font Ifjlb1=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb1.setFont(Ifjlb1);
		jlb2=new JLabel("We are dependent on him. He is not an interruption in our work.");
		jlb2.setBounds(70,210,500,40);
		add(jlb2);
		Font Ifjlb2=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb2.setFont(Ifjlb2);
		jlb3=new JLabel("He is the purpose of it.");
		jlb3.setBounds(170,230,700,40);
		add(jlb3);
		Font Ifjlb3=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb3.setFont(Ifjlb3);
		jlb4=new JLabel("He is not an outsider in our business. He is part of it.");
		jlb4.setBounds(90,250,700,40);
		add(jlb4);
		Font Ifjlb4=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb4.setFont(Ifjlb4);
		jlb5=new JLabel("We are not doing him a favor by serving him. ");
		jlb5.setBounds(110,270,700,40);
		add(jlb5);
		Font Ifjlb5=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb5.setFont(Ifjlb5);
		jlb6=new JLabel("He is doing us a favor by giving us an opportunity to do so.");
		jlb6.setBounds(80,290,700,40);
		add(jlb6);
		Font Ifjlb6=new Font("Tempus Sans ITC",Font.BOLD,20);
		jlb6.setFont(Ifjlb6);
		
		vms=new JMenuBar();
		ref=new JMenu("Registration");
		ma=new JMenu("Manager");
		st=new JMenu("Staff");
		vis=new JMenu("Visitor");
		mi=new JMenuItem("Insert");
		mf=new JMenuItem("Find");
		mu=new JMenuItem("Update");
		md=new JMenuItem("Delete");
		ma.add(mi); ma.add(mf); ma.add(mu); ma.add(md);
		mi.addActionListener(this); mf.addActionListener(this); 
		mu.addActionListener(this); md.addActionListener(this);
		
		si=new JMenuItem("Insert");
		sf=new JMenuItem("Find");
		su=new JMenuItem("Update");
		sd=new JMenuItem("Delete");
		st.add(si); st.add(sf); st.add(su); st.add(sd);
		si.addActionListener(this); sf.addActionListener(this); 
		su.addActionListener(this); sd.addActionListener(this);
		
		
		vi=new JMenuItem("Insert");
		vf=new JMenuItem("Find");
		vu=new JMenuItem("Update");
		vis.add(vi); vis.add(vf); vis.add(vu);
		vi.addActionListener(this); vf.addActionListener(this); 
		vu.addActionListener(this);
		
		ad=new JMenuItem("Admin Registration");
		adc=new JMenuItem("Admin Change Password");
		us=new JMenuItem("User Registration");
		ref.add(ad);   ref.add(adc);	ref.add(us);
		ad.addActionListener(this);
		adc.addActionListener(this);
		
		vms.add(ref); vms.add(ma); vms.add(st); vms.add(vis);
		setJMenuBar(vms);
		
		bt1=new JButton("Log Out");
		bt1.setBounds(1150,650,100,40);
		add(bt1);
		bt1.addActionListener(this);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon
				("D:\\Ecjava\\ProjectTwo\\MainPage.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainPageOne();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ad)
			new AdminRegister();
		if(e.getSource()==adc)
			new ChangePassword();
		if(e.getSource()==mi)
			new ManagerInsert();
		if(e.getSource()==mf)
			new ManagerFind();
		if(e.getSource()==mu)
			new ManagerUpdate();
		if(e.getSource()==md)
			new ManagerDelete();
		
		if(e.getSource()==si)
			new StaffInsert();
		if(e.getSource()==sf)
			new StaffFind();
		if(e.getSource()==su)
			new StaffUpdate();
		if(e.getSource()==sd)
			new StaffDelete();
	
		if(e.getSource()==vi)
			new VisitorInsert();
		if(e.getSource()==vf)
			new VisitorFind();
		if(e.getSource()==vu)
			new VisitorUpdate();
		if(e.getSource()==bt1)
			System.exit(1);
	}
}