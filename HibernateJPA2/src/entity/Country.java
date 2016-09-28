package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="country_name")
	private String countryName;

	@OneToMany(mappedBy="country", cascade={CascadeType.PERSIST})
	private Set<State> states = new HashSet<State>();	
	
	public Country() {
	}

	
	public Country(Integer countryId, String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}


	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Set<State> getStates() {
		return states;
	}


	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	public void addState(State state) {
		if (states != null) {
			states.add(state);
		}
	}
	
}
