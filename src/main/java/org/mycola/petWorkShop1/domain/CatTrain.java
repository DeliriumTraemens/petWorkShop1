package org.mycola.petWorkShop1.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class CatTrain {
	@Id
	private Long id;
	private String name;
	
	private Long parId;
	
	@ManyToOne
	private CatTrain parent;
	
	@OneToMany
	private Set<CatTrain> children;
	
	//Constr
	
	
	public CatTrain() {
	}
	
	public CatTrain(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CatTrain(Long id, String name, Long parId) {
		this.id = id;
		this.name = name;
		this.parId = parId;
	}
	//GetSet
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getParId() {
		return parId;
	}
	
	public void setParId(Long parId) {
		this.parId = parId;
	}
	
	public CatTrain getParent() {
		return parent;
	}
	
	public void setParent(CatTrain parent) {
		this.parent = parent;
	}
	
	public Set<CatTrain> getChildren() {
		return children;
	}
	
	public void setChildren(Set<CatTrain> children) {
		this.children = children;
	}
	
	//EqHc
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CatTrain catTrain = (CatTrain) o;
		return getId().equals(catTrain.getId()) &&
				       getName().equals(catTrain.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}
	
	@Override
	public String toString() {
		return "CatTrain{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       ", parId=" + parId +
				       ", children=" + children +
				       '}';
	}
}
