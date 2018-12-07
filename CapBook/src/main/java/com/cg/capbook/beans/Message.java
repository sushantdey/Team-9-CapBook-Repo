package com.cg.capbook.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
@Entity
public class Message{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int messageId;
	private String senderEmailId;
	private String receiverEmailId;
	private String message;
	@ManyToOne 
	@MapKey
	@JoinColumn(name="friendId")
	private Friend friend;
	public Message() {
		super();
	}
	public Message(int messageId, String senderEmailId, String receiverEmailId, String message) {
		super();
		this.messageId = messageId;
		this.senderEmailId = senderEmailId;
		this.receiverEmailId = receiverEmailId;
		this.message = message;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + messageId;
		result = prime * result + ((receiverEmailId == null) ? 0 : receiverEmailId.hashCode());
		result = prime * result + ((senderEmailId == null) ? 0 : senderEmailId.hashCode());
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
		Message other = (Message) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageId != other.messageId)
			return false;
		if (receiverEmailId == null) {
			if (other.receiverEmailId != null)
				return false;
		} else if (!receiverEmailId.equals(other.receiverEmailId))
			return false;
		if (senderEmailId == null) {
			if (other.senderEmailId != null)
				return false;
		} else if (!senderEmailId.equals(other.senderEmailId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", senderEmailId=" + senderEmailId + ", receiverEmailId="
				+ receiverEmailId + ", message=" + message + "]";
	}
}
