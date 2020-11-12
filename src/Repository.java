import java.sql.*;
import java.util.ArrayList;

public class Repository {

	// Bring our password in for all ()
	Pwd pwd = new Pwd();

	// Constructor for for driver
	public Repository() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// EXAMPLE
	// Gets all the userIDs from User
	public ArrayList<Integer> GetAllUserIds() {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "SELECT UserId FROM Users";

		// Storage for the response
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Give the statement the query and return the set
			ResultSet rs = st.executeQuery(query);

			// As response comes in, store to result set
			while (rs.next()) {

				int userId = rs.getInt("UserId");

				// Put into response into Array
				returnList.add(userId);
			}

			c.close();
			return returnList;
		} catch (SQLException e) {
			e.printStackTrace();
			return returnList;
		}
	}

	// Gets all the events from the CRM
	public ArrayList<Integer> getAllEvents() {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "SELECT eventID FROM XEvents";
		System.out.println(query);

		// Storage for the response
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Give the statement the query and return the set
			ResultSet rs = st.executeQuery(query);

			// As response comes in, store to result set
			while (rs.next()) {

				//
				int userId = rs.getInt("EventID");

				// Put into response into Array
				returnList.add(userId);
			}

			c.close();
			return returnList;
		} catch (SQLException e) {
			e.printStackTrace();
			return returnList;
		}
	}

	// Insert a Venue to CRM
	public void insertVenue(String value) {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "INSERT INTO XVenues VALUES (" + value + ")";
		System.out.println(query);

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Submit the statement
			st.executeQuery(query);

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update a Venue Name in CRM
	public void updateVenueName(String r1, String r2) {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "UPDATE XVenues SET VenueName = '" + r2 + "' WHERE VenueID = " + r1;
		System.out.println(query);

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Submit the statement
			st.executeQuery(query);

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete a Venue Name in CRM
	public void deleteVenue(String r1) {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "DELETE FROM XVenues WHERE VenueID = " + r1;
		System.out.println(query);

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Submit the statement
			st.executeUpdate(query);

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Gets all the venues from the CRM
	public ArrayList<Integer> getAllVenues() {

		// declares a new password
		Pwd pwd = new Pwd();

		// Defines our statement
		Statement st = null;

		// THE QUERY
		String query = "SELECT VenueID FROM XVenues";
		System.out.println(query);

		// Storage for the response
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		try {

			// Establish a DB connection with the IP, Port, Standard, User name,
			// and Password
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
					pwd.Password());

			// Link the connection to a statement
			st = c.createStatement();

			// Give the statement the query and return the set
			ResultSet rs = st.executeQuery(query);

			// As response comes in, store to result set
			while (rs.next()) {

				//
				int userId = rs.getInt("VenueID");

				// Put into response into Array
				returnList.add(userId);
			}

			c.close();
			return returnList;
		} catch (SQLException e) {
			e.printStackTrace();
			return returnList;
		}
	}
	
	// Get a venue name from the CRM
		public ArrayList<String> getVenueName(String r1) {

			// declares a new password
			Pwd pwd = new Pwd();

			// Defines our statement
			Statement st = null;

			// THE QUERY
			String query = "SELECT VenueName FROM XVenues WHERE VenueID = " + r1;
			System.out.println(query);

			// Storage for the response
			ArrayList<String> returnList = new ArrayList<String>();

			try {

				// Establish a DB connection with the IP, Port, Standard, User name,
				// and Password
				Connection c = DriverManager.getConnection("jdbc:oracle:thin:@XXX.XXX.XX.XXX:XXXX:def", "XXXX",
						pwd.Password());

				// Link the connection to a statement
				st = c.createStatement();

				// Give the statement the query and return the set
				ResultSet rs = st.executeQuery(query);

				// As response comes in, store to result set
				while (rs.next()) {

					//
					String userId = rs.getString("VenueName");

					// Put into response into Array
					returnList.add(userId);
				}

				c.close();
				return returnList;
			} catch (SQLException e) {
				e.printStackTrace();
				return returnList;
			}
		}

}
