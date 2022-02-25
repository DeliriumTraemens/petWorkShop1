package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString(of = {"id", "name", "creationDate"})
@EqualsAndHashCode(of = {"id"})
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
)
@Table(name = "tema")
public class Tema {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private boolean root=false;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
	
	@JsonIgnore
	@ManyToOne
	private Tema parentTema;
	
	@OneToMany(mappedBy="parentTema")
	private Set<Tema> children = new HashSet<>();
}
