import java.sql.*;
import java.util.*;
import java.io.*;
public class Main extends User{

	public static void main(String[] args) {
		System.out.println("\tMedical Product Monitoring System");
		System.out.print("---------------------------------------------------------------------\n");
		System.out.println("1.User"+"\n"+"2.Retailer");
		System.out.println("Enter Your Profile: ");
		Scanner sc = new Scanner(System.in);
		String profile = sc.next();
		User us = new User();
		Retailer re = new Retailer();
        switch(profile)
        {
        case "USER":
        case "User":
        case "user":
        	us.Uses();
        	break;
        case "RETAILER":
        case "Retailer":
        case "retailer":
        	re.Retail();
        	break;
        default:
        	System.out.println("Enter valid Profile");
        	
        }

	}
}
