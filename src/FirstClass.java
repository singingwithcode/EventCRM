/*
 * READ THIS FIRST:
 * 
 * To get this running you need to have the JDBC driver referencing Repository
 * 
 * You can run everything at once since I close the connection every call to Repository
 * 
 * Note, please keep the deleteWhatWeDid() up top so we do not run into overlap
 * You may get an error from this method on the first run if the DB was purged
 * Just like if we try to drop tables before they are created. 
 * 
 * NOTE2: When a DELETE is ran, it may take up to 2 minutes, DO NOT TRY AND RE-RUN when it stops, 
 * wait until the query has executed since it will continue down the list. 
 * 
 * Everything works 100%
 */


import java.util.ArrayList;

public class FirstClass {
	public static void main(String[] args) throws InterruptedException {

		// Create a new class where all our calls are
		Repository repo = new Repository();
		
		//The return value of some statements
		ArrayList<Integer> retVal;

		/*
		// Example
		// Gets all User IDs and prints them
		System.out.println("Getting all UserIDs");
		ArrayList<Integer> userIds = repo.GetAllUserIds();
		for (int i = 0; i < userIds.size(); i++) {
			System.out.println(userIds.get(i));
		}
		System.out.println("Done!");
		System.out.println("");
		*/
		
		// Delete all data we created on the last run
		// Note this will give you an error on first run if the database was
		// purged recently
		System.out.println("Deleting previously ran data (may get an error on first run if DB was purged)");
		System.out.println("This query may take up to two minutes because a DELETE is deemed not safe.");
		// Value, Name, Address, email, phone
		repo.deleteVenue("60");
		System.out.println("Done!");
		System.out.println("");

		// Select all venues to show the state
		System.out.println("Finding all venues");
		retVal = repo.getAllVenues();
		for (int i = 0; i < retVal.size(); i++) {
			System.out.print(retVal.get(i) + " ");
		}
		retVal.clear();
		System.out.println("");
		System.out.println("Done!");
		System.out.println("");

		// Insert a venue
		// The cool thing about this is a trigger is probably enabled and will add
		// the data to XOrganization. It will ignore if duplicate so no error
		System.out.println("Inserting a venue");
		// Value, Name, Address, email, phone
		repo.insertVenue("60, 'John Tito', '5345 N fds', 'john@j.co', 3334445555");
		System.out.println("Done!");
		System.out.println("");

		// Select all venues to show the state
		System.out.println("Finding all venues");
		retVal = repo.getAllVenues();
		for (int i = 0; i < retVal.size(); i++) {
			System.out.print(retVal.get(i) + " ");
		}
		retVal.clear();
		System.out.println("");
		System.out.println("Done!");
		System.out.println("");

		// Update a venue (the one we just put in)
		// Note: there is no trigger to catch this data change - only upon
		// INSERT
		System.out.println("Updating a venue");
		// ID to update
		String r1 = "60"; // ID
		// Things to change
		String r2 = "John Titos"; // Name
		repo.updateVenueName(r1, r2);
		System.out.println("Done!");
		System.out.println("");

		// Select all venues to show the state
		System.out.println("Finding all venues");
		retVal = repo.getAllVenues();
		for (int i = 0; i < retVal.size(); i++) {
			System.out.print(retVal.get(i) + " ");
		}
		retVal.clear();
		System.out.println("");
		System.out.println("Done!");
		System.out.println("");
		
		//Find entry 60 and show the updated name
		System.out.println("Finding venue name for VenueID 60 - the one we updated");
		String vid = "60";
		System.out.println(repo.getVenueName(vid));
		System.out.println("Done!");
		System.out.println("");

		// Select all events
		System.out.println("Finding all event IDs");
		retVal = repo.getAllEvents();
		for (int i = 0; i < retVal.size(); i++) {
			System.out.print(retVal.get(i) + " ");
		}
		retVal.clear();
		System.out.println("");
		System.out.println("Done!");
	}
}
