package com.cg.capbook.beans;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	private String fromUserId;
	private String toUserId;
	private boolean friendshipStatus;
	/*@MapKey
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "friends")
	private Map<String, Profile> profiles;*/
	@ManyToMany
	@MapKey
	private Map<Integer, Message> messages;
	public Friend() {
		super();
	}
	public Friend(int friendId, String fromUserId, String toUserId) {
		super();
		this.friendId = friendId;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
	}
	public Friend(String toUserId, String fromUserId) {
		this.toUserId=toUserId;
		this.fromUserId=fromUserId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public boolean isFriendshipStatus() {
		return friendshipStatus;
	}
	public void setFriendshipStatus(boolean friendshipStatus) {
		this.friendshipStatus = friendshipStatus;
	}
	/*public Map<String, Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Map<String, Profile> profiles) {
		this.profiles = profiles;
	}*/
	public Map<Integer, Message> getMessages() {
		return messages;
	}
	public void setMessages(Map<Integer, Message> messages) {
		this.messages = messages;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + friendId;
		result = prime * result + (friendshipStatus ? 1231 : 1237);
		result = prime * result + ((fromUserId == null) ? 0 : fromUserId.hashCode());
		result = prime * result + ((messages == null) ? 0 : messages.hashCode());
		//result = prime * result + ((profiles == null) ? 0 : profiles.hashCode());
		result = prime * result + ((toUserId == null) ? 0 : toUserId.hashCode());
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
		Friend other = (Friend) obj;
		if (friendId != other.friendId)
			return false;
		if (friendshipStatus != other.friendshipStatus)
			return false;
		if (fromUserId == null) {
			if (other.fromUserId != null)
				return false;
		} else if (!fromUserId.equals(other.fromUserId))
			return false;
		if (messages == null) {
			if (other.messages != null)
				return false;
		} else if (!messages.equals(other.messages))
			return false;
		/*if (profiles == null) {
			if (other.profiles != null)
				return false;
		} else if (!profiles.equals(other.profiles))
			return false;
		*/if (toUserId == null) {
			if (other.toUserId != null)
				return false;
		} else if (!toUserId.equals(other.toUserId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", fromUserId=" + fromUserId + ", toUserId=" + toUserId
				+ ", friendshipStatus=" + friendshipStatus + "]";
	}
}
