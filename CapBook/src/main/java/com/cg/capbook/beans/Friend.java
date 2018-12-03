package com.cg.capbook.beans;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Friend {
	@Id
	private int friendId;
	public Friend() {
		super();
	}
	public Friend(int friendId) {
		super();
		this.friendId = friendId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + friendId;
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
		return true;
	}
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + "]";
	}
}
