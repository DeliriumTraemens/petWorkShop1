package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	
	@JsonIgnore
	@ManyToOne
	private Article article;
	
	@JsonIgnore
	@ManyToOne
	private Author author;
}
