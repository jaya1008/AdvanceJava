package com.jayshree;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{
	
	JLabel lbl_eid,lbl_nm,lbl_deptno;
	JTextField txt_eid,txt_name,txt_deptno;
	JButton btn_add;
	Container con;
	Connection conn=null;
	public AddEmployee() {
		// TODO Auto-generated constructor stub
		
		setSize(600,600);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setTitle("Employee Addition Form");
		
		//Create a object of components
		
		lbl_eid=new JLabel("Enter Emp_id");
		lbl_nm=new JLabel("Enter Emp_name");
		lbl_deptno=new JLabel("Enter Emp_deptno");
		
		txt_eid=new JTextField(15);
		txt_name=new JTextField(15);
		txt_deptno=new JTextField(15);
		
		btn_add=new JButton("Add Employee");
		con=getContentPane();
		//Add components on container
		
		con.add(lbl_eid);
		con.add(txt_eid);
		con.add(lbl_nm);
		con.add(txt_name);
		con.add(lbl_deptno);
		con.add(txt_deptno);
		con.add(btn_add);
		btn_add.addActionListener(this);
		
		conn=MyConnection.getConnection();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddEmployee obj=new AddEmployee();
		obj.show();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		int eid=Integer.parseInt(txt_eid.getText());
		String nm=txt_name.getText();
		
		
		int dno=Integer.parseInt(txt_deptno.getText());
		
		JOptionPane.showMessageDialog(this, "Data is "+eid +","+nm+","+dno);
		
		try {
			Statement st=conn.createStatement();
			String sql="insert into employee values("+eid+",'"+nm+"',"+dno+")";
			System.out.println(sql);
			int rows=st.executeUpdate(sql);
			JOptionPane.showMessageDialog(this, rows+ " is inserted in database successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
