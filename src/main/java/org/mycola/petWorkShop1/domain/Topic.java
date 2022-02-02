package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	private Long parentTop;
	
	private String image;
	
	private boolean root=false;
	private boolean active=true;
	
	@JsonIgnore
	@ManyToOne
	private Topic parTop;
	
	@OneToMany(mappedBy="parTop", cascade = CascadeType.ALL)
	private Set<Topic>children = new HashSet<>();
	
	@OneToMany(mappedBy="artTopic")
	private Set <Article> articleSet=new HashSet<>();
	
	
}
