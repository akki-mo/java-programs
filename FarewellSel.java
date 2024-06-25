import java.sql.*;
class  FarewellSel
{
	public static void main(String[] args) 
	{
		
       try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				Statement ts=con.createStatement();
				String str="select  * FROM farewell";
				
				ResultSet rs=ts.executeQuery(str);
				System.out.print("RollNO\tName\t\tCourse\tYear\tMobile No\tEmail Id\n");
				while(rs.next())
		   {
		      int rollno=rs.getInt(1);
			  String name=rs.getString("name");
			   String course=rs.getString(3);
			   int year=rs.getInt(4);
			   int mob=rs.getInt(5);
			   String email=rs.getString(6);
		     System.out.println(rollno+"\t"+name+"\t"+course+"\t"+year+"\t"+mob+"\t"+email);
		   
		   }
          rs.close();
		  con.close();
           }catch(Exception e){System.out.print(e);}
	}
}
