package com.cg.capbook.beans;

import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Profile {
	@Id
	private String  emailId;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String userBio;
	//private Image profilePic;
	private String relationshipStatus;
	private String dateOfJoining;
	private String workPlace;
	@ManyToMany
	private Map<Integer, Page> pages;
	@OneToMany
	private Map<Integer, Post> posts;
	@ManyToMany
	private Map<Integer,Friend> friends;
	@Embedded
	private Address address;
	@Embedded
	private Education education;
	public Profile() {
		super();
	}
	public Profile(String emailId, String password, String firstName, String lastName, String dateOfBirth,
			String gender, String userBio, String relationshipStatus, String dateOfJoining, String workPlace,
			Map<Integer, Page> pages, Map<Integer, Post> posts, Map<Integer, Friend> friends, Address address,
			Education education) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.userBio = userBio;
		this.relationshipStatus = relationshipStatus;
		this.dateOfJoining = dateOfJoining;
		this.workPlace = workPlace;
		this.pages = pages;
		this.posts = posts;
		this.friends = friends;
		this.address = address;
		this.education = education;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserBio() {
		return userBio;
	}
	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public Map<Integer, Page> getPages() {
		return pages;
	}
	public void setPages(Map<Integer, Page> pages) {
		this.pages = pages;
	}
	public Map<Integer, Post> getPosts() {
		return posts;
	}
	public void setPosts(Map<Integer, Post> posts) {
		this.posts = posts;
	}
	public Map<Integer, Friend> getFriends() {
		return friends;
	}
	public void setFriends(Map<Integer, Friend> friends) {
		this.friends = friends;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((relationshipStatus == null) ? 0 : relationshipStatus.hashCode());
		result = prime * result + ((userBio == null) ? 0 : userBio.hashCode());
		result = prime * result + ((workPlace == null) ? 0 : workPlace.hashCode());
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
		Profile other = (Profile) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (relationshipStatus == null) {
			if (other.relationshipStatus != null)
				return false;
		} else if (!relationshipStatus.equals(other.relationshipStatus))
			return false;
		if (userBio == null) {
			if (other.userBio != null)
				return false;
		} else if (!userBio.equals(other.userBio))
			return false;
		if (workPlace == null) {
			if (other.workPlace != null)
				return false;
		} else if (!workPlace.equals(other.workPlace))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Profile [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", userBio=" + userBio
				+ ", relationshipStatus=" + relationshipStatus + ", dateOfJoining=" + dateOfJoining + ", workPlace="
				+ workPlace + ", pages=" + pages + ", posts=" + posts + ", friends=" + friends + ", address=" + address
				+ ", education=" + education + "]";
	}
}
