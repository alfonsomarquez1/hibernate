package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(StatePK.class)
public class State {

	@Id
	@Column(name="country_id")
	private Integer countryId;
	
	@Id
	@Column(name="state_id")
	private Integer stateId;
	
	@Column(name="state_name")
	private String name;

	@ManyToOne
	@JoinColumn(name="country_id", insertable=false, updatable=false)
	private Country country;
	
	public State() {
	}
	
	public State(Integer countryId, Integer stateId, String name) {
		this.countryId = countryId;
		this.stateId = stateId;
		this.name = name;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}

