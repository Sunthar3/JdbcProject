import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.io.*;
public class Retailer {
         public void Retail()
         {
        	 try
     		{
        		Scanner sc = new Scanner(System.in);
                String action;
     			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine_details","root","Medicalroot100#");
     			Statement state = con.createStatement();
 				ResultSet data = state.executeQuery("select * from med_details");
 				while(data.next())
 				{
 					System.out.println(data.getString(1)+"\t"+data.getString(2));
 				}	
     			System.out.println("1.View Database\n"+"2.Update Database");
     			System.out.println("Enter the action you want to perform: ");
     			action = sc.nextLine();
     			switch(action)
     			{
     			case "View Database":
     			case "view database":
     			case "viewdatabase":
     			case "Viewdatabase":
     			case "ViewDatabase":
     				System.out.println("Want to check more details then enter ProductID else enter no : ");
     				String disp = sc.next().trim();
     				if(disp.equals("no")||disp.equals("No")||disp.equals("NO"))
     				{
     					System.out.println("Exiting............................");
     					return ;
     				}
     				disp = "select * from med_details where ProductID="+disp;
     				ResultSet specdata = state.executeQuery(disp);
     				int flag = 0;
     				while(specdata.next())
     				{
     					flag =1;
     					System.out.println("Medicine Name: "+specdata.getString(2));
     			    	System.out.println("Shopname: "+specdata.getString(11));
     			    	System.out.println("Contact Number: "+specdata.getString(12));
     			    	System.out.println("Location: "+specdata.getString(5));
     			       	System.out.println("Dosage: "+specdata.getString(9));
     			    	System.out.println("For Age: "+specdata.getString(10));
     			    	System.out.println("ExpiryDate: "+specdata.getString(3));
     			    	System.out.println("Benefits: "+specdata.getString(8));
     			    	System.out.println("Side Effects: "+specdata.getString(7));
     			    	System.out.println("Manufacturer Name: "+specdata.getString(4));
     			    	System.out.println("Origin Country: "+specdata.getString(6));
     				}
     				if(flag==0)
     				{
     					System.out.print("Medicine ID Not Found");
     				}
     			break;
     			case "Update Database":
     			case "Updatedatabase":
     			case "UpdateDatabase":
     			case "updatedatabase":
     				System.out.println("1.Delete"+"\n"+"2.Insert");
     				System.out.println("Enter the operation you want to perform: ");
     				String oper = sc.next();
     				switch(oper)
     				{
     				case "Delete":
     				case "delete":
     					System.out.println("Enter the ProductId to Delete : ");
     					String id = sc.next();
     					String query = "delete from med_details where ProductID="+id;
     					Statement state2 = con.createStatement();
         				int deldata = state2.executeUpdate(query);
     					System.out.println("The Product with "+id+" id was successfully deleted......");
     					break;
     				case "Insert":
     				case "insert":
     					int proid = sc.nextInt();
     					String Productname = sc.next().trim();
     					//Date Expirydate = sc.next();
     					String Manufacturer = sc.next().trim();
     					String Address = sc.next().trim();
     					String origin = sc.next().trim();
     					String SideEffects = sc.next().trim();
     					String Benefits = sc.next().trim();
     					String Dosage = sc.next().trim();
     					String forWhom = sc.next().trim();
     					String shopname = sc.next().trim();
     					String Contactnum = sc.next().trim();
     					 String sql = "INSERT INTO med_details(ProductID,ProductName,ExpiryDate,Manufacturer_Name,Address,Origin_Country,Side_Effects,Benefits,Dosage,ForWhom,Shopname,ContactNumber) "
     			                   + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
     					 PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     					pstmt.setInt(1, proid);
     		            pstmt.setString(2, Productname);
     		           // pstmt.setDate(3, Expirydate);
     		            pstmt.setString(4, Manufacturer);
     		            pstmt.setString(5, Address);
     		            pstmt.setString(6, origin);
     		            pstmt.setString(7, SideEffects);
     		            pstmt.setString(8, Benefits);
     		            pstmt.setString(9, Dosage);
     		            pstmt.setString(10, forWhom);
     		            pstmt.setString(11, shopname);
     		            pstmt.setString(12, Contactnum);
     		            int rowAffected = pstmt.executeUpdate();
     	 				System.out.println("The Product with id "+proid+"is succesfully inserted into the database.....");
     				}
     			}
     			
     		}catch(Exception e)
     		{
     			System.out.println(e);
     		}
         }
}
