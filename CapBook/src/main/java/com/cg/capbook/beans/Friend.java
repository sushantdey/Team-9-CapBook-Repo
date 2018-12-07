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
	@MapKey
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
    mappedBy = "friends")
	private Map<String, Profile> profiles;
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
}
