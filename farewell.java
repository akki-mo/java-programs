import java.sql.*;
import java.io.*;
class farewell
{
	public static void main(String[] args) 
	{
		try
		{

			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
             int rollno;
			 int mobno;
			 int year;
		     String name;
			 String course;
			 String email;
			 String food;
           System.out.println("Enter roll no");
		   
		   rollno=Integer.parseInt(br.readLine());
            
			System.out.println("Enter Name");

            name=br.readLine();
            
			System.out.println("Enter Course");

		    course=br.readLine();

          System.out.println("Enter Year");

		  year=Integer.parseInt(br.readLine());

		  System.out.println("Enter Mobile No");

             mobno=Integer.parseInt(br.readLine());

            System.out.println("Enter Email id");
            
			email=br.readLine();

			System.out.println("Enter Food Preference VEG/Non-Veg");

			food=br.readLine();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			PreparedStatement ps=con.prepareStatement("insert into farewell values(?,?,?,?,?,?,?)");
            ps.setInt(1,rollno);
			ps.setString(2,name);
            ps.setString(3,course);
			ps.setInt(4,year);
			ps.setInt(5,mobno);
			ps.setString(6,email);
			ps.setString(7,food);

          int n =ps.executeUpdate();
		  System.out.println(n+"Recods Updated Succesfully");
          con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}




	}
}
