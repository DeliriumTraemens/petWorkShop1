package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	
	@JsonIgnore
	@ManyToOne
	private Topic artTopic;
	
	@OneToMany(mappedBy="article")
	private Set <Comment> commentSet = new HashSet<>();
	
	@ManyToOne
	private Author author;
}
