package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Metatable {
	
	@Id
	@Column(name="metatable_id")
	private String metatableId;
	
	@Column(name="metatable_name")
	private String metatableName;

	@OneToMany(mappedBy="metatable", cascade={CascadeType.PERSIST})
	private Set<MetatableValue> metatableValues = new HashSet<MetatableValue>();	
	
	public Metatable() {
	}

	public Metatable(String metatableId, String metatableName) {
		super();
		this.metatableId = metatableId;
		this.metatableName = metatableName;
	}

	public String getMetatableId() {
		return metatableId;
	}

	public void setMetatableId(String metatableId) {
		this.metatableId = metatableId;
	}

	public String getMetatableName() {
		return metatableName;
	}

	public void setMetatableName(String metatableName) {
		this.metatableName = metatableName;
	}

	public Set<MetatableValue> getMetatableValues() {
		return metatableValues;
	}

	public void setMetatableValues(Set<MetatableValue> metatableValues) {
		this.metatableValues = metatableValues;
	}

	public void addMetatableValue(MetatableValue metatableValue) {
		if (metatableValues != null) {
			metatableValues.add(metatableValue);
		}
	}

}
