package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String city;
	private String state;
	@Column(name="YEAR_ESTABLISHED")
	private int yearEstablished;
	
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venue(String name, String city, String state, int yearEstablished) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.yearEstablished = yearEstablished;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the yearEstablished
	 */
	public int getYearEstablished() {
		return yearEstablished;
	}

	/**
	 * @param yearEstablished the yearEstablished to set
	 */
	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", yearEstablished="
				+ yearEstablished + "]";
	}
	

}
