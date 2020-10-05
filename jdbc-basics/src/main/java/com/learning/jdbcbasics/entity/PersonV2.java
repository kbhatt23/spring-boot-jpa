package com.learning.jdbcbasics.entity;

import java.util.Date;
//this class acts as entity without JPA -> 
//we are adding this for demoing custom row mapper -> when column in table ahve different name than proeprties
public class PersonV2 {

	private int personId;
	private String personName;
	private String personAddress;
	private Date birthDate;

	public PersonV2() {
		super();
	}
	public PersonV2(int personId, String personName, String personAddress, Date birthDate) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAddress = personAddress;
		this.birthDate = birthDate;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "PersonV2 [personId=" + personId + ", personName=" + personName + ", personAddress=" + personAddress
				+ ", birthDate=" + birthDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((personAddress == null) ? 0 : personAddress.hashCode());
		result = prime * result + personId;
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
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
		PersonV2 other = (PersonV2) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (personAddress == null) {
			if (other.personAddress != null)
				return false;
		} else if (!personAddress.equals(other.personAddress))
			return false;
		if (personId != other.personId)
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}
	
}
