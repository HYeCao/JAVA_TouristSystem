package touristSystem;

import java.io.BufferedReader;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 *
 */
public class TouristSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private List<Tourist> touristList;
	private Tourist tourist;

	/**
	 * Loads data and starts the application.
	 *
	 * @param args
	 *            String arguments. Not used.
	 * @throws IOException
	 *             if there are errors in the input.
	 */

	public static void main(String[] args) throws IOException, InterruptedException {

		TouristSystem application = new TouristSystem();
		application.run();

	}

	/**
	 * @param touristList
	 */

	private TouristSystem() {
		this.touristList = loadTourist();
	}

	/**
	 * 
	 * @return touristList
	 */
	private List<Tourist> loadTourist() {
		List<Tourist> touristList = new ArrayList<Tourist>();
		touristList.add(new IndividualTourist("A01", new Person("LI", "13231058910", "123@qq.com")));
		touristList.add(new IndividualTourist("A02", new Person("wang", "13231058911", "123@qq.com")));
		touristList.add(new TouristGroup("B02", new ContactPerson("Mike", "13231059812", "126@qq.com", "leader")));
		return touristList;
	}

	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {

				addTourist();
			} else if (choice == 2) {

				Tourist tourist;
				tourist = readTourist();
				look(tourist);
			} else if (choice == 3) {

				removeTourist();
			} else if (choice == 4) {

				addNewcontact();
			} else if (choice == 5) {
				String a, b;
				stdErr.print("Contact code> ");
				stdErr.flush();
				a = stdIn.readLine();
				stdErr.print("Contact name> ");
				stdErr.flush();
				b = stdIn.readLine();
				lookupContact(a, b);
			} else if (choice == 6) {
				String a, b;
				stdErr.print("Contact ID>");
				stdErr.flush();
				a = stdIn.readLine();
				stdErr.print("Contact name>");
				stdErr.flush();
				b = stdIn.readLine();
				removeContact(a, b);
			}
			choice = getChoice();
		}
	}

	public void look(Tourist tourist) {
		System.out.println(tourist.toString());
	}

	/*
	 * Displays a menu of options and verifies the user's choice.
	 *
	 * @return an integer in the range [0,7]
	 */
	private int getChoice() throws IOException {

		int input;
		do {
			try {
				stdErr.println();
				stdErr.print("[0] Quit\n" + "[1] Add a tourist into the system \n"
						+ "[2] Look up a tourist given an ID\n" + "[3] Remove a tourist from the system given an ID\n"
						+ "[4] Add a new contact for a tourist groups\n"
						+ "[5] Look up a contact given the ID of the group and the name of the contact\n"
						+ "[6] Remove a contact given the ID of the group and the name of the contact\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && input <= 6) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/*
	 * Prompts user for a product code and locates the associated
	 * <code>Product</code> object.
	 *
	 * @return reference to the <code>Product</code> object with the specified
	 * code
	 */
	private Tourist readTourist() throws IOException {

		stdErr.print("Tourist code> ");
		stdErr.flush();

		Tourist tourist = this.lookupTouristGivenanID(stdIn.readLine());
		if (tourist != null) {
			return tourist;
		} else {
			stdErr.println("There are no tourist with that code");
			return null;
		}
	}

	/**
	 * 
	 * @param ID
	 * @return
	 */
	public Tourist lookupTouristGivenanID(String ID) {
		for (Tourist tourist : touristList) {
			if (tourist.getID().equals(ID)) {
				return tourist;
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean addTourist() throws IOException {
		IndividualTourist tourist;
		String a, b, c, d;
		stdErr.print("Tourist code> ");
		stdErr.flush();
		a = stdIn.readLine();
		stdErr.print("Tourist name>");
		stdErr.flush();
		b = stdIn.readLine();
		stdErr.print("Tourist telephone>");
		stdErr.flush();
		c = stdIn.readLine();
		stdErr.print("Tourist email>");
		stdErr.flush();
		d = stdIn.readLine();
		tourist = new IndividualTourist(a, new Person(b, c, d));
		touristList.add(tourist);
		if (tourist != null) {
			stdErr.println("Add successfully!");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean removeTourist() throws IOException {
		Tourist tourist = readTourist();
		if (tourist != null) {
			int i = 0;
			for (Tourist tour : touristList) {
				i = i + 1;

				if (tourist.getID().equals(tour.getID())) {
					touristList.remove(i);
					stdErr.println("Remove successfully!");
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean addNewcontact() throws IOException {
		ContactPerson contact;
		String a, b, c, d, e;
		stdErr.print("Contact code> ");
		stdErr.flush();
		a = stdIn.readLine();
		stdErr.print("Contact name>");
		stdErr.flush();
		b = stdIn.readLine();
		stdErr.print("Contact telephone>");
		stdErr.flush();
		c = stdIn.readLine();
		stdErr.print("Contact email>");
		stdErr.flush();
		d = stdIn.readLine();
		stdErr.print("Contact position> ");
		stdErr.flush();
		e = stdIn.readLine();
		contact = new ContactPerson(b, c, d, e);
		touristList.add(new TouristGroup(a, contact));
		if (contact != null) {
			stdErr.println("Add successfully!");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param ID
	 * @param name
	 */
	public void lookupContact(String ID, String name) {
		ContactPerson contact = null;
		for (Tourist tourist : touristList) {
			if (tourist.getID().equals(ID)) {
				if (tourist instanceof TouristGroup) {
					TouristGroup group = (TouristGroup) tourist;
					contact = group.getContactByName(name);
				}
			}
		}
		if (contact != null)
			System.out.println(contact.toString());
		else
			System.out.println("Can not find the contact");
	}

	/**
	 * 
	 * @param ID
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public boolean removeContact(String ID, String name) throws IOException {
		ContactPerson contact = null;
		int i = 0;
		for (Tourist tourist : touristList) {
			i = i + 1;
			if (tourist.getID().equals(ID)) {
				if (tourist instanceof TouristGroup) {
					TouristGroup group = (TouristGroup) tourist;
					contact.equals(group.getContactByName(name));
					touristList.remove(i);
					stdErr.println("Remove successfully!");
					return true;
				}
			}
		}
		stdErr.println("Can not Remove");
		return false;
	}

}
