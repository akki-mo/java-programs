import java.sql.*;
class  InsStud
{
	public static void main(String[] args) 
	{
       try{
			  Class.forName("com.mysql.jdbc.Driver") ;
				
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
				PreparedStatement ts=con.prepareStatement("insert into student values(?,?,?)");
				ts.setInt(1,8 );
		        ts.setString(2,"Priyesh" );
                ts.setString(3,"MCA" ); 
 
				int n=ts.executeUpdate();
				System.out.println(n+" Records Inserted Successfully!");
				
		  con.close();
           }catch(Exception e){System.out.print(e);}
	}
}
