package com.cg.capbook.beans;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Page {
	@Id
	private int pageId;
	private int noOfPageLikes;
	@OneToMany
	private Map<Integer, Post> posts;
	public Page() {
		super();
	}
	public Page(int pageId, int noOfPageLikes, Map<Integer, Post> posts) {
		super();
		this.pageId = pageId;
		this.noOfPageLikes = noOfPageLikes;
		this.posts = posts;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public int getNoOfPageLikes() {
		return noOfPageLikes;
	}
	public void setNoOfPageLikes(int noOfPageLikes) {
		this.noOfPageLikes = noOfPageLikes;
	}
	public Map<Integer, Post> getPosts() {
		return posts;
	}
	public void setPosts(Map<Integer, Post> posts) {
		this.posts = posts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfPageLikes;
		result = prime * result + pageId;
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
		Page other = (Page) obj;
		if (noOfPageLikes != other.noOfPageLikes)
			return false;
		if (pageId != other.pageId)
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
		return "Page [pageId=" + pageId + ", noOfPageLikes=" + noOfPageLikes + ", posts=" + posts + "]";
	}
}
