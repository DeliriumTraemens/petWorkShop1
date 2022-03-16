package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString(of = {"id", "name", "creationDate"})
@EqualsAndHashCode(of = {"id"})
@JsonIdentityInfo(
		generator= ObjectIdGenerators.PropertyGenerator.class,
		property="id"
)
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
	
	private Type type = Type.TOPIC;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
	
	@JsonIgnore
	@ManyToOne
	private Topic parTop;
	
	@OneToMany(mappedBy="parTop", cascade = CascadeType.ALL)
	private Set<Topic>children = new HashSet<>();
	
	@OneToMany(mappedBy="artTopic")
	@OrderBy("id DESC ")
	private Set <Article> articleSet=new HashSet<>();
	
	
}
