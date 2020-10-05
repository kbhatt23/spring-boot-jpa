package com.learning.jdbcbasics.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//this class acts as entity with JPA implementation using hibernate-> 
//we are adding this for demoing custom row mapper -> when column in table ahve different name than proeprties
//automatic table name will be person_v3
//all instnace propeties are cosnidered as columsn by default
@Entity
@Table(name = "person_v3")
//namde query is based on JPQL whihc uses Java entity names
@NamedQuery(name = "find_all_query", query = "select p from PersonV3 p")
public class PersonV3 {

	//autmatic column name will be person_id
	@Id
	@GeneratedValue
	//@Column(name = "person_id")
	private int personId;
	//autmatic column name will be person_name
	//@Column(name = "person_name")
	private String personName;
	//autmatic column name will be person_address
	//@Column(name = "person_address")
	private String personAddress;
	//autmatic column name will be birth_date
	//@Column(name = "birth_date")
	private Date birthDate;

	public PersonV3() {
		super();
	}
	public PersonV3( String personName, String personAddress, Date birthDate) {
		super();
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
		PersonV3 other = (PersonV3) obj;
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
