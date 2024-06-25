import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class FrameDemo extends Frame implements ActionListener  
{ 
	
	Button b;
    Button c;
     Label l1;
	 Label l2;
	 Label l3;
	TextField tf1;
	TextField tf2;
	TextField tf3;
	public FrameDemo(String fname)
	{
	     		 super(fname);
        setLayout(new FlowLayout());
		 //setLayout(null);
		 b=new Button("Submit");
		 c=new Button("Clear");
         b.setBounds(200,200,20,20);
		 l1=new Label("Roll NO");
		 l2=new Label("Name");
		 l3=new Label("Course");
		 tf1=new TextField(10);
		 tf2=new TextField(10);
		 tf3=new TextField(10);
	    b.addActionListener(this);
		c.addActionListener(this);
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(tf3);
		add(b);
		add(c);
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
				PreparedStatement ts=con.prepareStatement("insert into student values(?,?,?)");
				ts.setInt(1,Integer.parseInt(tf1.getText()));
		        ts.setString(2,tf2.getText());
                ts.setString(3,tf3.getText()); 
 
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
			tf1.setText(s);
			tf2.setText(s);
		}

	
	}
	public static void main(String[] args) 
	{
		FrameDemo f=new FrameDemo("First Frame");
		

		//System.out.println("Hello World!");
	}
}
