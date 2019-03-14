/**
 * 
 */
package touristSystem;

/**
 * @author dell
 *
 */
public class IndividualTourist extends Tourist {

	private Person person;

	/**
	 * @param person
	 *            the person to set
	 */
	public void addPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param iD
	 * @param person
	 */
	public IndividualTourist(String iD, Person person) {
		super(iD);
		this.person = person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IndividualTourist " + person + ", getID()=" + getID() + "]";
	}

}
