package test;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class TestClass {
	//this is for testing the jdbc statements 
	public static  Connection con;
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		startConnection();
		try {
			PreparedStatement pst = con.prepareStatement("Insert into vehicledetails values (?,?,?,?,?,?)");
			pst.setString(1,"TN00VS0000");
			pst.setString(2, "Chennai");
			pst.setString(3,"2019-06-29");
			pst.setString(4, "kamaleesh");
			pst.setString(5, "scooty");
			pst.setString(6, "summa");
			
			int recordsInserted = pst.executeUpdate();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		
	}
	private static void startConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rto","root","Kama@2001");
		}
		catch(SQLException e){
			System.out.println("Something went wrong Please make sure the connection is proper");
		}
	}
}
