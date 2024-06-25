import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class RegDemo extends Frame implements ActionListener  
{ 
	
	Button b;
    Button c;
	Button d;
	Button e;
	Button f;
     Label l1;
	 Label l2;
	 Label l3;
	 Label l4;
	TextField nm;
	TextField ag;
	TextField cl;
    TextField ad;
	public RegDemo(String fname)
	{
	     		 super(fname);
        setLayout(new FlowLayout());
		 //setLayout(null);
		 b=new Button("Submit");
		 c=new Button("Clear");
		 d=new Button("Search");
		 e=new Button("Delete");
		 f=new Button("Update");
         //b.setBounds(200,200,20,20);
		 l1=new Label("Name");
		 l2=new Label("Age");
		 l3=new Label("Class");
		 l4=new Label("Address");
		 nm=new TextField(10);
		 ag=new TextField(10);
		 cl=new TextField(10);
         ad=new TextField(10);
	    b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		add(l1);
		add(nm);
		add(l2);
		add(ag);
		add(l3);
		add(cl);
		add(l4);
		add(ad);
		add(b);
		add(c);
         add(d);
         add(e);
         add(f);
		setSize(400,400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter()
			{
			public void windowClosing(WindowEvent e)
				{
				dispose();
			}
			});
	
	}
	public void actionPerformed(ActionEvent e)
	{
	
	if(e.getActionCommand().equals("Submit"))
		{

	try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				PreparedStatement ts=con.prepareStatement("insert into studreg(name,age,class,address) values(?,?,?,?)");
				ts.setString(1,nm.getText());
				ts.setInt(2,Integer.parseInt(ag.getText()));
		        ts.setString(3,cl.getText());
                ts.setString(4,ad.getText()); 
 
				int n=ts.executeUpdate();
				System.out.println(n+" Records Inserted Successfully!");
				
		  con.close();
           }
		   catch(Exception ex){System.out.print(ex);}

		}
		if(e.getActionCommand().equals("Clear"))
		{ 
            String s="";
            System.out.print("inside Clear");
			nm.setText(s);
			ag.setText(s);
			cl.setText(s);
			ad.setText(s);


		}

	if(e.getActionCommand().equals("Search"))
		{

	try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				PreparedStatement ts=con.prepareStatement("select * from studreg where name=?");
				ts.setString(1,nm.getText());
				
				ResultSet rs=ts.executeQuery();
				if(rs.next())
		       {
					System.out.println(" Records found Successfully!");
				ag.setText(""+rs.getInt(3));
			    cl.setText(rs.getString(4));
	       		ad.setText(rs.getString(5));
    
				
				}
				else{
				
				
				Dialog d=new Dialog(this,"Record Not Found");
				d.setSize(100,100);
				d.setLocation(50,50);
				d.setVisible(true);
				d.show();
				d.addWindowListener(new WindowAdapter()
			{
			public void windowClosing(WindowEvent e)
				{
				dispose();
			}
			});


				}
				
				
		  con.close();
           }
		   catch(Exception ex){System.out.print(ex);}

		}
		if(e.getActionCommand().equals("Delete"))
		{

	try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				PreparedStatement ts=con.prepareStatement("delete from studreg where name=?");
				ts.setString(1,nm.getText());
				
				int n=ts.executeUpdate();
				
					System.out.println(n+" Records deleted Successfully!");
				


				
				
				
		  con.close();
           }
		   catch(Exception ex){System.out.print(ex);}

		}
	if(e.getActionCommand().equals("Update"))
		{

	try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				PreparedStatement ts=con.prepareStatement("update studreg set age=?,class=?,address=? where name=?");
				ts.setString(4,nm.getText());
				ts.setInt(1,Integer.parseInt(ag.getText()));
								ts.setString(2,cl.getText());
												ts.setString(3,ad.getText());




				int n=ts.executeUpdate();
				
					System.out.println(n+" Records updated Successfully!");
				


				
				
				
		  con.close();
           }
		   catch(Exception ex){System.out.print(ex);}

		}
	
	}
	public static void main(String[] args) 
	{
		RegDemo f=new RegDemo("Student Registration Frame");
		

		//System.out.println("Hello World!");
	}
}
