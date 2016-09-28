package entity;

import java.io.Serializable;

//@Embeddable
public class StatePK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8124335579643667494L;

//	@Column(name="country_id")
	protected Integer countryId;
//	@Column(name="state_id")
	protected Integer stateId;
	
	public StatePK() {
	}

	public StatePK(Integer countryId, Integer stateId) {
		this.countryId = countryId;
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		return countryId * 1000_000_000 + stateId * 10_000 ;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (!(obj instanceof StatePK)) {
	    		return false;
	    }
		
	    final StatePK other = (StatePK) obj;
	   
	    if (this.countryId == null || other.countryId == null ||
	    		this.stateId == null || other.stateId == null){
	    		return false;
	    }
	    
	    if (this.countryId != other.countryId ||
	    		this.stateId != other.stateId) {
    			return false;
	    }
	    
	    return true;
	}
	
	
}
