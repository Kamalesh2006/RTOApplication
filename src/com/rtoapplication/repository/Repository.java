package com.rtoapplication.repository;

import java.sql.*;

import com.rtoapplication.dto.User;
import com.rtoapplication.dto.Vehicle;

public class Repository {
	private static Repository repositoryInstance;
	private Connection con;
	private Repository() {
		startConnection();
	}
	public static Repository getInstance() {
		if(repositoryInstance==null) {
			repositoryInstance = new Repository();
		}
		return repositoryInstance;
	}
	private void startConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rto","root","Kama@2001");
		}
		catch(SQLException e){
			System.out.println("Something went wrong Please make sure the connection is proper");
		}
	}
	public String checkUser(String email, String password) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select userid from user where email=\""+email+"\" and password=\""+password+"\"");
			if(rs.next()) {
				return rs.getString("userid");
			}
			else {
				return "";
			}
		}
		catch(SQLException s) {
			return null;
		}
		
	}
	public String checkFranchise(String userid) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select franchiseid from franchise where userid=\""+userid+"\"");
			if(rs.next()) {
				return rs.getString("franchiseid");
			}
			else {
				return "";
			}
		}
		catch(SQLException s) {
			return null;
		}
	}
	public Vehicle getVehicle(String vehicleNo) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from vehicledetails where vehiclenumber = \""+vehicleNo+"\"");
			if(rs.next()) {
				String vehiclenumber = rs.getString("vehiclenumber");
				String registrationat = rs.getString("registrationat");
				String registrationdate = rs.getString("registrationdate");
				String ownername = rs.getString("ownername");
				String vehicletype = rs.getString("vehicletype");
				String modalname = rs.getString("modalname");
				Vehicle vehicle = new Vehicle(vehiclenumber,registrationat,registrationdate,ownername,vehicletype,modalname);
				return vehicle;
			}
			else {
				return null;
			}
		}
		catch(SQLException e) {
			return null;
		}
	}
	public User getUser(String userid) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from user where userid = \""+userid+"\"");
			if(rs.next()) {
				User user = new User(rs.getString("userid"),rs.getString("email"),rs.getString("name"),rs.getString("dob"),rs.getLong("phoneno"));
				return user;
			}
			else {
				return null;
			}
		}
		catch(SQLException s) {
			return null;
		}
	}
	public String getCity(String franchiseid) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select city from franchise where franchiseid = \""+franchiseid+"\"");
			if(rs.next()) {
				return rs.getString("city");
			}
			else 
				return null;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public boolean updateVehicle(Vehicle vehicle) {
		try {
			PreparedStatement pst = con.prepareStatement("Insert into vehicledetails values (?,?,?,?,?,?)");
			pst.setString(1, vehicle.getVehicleNumber());
			pst.setString(2, vehicle.getRegistrationAt());
			pst.setString(3, vehicle.getRegistrationDate());
			pst.setString(4, vehicle.getOwnerName());
			pst.setString(5, vehicle.getVehicleType());
			pst.setString(6, vehicle.getModalName());
			
			int recordsInserted = pst.executeUpdate();
			if(recordsInserted!=1) {
				return false;
			}
			else {
				return true;
			}
		}catch(SQLException e) {
			return false;
		}
	}
}
