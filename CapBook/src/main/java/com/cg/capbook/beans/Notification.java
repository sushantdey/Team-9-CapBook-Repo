package com.cg.capbook.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int notificationId;
	private String emailId;
	private String notificationMessage;
	private String notificationType;
	private Boolean seenStatus;
	public Notification() {
		super();
	}
	public Notification(int notificationId, String emailId, String notificationMessage, String notificationType,
			Boolean seenStatus) {
		super();
		this.notificationId = notificationId;
		this.emailId = emailId;
		this.notificationMessage = notificationMessage;
		this.notificationType = notificationType;
		this.seenStatus = seenStatus;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public Boolean getSeenStatus() {
		return seenStatus;
	}
	public void setSeenStatus(Boolean seenStatus) {
		this.seenStatus = seenStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + notificationId;
		result = prime * result + ((notificationMessage == null) ? 0 : notificationMessage.hashCode());
		result = prime * result + ((notificationType == null) ? 0 : notificationType.hashCode());
		result = prime * result + ((seenStatus == null) ? 0 : seenStatus.hashCode());
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
		Notification other = (Notification) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (notificationId != other.notificationId)
			return false;
		if (notificationMessage == null) {
			if (other.notificationMessage != null)
				return false;
		} else if (!notificationMessage.equals(other.notificationMessage))
			return false;
		if (notificationType == null) {
			if (other.notificationType != null)
				return false;
		} else if (!notificationType.equals(other.notificationType))
			return false;
		if (seenStatus == null) {
			if (other.seenStatus != null)
				return false;
		} else if (!seenStatus.equals(other.seenStatus))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", emailId=" + emailId + ", notificationMessage="
				+ notificationMessage + ", notificationType=" + notificationType + ", seenStatus=" + seenStatus + "]";
	}
}
