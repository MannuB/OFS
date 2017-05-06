import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class admini extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
 	JComboBox j1,J2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	String id=null,name1="NO STUDENT EXIST";
	String name,phone,add,fee,course,age,sex,year,home,regsno;	
	String err="STUDENT NOT FOUND, PLEASE ENTER CORRECT ID";
	admini()
	{
		b1 = new JButton("Show");
		b2 = new JButton("Update");
		b3 = new JButton("New");
		b4 = new JButton("Logout");
		j1 = new JComboBox();
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
		l1 = new JLabel("Student_Id");
		l2 = new JLabel("Student_Name");
		l3 = new JLabel("Student_Phone");
		l4 = new JLabel("Student_Address");
		l5 = new JLabel("Student_Fee");
		l6 = new JLabel("Student_Course");
		l7 = new JLabel("Student_Age");
		l8 = new JLabel("Student_Sex");
		l9 = new JLabel("Student_Year");
		l10 = new JLabel("Student_Hometown");
		l11 = new JLabel("Student_Regs no");
		
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setLayout(new GridLayout(21,1));
					
		
	

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			ResultSet rs = null;			
			PreparedStatement st = con.prepareStatement("Select * from student");	
			rs= st.executeQuery();
			while(rs.next())
			{
				j1.addItem(rs.getString(2));
					
			}
			add(l1);
			add(l12);
			add(l2);
			add(j1);
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
			add(b1);
			add(b2);
			add(b3);
			add(b4);
				
			st.close();			
		
		}
		catch(Exception ae)
		{
			System.out.print(ae);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		
		try

		{	
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
ResultSet rs1= null;

			if(e.getSource()==b1)
			{
				name= j1.getSelectedItem().toString();
			PreparedStatement st1 = con1.prepareStatement("Select * from student where Student_Name=?");
				st1.setString(1,name);	
				rs1= st1.executeQuery();
				while(rs1.next())
				{
					id=rs1.getString(1);
					phone=rs1.getString(3);
					add=rs1.getString(4);
					fee=rs1.getString(5);
					course=rs1.getString(6);
					age=rs1.getString(7);
					sex=rs1.getString(8);
					year=rs1.getString(9);
					home=rs1.getString(10);
					regsno=rs1.getString(11);
					
					
				}
				l12.setText(id);
				
				t3.setText(phone);
				t4.setText(add);
				t5.setText(fee);
				t6.setText(course);
				t7.setText(age);
				t8.setText(sex);
				t9.setText(year);
				t10.setText(home);
				t11.setText(regsno);
				
				st1.close();
				

			}
			if(e.getSource()==b2)
			{
				adminup obj2 = new adminup();
				obj2.setSize(800,500);
				obj2.setVisible(true);
			}

			if(e.getSource()==b3)
			{
				adminnew obj1 = new adminnew();
				obj1.setSize(800,500);
				obj1.setVisible(true);

			}
			if(e.getSource()==b4)
			{
				System.exit(0);
			}
			
		}
		catch(Exception aee)
		{
			System.out.print(aee);
		}
	
	}


	 
	public static void main(String s[])
  	{
		admini obj = new admini();
		obj.setSize(400,400);
		obj.setVisible(true);
  	}
}