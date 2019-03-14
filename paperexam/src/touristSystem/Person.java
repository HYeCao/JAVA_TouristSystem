/**
 * 
 */
package touristSystem;

/**
 * @author dell
 *
 */
public class Person {
	private String name;
	private String telephoneNumber;
	private String email;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", telephoneNumber=" + telephoneNumber + ", email=" + email + "]";
	}

	/**
	 * @param name
	 * @param telephoneNumber
	 * @param email
	 */
	public Person(String name, String telephoneNumber, String email) {
		super();
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
