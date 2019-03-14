/**
 * 
 */
package touristSystem;

/**
 * @author dell
 *
 */
public class Tourist {
	private String ID;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tourist [ID=" + ID + "]";
	}

	/**
	 * @param iD
	 */
	public Tourist(String iD) {
		super();
		ID = iD;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

}
