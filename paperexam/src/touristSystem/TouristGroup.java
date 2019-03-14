/**
 * 
 */
package touristSystem;

import java.util.List;

//import brightSystem.Product;

/**
 * @author dell
 *
 */
public class TouristGroup extends Tourist {
	private ContactPerson contact;

	/**
	 * @param iD
	 * @param contact
	 */
	public TouristGroup(String iD, ContactPerson contact) {
		super(iD);
		this.contact = contact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TouristGroup [contact=" + contact + "]";
	}

	/**
	 * 
	 * @param name
	 */
	public ContactPerson getContactByName(String name) {
		if (this.contact.getName().equals(name))
			return this.contact;
		else
			return null;
	}

}
