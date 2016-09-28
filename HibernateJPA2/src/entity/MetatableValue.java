package entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MetatableValue")
public class MetatableValue {
	
	@EmbeddedId
	private MetatableValuePK key;
	
	@Column(name="metatable_name")
	private String metatableName;
	
	@ManyToOne
	@JoinColumn(name="metatable_id", insertable=false, updatable=false)
	private Metatable metatable;
	
	public MetatableValue() {
	}

	public MetatableValue(MetatableValuePK key, String metatableName) {
		this.key = key;
		this.metatableName = metatableName;
	}

	public MetatableValuePK getKey() {
		return key;
	}

	public void setKey(MetatableValuePK key) {
		this.key = key;
	}

	public String getMetatableName() {
		return metatableName;
	}

	public void setMetatableName(String metatableName) {
		this.metatableName = metatableName;
	}

	public Metatable getMetatable() {
		return metatable;
	}

	public void setMetatable(Metatable metatable) {
		this.metatable = metatable;
	}

	
	
}
