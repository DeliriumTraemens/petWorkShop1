package org.mycola.petWorkShop1.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String surname;
	private String email;
	private String userpic;
	
	@OneToMany(mappedBy="author")
	private Set<Article>articleSet = new HashSet<>();
	
	@OneToMany(mappedBy="author")
	private Set<Comment>commentSet = new HashSet<>();
}
