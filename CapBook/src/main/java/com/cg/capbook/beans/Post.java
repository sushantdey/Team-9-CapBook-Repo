package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	private int postId;
	private String postName;
	private int noOfPostLikes;
	public Post() {
		super();
	}
	public Post(int postId, String postName, int noOfPostLikes) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.noOfPostLikes = noOfPostLikes;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getNoOfPostLikes() {
		return noOfPostLikes;
	}
	public void setNoOfPostLikes(int noOfPostLikes) {
		this.noOfPostLikes = noOfPostLikes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfPostLikes;
		result = prime * result + postId;
		result = prime * result + ((postName == null) ? 0 : postName.hashCode());
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
		Post other = (Post) obj;
		if (noOfPostLikes != other.noOfPostLikes)
			return false;
		if (postId != other.postId)
			return false;
		if (postName == null) {
			if (other.postName != null)
				return false;
		} else if (!postName.equals(other.postName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName + ", noOfPostLikes=" + noOfPostLikes + "]";
	}
}
