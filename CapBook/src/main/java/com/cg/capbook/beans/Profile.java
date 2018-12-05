package com.cg.capbook.beans;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
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
	private String designation;
	private String currentCity;
	private String homeTown;
	private String highestEducation;
	@ManyToMany
	@MapKey
	private Map<Integer, Page> pages;
	@OneToMany
	@MapKey
	private Map<Integer, Post> posts;

	//private Map<String,Profile>friends;
	//private List<Profile> friends;
	@MapKey
	@OneToMany
	private Map<String, Profile> friends;
	public Profile() {
		super();
	}
	public Profile(String emailId, String password, String firstName, String lastName, String dateOfBirth,
			String gender, String userBio, String relationshipStatus, String dateOfJoining, String workPlace,
			String currentCity, String homeTown, String highestEducation, Map<Integer, Page> pages,
			Map<Integer, Post> posts, Map<String, Profile> friends) {
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
		this.designation = designation;
		this.currentCity = currentCity;
		this.homeTown = homeTown;
		this.highestEducation = highestEducation;
		this.pages = pages;
		this.posts = posts;
		this.friends = friends;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
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
	public Map<String, Profile> getFriends() {
		return friends;
	}
	public void setFriends(Map<String, Profile> friends) {
		this.friends = friends;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentCity == null) ? 0 : currentCity.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((highestEducation == null) ? 0 : highestEducation.hashCode());
		result = prime * result + ((homeTown == null) ? 0 : homeTown.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((relationshipStatus == null) ? 0 : relationshipStatus.hashCode());
		result = prime * result + ((userBio == null) ? 0 : userBio.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
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
		if (currentCity == null) {
			if (other.currentCity != null)
				return false;
		} else if (!currentCity.equals(other.currentCity))
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
		if (highestEducation == null) {
			if (other.highestEducation != null)
				return false;
		} else if (!highestEducation.equals(other.highestEducation))
			return false;
		if (homeTown == null) {
			if (other.homeTown != null)
				return false;
		} else if (!homeTown.equals(other.homeTown))
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
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Profile [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", userBio=" + userBio
				+ ", relationshipStatus=" + relationshipStatus + ", dateOfJoining=" + dateOfJoining + ", workPlace="
				+ designation + ", currentCity=" + currentCity + ", homeTown=" + homeTown + ", highestEducation="
				+ highestEducation + "]";
	}
}
