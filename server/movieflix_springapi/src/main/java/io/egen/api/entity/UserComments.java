package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name="UserComments.showComments",query="SELECT c FROM UserComments c where c.showTitle=:title")
})
public class UserComments
{
	@Id
	private String commentId;
	private String uComment;
	
	private String showTitle;
	
	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public UserComments() {
		this.commentId = UUID.randomUUID().toString();
	}
	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getuComment() {
		return uComment;
	}

	public void setuComment(String uComment) {
		this.uComment = uComment;
	}
	

}
