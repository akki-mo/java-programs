import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class NegDemo extends Frame implements ActionListener  
{ 
	
	Button b;
    Button c;
	Button d;
	Button e;
	
     Label l1;
	 Label l2;
	 Label l3;
	 Label l4;
	TextField nm;
	TextField ag;
	TextField cl;
    TextField ad;
	ResultSet rs;
	public NegDemo(String fname)
	{
	     		 super(fname);
        setLayout(new FlowLayout());
		 //setLayout(null);
		 b=new Button("First");
		 c=new Button("Previous");
		 d=new Button("Next");
		 e=new Button("Last");
		 		 
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
	getDB();
	}//end of cons
	void getDB(){
	
	try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
								Statement ts=con.createStatement();

				
				
				 rs=ts.executeQuery("select * from studreg");

		
		  //con.close();
           }
		   catch(Exception ex){System.out.print(ex);}

	
	
	}// end of getDB
	
	public void actionPerformed(ActionEvent e)
	{
	
	if(e.getActionCommand().equals("First"))
		{

	try{

         rs.first();
				nm.setText(rs.getString(2));
				ag.setText(""+rs.getInt(3));
			    cl.setText(rs.getString(4));
	       		ad.setText(rs.getString(5));


           }
		   catch(Exception ex){System.out.print(ex);}

		}
		if(e.getActionCommand().equals("Previous"))
		{ 
            try{

         rs.previous();
				nm.setText(rs.getString(2));
				ag.setText(""+rs.getInt(3));
			    cl.setText(rs.getString(4));
	       		ad.setText(rs.getString(5));


           }
		   catch(Exception ex){System.out.print(ex);}
		}

	if(e.getActionCommand().equals("Next"))
		{

	try{

         rs.next();
				nm.setText(rs.getString(2));
				ag.setText(""+rs.getInt(3));
			    cl.setText(rs.getString(4));
	       		ad.setText(rs.getString(5));


           }
		   catch(Exception ex){System.out.print(ex);}
			  


				}
				
				
		  
		
		if(e.getActionCommand().equals("Last"))
		{

	try{

         rs.last();
				nm.setText(rs.getString(2));
				ag.setText(""+rs.getInt(3));
			    cl.setText(rs.getString(4));
	       		ad.setText(rs.getString(5));


           }
		   catch(Exception ex){System.out.print(ex);}
		}
	
	}
	public static void main(String[] args) 
	{
		NegDemo f=new NegDemo("Student Registration Frame");
		

		//System.out.println("Hello World!");
	}
}
