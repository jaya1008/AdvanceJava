package com.jayshree;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.sql.*;
public class MyMain  extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jnm;
	JTextField jid;
	JTextField jsl;
	JLabel lnm;
	JLabel lid;
	JLabel lsl;
	JLabel msins;
	JLabel upins;
	JLabel delins;
	
	JButton ins;
	JButton del;
	JButton clr;
	JButton updt;
	
	JButton back;
	JButton frw;
	JButton fst;
	JButton lst;
	
	int pos;
	
	
	public MyMain()throws Exception {
		super();
		
		
		


				
          this.setBackground(Color.CYAN);
          this.setSize(800,800);
          this.setLayout(null);
         
		this.lnm=new JLabel("EMP-NAME");
		this.lid=new JLabel("EMP-ID");
		this.lsl=new JLabel("EMP-SALARY");
		this.msins=new JLabel("RECORD INSERTED SUCCESSFULLY");
		this.upins=new JLabel("RECORD UPDATED SUCCESSFULLY");
		this.delins=new JLabel("RECORD DELETED SUCCESSFULLY");
		this.jnm=new JTextField();
		this.jid=new JTextField();
		this.jsl=new JTextField();	
		
		this.ins=new JButton("ÏNSERT");
		this.del=new JButton("DELETE");
		this.clr=new JButton("CLEAR");
	
		this.updt=new JButton("UPDATE");
		
		this.frw=new JButton(">");
		this.back=new JButton("<");
		this.fst=new JButton("<<");
		this.lst=new JButton(">>");
		
		
		
		//positions
		this.lid.setBounds(50,100, 100,70);
		this.jid.setBounds(200,100,70,50);
		this.lnm.setBounds(50,200, 100,70);
		this.jnm.setBounds(200,200,70,50);
		this.lsl.setBounds(50,300, 100,70);
		this.jsl.setBounds(200,300,70,50);
		
		this.fst.setBounds(450,400, 50, 50);
		this.frw.setBounds(550,400, 50, 50);
		this.back.setBounds(650,400, 50, 50);
		this.lst.setBounds(750,400, 50, 50);
		
		this.ins.setBounds(400,550, 80, 50);
		this.del.setBounds(500,550, 80, 50);
		this.updt.setBounds(600,550, 80, 50);
		this.clr.setBounds(700,550, 80, 50);
		
		msins.setBounds(400, 100, 200, 200);
		upins.setBounds(400, 100, 200, 200);
		delins.setBounds(400, 100, 200, 200);
		
		 this.lnm.setVisible(true);
	  		this.lid.setVisible(true);
	  		this.lsl.setVisible(true);
	  		
	  		this.jid.setVisible(true);
	  		this.jnm.setVisible(true);
	  		this.jsl.setVisible(true);
	  		
	  		this.fst.setVisible(true);
	  		this.back.setVisible(true);
	  		this.frw.setVisible(true);
	  		this.lst.setVisible(true);
	  		
	  		this.ins.setVisible(true);
	  		this.del.setVisible(true);
	  		this.updt.setVisible(true);
	  		this.clr.setVisible(true);
	  		msins.setVisible(false);
	  		upins.setVisible(false);
	  		delins.setVisible(false);
	  		
	  		this.add(lid);
	  		this.add(lnm);
	  		this.add(lsl);
	  		
	  		this.add(jid);
	  		this.add(jnm);
	  		this.add(jsl);
	  		
	  		this.add(fst);
	  		this.add(back);
	  		this.add(frw);
	  		this.add(lst);
	  		
	  		this.add(ins);
	  		this.add(del);
	  		this.add(updt);
	  		this.add(clr);

	  		this.add(upins);
	  		this.add(delins);
	  		this.add(msins);
	  		ins.addActionListener(this);
	  		del.addActionListener(this);
	  		updt.addActionListener(this);
	  		clr.addActionListener(this);
	  		frw.addActionListener(this);
	  		fst.addActionListener(this);
	  		lst.addActionListener(this);
	  		back.addActionListener(this);
	  		
	  		
	  		
	  		
	  		
	  		
	  				
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		


		
		
	}
	
	


	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub


    
		MyMain mm=new MyMain();
		mm.setVisible(true);
		
		

	}



	@Override
	public void actionPerformed(ActionEvent a) {
		 try{
		ResultSet rr=null;
			float sal=0;
			String query;
			String name;
			int id;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@database-server:1521:oracle10", "java", "java");
				PreparedStatement pins=con.prepareStatement("insert into pjemp values(?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				PreparedStatement pdel=con.prepareStatement("delete from pjemp where id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				PreparedStatement pup=con.prepareStatement("update pjemp set name=?,salary=?where id=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				PreparedStatement psel=con.prepareStatement("select * from pjemp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rr=psel.executeQuery();
				
		       this.pos=1;
	
				if(a.getSource().equals(ins)){
					
				name=new String(this.jnm.getText());
				//System.out.println("name-"+name);
				  
				
				  id=new Integer( Integer.parseInt(this.jid.getText().trim()));
				//  System.out.println("ïd="+id);
				sal=new Float(Float.parseFloat(this.jsl.getText().trim()));
				//System.out.println("sal="+sal);
				pins.setInt(1,id);
				pins.setString(2,name);
				pins.setFloat(3,sal);
				pins.executeUpdate();
				
				/*rr.updateInt(1,id);
				rr.updateString(2,name);
				rr.updateFloat(3,sal);
				rr.insertRow();*/
			
				this.jid.setText("");
				this.jnm.setText("");
				this.jsl.setText("");
				upins.setVisible(false);
				delins.setVisible(false);
					msins.setVisible(true);
				}	
					
					//updation
				if(a.getSource().equals(updt)){			
					name=new String(this.jnm.getText());
					//System.out.println("name-"+name);
					  
					
					  id=new Integer( Integer.parseInt(this.jid.getText()));
					//  System.out.println("ïd="+id);
					sal=new Float(Float.parseFloat(this.jsl.getText().trim()));
					//System.out.println("sal="+sal);
					
					pup.setInt(3,id);
					pup.setString(1,name);
					pup.setFloat(2,sal);
					pup.executeUpdate();
					
					/*rr.updateString(1,name);
					rr.updateFloat(3,sal);
					rr.updateRow();*/
					delins.setVisible(false);
					msins.setVisible(false);
					upins.setVisible(true);

				}	
				
				//deletion
	               if(a.getSource().equals(del)){			
					
	            		
	   				name=new String(this.jnm.getText());
	   				//System.out.println("name-"+name);
	   				  
	   				
	   				  id=new Integer( Integer.parseInt(this.jid.getText()));
	   				//  System.out.println("ïd="+id);
	   				sal=new Float(Float.parseFloat(this.jsl.getText().trim()));
	   				//System.out.println("sal="+sal);
	   				pdel.setInt(1,id);
	   			
	   				pdel.executeUpdate();
	   				/*rr.moveToCurrentRow();
	   				rr.deleteRow();*/
	   				msins.setVisible(false);
	   				upins.setVisible(false);
					delins.setVisible(true);
					


				}	
	
	//clear fields
	if(a.getSource().equals(clr)){			
		this.jid.setText("  ");
		this.jnm.setText("  ");
		this.jsl.setText("  ");
		msins.setVisible(false);
			upins.setVisible(false);
		delins.setVisible(false);
		

	}	
	
	//show First
	if(a.getSource().equals(fst)){	
		msins.setVisible(false);
		upins.setVisible(false);
	delins.setVisible(false);
	
	rr=psel.executeQuery();
	rr.next();
	id=rr.getInt(1);
			jid.setText(new String(""+id+""));
	jnm.setText(rr.getString(2));
	
	
	jsl.setText(""+rr.getFloat(3)+"");
				
	}
	
	//show last
	if(a.getSource().equals(lst)){		
		msins.setVisible(false);
		upins.setVisible(false);
	delins.setVisible(false);
	
	rr=psel.executeQuery();
	rr.last();
	
	id=rr.getInt(1);
	jid.setText(new String(""+id+""));
jnm.setText(rr.getString(2));


jsl.setText(""+rr.getFloat(3)+"");	
		
	}
	
	
	//show next
	
	if(a.getSource().equals(frw)){
		msins.setVisible(false);
		upins.setVisible(false);
	delins.setVisible(false);
	
		
		id=Integer.parseInt(jid.getText());
		while(rr.next()){
			
			if(rr.isLast()){
				
			}
			else{
			if(rr.getInt(1)==id){
			rr.next();	

			int id1=rr.getInt(1);
			jid.setText(new String(""+id1+""));
		jnm.setText(rr.getString(2));


		jsl.setText(""+rr.getFloat(3)+"");
				
			}
			}
			
		}
	    
		


	
	
	}
		
	
	
	
	//show previous
	
	
	if(a.getSource().equals(back)){		

		msins.setVisible(false);
		upins.setVisible(false);
	delins.setVisible(false);
	
		id=Integer.parseInt(jid.getText());
		rr.beforeFirst();
		while(rr.next()){
			
			if(rr.isFirst()){
				
			}
			else{
			if(rr.getInt(1)==id){
			rr.relative(-1);

			int id1=rr.getInt(1);
			jid.setText(new String(""+id1+""));
		jnm.setText(rr.getString(2));


		jsl.setText(""+rr.getFloat(3)+"");
				
			}
			}
			
		}
	    

		
	}
	
	
								
				con.close();
}
 catch(NumberFormatException e){
 	e.printStackTrace();
 }
catch(Exception e){
	e.printStackTrace();

}


}
}
