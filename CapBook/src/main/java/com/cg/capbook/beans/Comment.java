package com.cg.capbook.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;
@Entity
@Table(name="Post_Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int commentId;
	private String commentContent;
	private String commentPerson;
	@ManyToOne
	@MapKey
	@JoinColumn(name="postId")
	private Post posts;
	public Comment() {
		super();
	}
	public Comment(int commentId, String commentContent, String commentPerson, Post posts) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentPerson = commentPerson;
		this.posts = posts;
	}
	public final int getCommentId() {
		return commentId;
	}
	public final void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public final String getCommentContent() {
		return commentContent;
	}
	public final void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public final String getCommentPerson() {
		return commentPerson;
	}
	public final void setCommentPerson(String commentPerson) {
		this.commentPerson = commentPerson;
	}
	public final Post getPosts() {
		return posts;
	}
	public final void setPosts(Post posts) {
		this.posts = posts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + commentId;
		result = prime * result + ((commentPerson == null) ? 0 : commentPerson.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
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
		Comment other = (Comment) obj;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentId != other.commentId)
			return false;
		if (commentPerson == null) {
			if (other.commentPerson != null)
				return false;
		} else if (!commentPerson.equals(other.commentPerson))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentPerson="
				+ commentPerson + "]";
	}
}
