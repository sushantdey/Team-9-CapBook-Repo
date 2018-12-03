package com.cg.capbook.beans;
import javax.persistence.Embeddable;
@Embeddable
public class Education {
	private String highSchool;
	private String intermediate;
	private String graduation;
	private String postGraduation;
	public Education() {
		super();
	}
	public Education(String highSchool, String intermediate, String graduation, String postGraduation) {
		super();
		this.highSchool = highSchool;
		this.intermediate = intermediate;
		this.graduation = graduation;
		this.postGraduation = postGraduation;
	}
	public String getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	public String getIntermediate() {
		return intermediate;
	}
	public void setIntermediate(String intermediate) {
		this.intermediate = intermediate;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getPostGraduation() {
		return postGraduation;
	}
	public void setPostGraduation(String postGraduation) {
		this.postGraduation = postGraduation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((graduation == null) ? 0 : graduation.hashCode());
		result = prime * result + ((highSchool == null) ? 0 : highSchool.hashCode());
		result = prime * result + ((intermediate == null) ? 0 : intermediate.hashCode());
		result = prime * result + ((postGraduation == null) ? 0 : postGraduation.hashCode());
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
		Education other = (Education) obj;
		if (graduation == null) {
			if (other.graduation != null)
				return false;
		} else if (!graduation.equals(other.graduation))
			return false;
		if (highSchool == null) {
			if (other.highSchool != null)
				return false;
		} else if (!highSchool.equals(other.highSchool))
			return false;
		if (intermediate == null) {
			if (other.intermediate != null)
				return false;
		} else if (!intermediate.equals(other.intermediate))
			return false;
		if (postGraduation == null) {
			if (other.postGraduation != null)
				return false;
		} else if (!postGraduation.equals(other.postGraduation))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Education [highSchool=" + highSchool + ", intermediate=" + intermediate + ", graduation=" + graduation
				+ ", postGraduation=" + postGraduation + "]";
	}
}
