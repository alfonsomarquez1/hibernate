package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MetatableValuePK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8124335579643667494L;
	
	@Column(name="metatable_id")
	protected String metatableId;
	@Column(name="metatable_value_id")
	protected String metatableValueId;
	
	public MetatableValuePK() {
	}
	
	public MetatableValuePK(String metatableId, String metatableValueId) {
		super();
		this.metatableId = metatableId;
		this.metatableValueId = metatableValueId;
	}


	public String getMetatableId() {
		return metatableId;
	}

	public void setMetatableId(String metatableId) {
		this.metatableId = metatableId;
	}

	public String getMetatableValueId() {
		return metatableValueId;
	}

	public void setMetatableValueId(String metatableValueId) {
		this.metatableValueId = metatableValueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((metatableId == null) ? 0 : metatableId.hashCode());
		result = prime * result + ((metatableValueId == null) ? 0 : metatableValueId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetatableValuePK other = (MetatableValuePK) obj;
		if (metatableId == null) {
			if (other.metatableId != null)
				return false;
		} else if (!metatableId.equals(other.metatableId))
			return false;
		if (metatableValueId == null) {
			if (other.metatableValueId != null)
				return false;
		} else if (!metatableValueId.equals(other.metatableValueId))
			return false;
		return true;
	}

	
}
