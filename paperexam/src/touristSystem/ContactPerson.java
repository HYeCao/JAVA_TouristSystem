/**
 * 
 */
package touristSystem;

/**
 * @author dell
 *
 */
public class ContactPerson extends Person {
	private String position;

	/**
	 * @param name
	 * @param telephoneNumber
	 * @param email
	 * @param position
	 */
	public ContactPerson(String name, String telephoneNumber, String email, String position) {
		super(name, telephoneNumber, email);
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactPerson [position=" + position + " Email=" + this.getEmail() + " Name=" + this.getName() + "]";
	}

}
