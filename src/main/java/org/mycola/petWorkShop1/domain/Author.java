package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
}
