import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class adminnew extends JFrame implements ActionListener
{
	JButton b1,b2;
 	
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	String id= null;
	String name,phone,add,fee,course,age,sex,year,home,regsno;	
	int sal;
	adminnew()
	{
		b1 = new JButton("ADD");
		b2 = new JButton("Cancel");
		
		
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);
		t6 = new JTextField(10);
		t7 = new JTextField(10);
		t8 = new JTextField(10);
		t9 = new JTextField(10);
		t10 = new JTextField(10);
		t11 = new JTextField(10);
		l12 = new JLabel();
		l13 = new JLabel();	
		l2 = new JLabel("Student_Name");
		l3 = new JLabel("Student_Phone");
		l4 = new JLabel("Student_Address");
		l5 = new JLabel("Student_Fee");
		l6 = new JLabel("Student_Course");
		l7 = new JLabel("Student_Age");
		l8 = new JLabel("Student_Sex");
		l9 = new JLabel("Student_Year");
		l10 = new JLabel("Student_Hometown");
		l11 = new JLabel("Student_regsno");
		
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(l7);
		add(t7);
		add(l8);
		add(t8);
		add(l9);
		add(t9);
		add(l10);
		add(t10);
		add(l11);
		add(t11);
		add(l12);
		add(l13);
		add(b1);
		add(b2);		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new GridLayout(21,1));
	}
	public void actionPerformed(ActionEvent e)
	{
		try	
		{	
			int tempid,tempfee,tempage;
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			ResultSet rs=null;
			PreparedStatement st=con.prepareStatement("Select * from student");
			rs= st.executeQuery();
			while(rs.next())
			{
			
				id = rs.getString(1);
			}
			st.close();
			tempid = Integer.parseInt(id);
			tempid = tempid+1;
			
			if(e.getSource()==b1)
			{
				name = t2.getText();
				phone = t3.getText();
				add = t4.getText();
				fee = t5.getText();
				course = t6.getText();
				age = t7.getText();
				sex = t8.getText();
				year = t9.getText();
				home =t10.getText();
				regsno=t11.getText();
				tempfee=Integer.parseInt(fee);
				tempage=Integer.parseInt(age);
		PreparedStatement st1 = con.prepareStatement("Insert into student values(?,?,?,?,?,?,?,?,?,?,?)");
				st1.setInt(1,tempid);
				st1.setString(2,name); 
				st1.setString(3,phone);
				st1.setString(4,add);
				st1.setInt(5,tempfee);
				st1.setString(6,course);
				st1.setInt(7,tempage);
				st1.setString(8,sex);
				st1.setString(9,year);
				st1.setString(10,home);
				st1.setString(11,regsno);
				int rec = st1.executeUpdate();
				l12.setText(rec+" Record Added");
				add(l12);
				st1.close();
			}
			
			if(e.getSource()==b2)
			{
				admini obj1= new admini();
				obj1.setSize(800,500);
				obj1.setVisible(true);
			}
		}
        	catch(Exception ce)
		{
			System.out.print(ce);
		}
	}
	public static void main(String s[])
	{

		adminnew obj = new adminnew();
		obj.setSize(800,500);
		obj.setVisible(true);
	}
}
