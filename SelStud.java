import java.sql.*;
class  SelStud
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
       try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				Statement ts=con.createStatement();
				String str="select  * FROM student";
				
				ResultSet rs=ts.executeQuery(str);
				System.out.print("RollNO\tName\tCourse\n");
				while(rs.next())
		   {
		      int rollno=rs.getInt(1);
			  String name=rs.getString("name");
			   String course=rs.getString(3);
		     System.out.println(rollno+"\t"+name+"\t"+course);
		   
		   }
          rs.close();
		  con.close();
           }catch(Exception e){System.out.print(e);}
	}
}
