package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity 
@NamedQueries({
	@NamedQuery(name="Genre.findType",query="SELECT e FROM Genre e where e.gType=:pType"),
	@NamedQuery(name="Genre.findAllGenre",query="SELECT e FROM Genre e")	
})
public class Genre 
{
	@Id
	private String gId;
	@Column(unique=true)
	private String gType;
	
	public Genre() {
		this.gId = UUID.randomUUID().toString();
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getgType() {
		return gType;
	}

	public void setgType(String gType) {
		this.gType = gType;
	}
}
