import java.sql.*;
import java.util.*;
public class User {

	public void Uses() {
		try
		{
			String medicineId;
			Scanner sc = new Scanner(System.in);
//			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_details","root","Medicalroot100#");
			Statement state = con.createStatement();
			ResultSet list = state.executeQuery("select * from med_details");
			while(list.next())
			{
				System.out.println(list.getString(1)+"\t"+list.getString(2));
			}
			System.out.println("Enter the Medicine ID to search:\n");
			medicineId = sc.next();
			Statement stm = con.createStatement();
//			System.out.println("Printing Records");
			String str = "select * from med_details where ProductID="+medicineId;
		    ResultSet rs = stm.executeQuery(str);
		    int flag =0;
		    while(rs.next())
		    {
		    	flag=1;
		    	System.out.println("Medicine Name: "+rs.getString(2));
		    	System.out.println("Shopname: "+rs.getString(11));
		    	System.out.println("Contact Number: "+rs.getString(12));
		    	System.out.println("Location: "+rs.getString(5));
		       	System.out.println("Dosage: "+rs.getString(9));
		    	System.out.println("For Age: "+rs.getString(10));
		    	System.out.println("ExpiryDate: "+rs.getString(3));
		    	System.out.println("Benefits: "+rs.getString(8));
		    	System.out.println("Side Effects: "+rs.getString(7));
		    	System.out.println("Manufacturer Name: "+rs.getString(4));
		    	System.out.println("Origin Country: "+rs.getString(6));
		    	
		    }
		    if(flag==0)
		    {
		    	System.out.println("Medicine ID not Found");
		    }
		}catch(Exception e)
		{
			System.out.println(e);
	}
		
	}
        
}
