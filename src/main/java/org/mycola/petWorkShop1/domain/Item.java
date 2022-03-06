package org.mycola.petWorkShop1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(of = {"id", "name", "creationDate"})
@EqualsAndHashCode(of = {"id"})
@JsonIdentityInfo(
		generator= ObjectIdGenerators.PropertyGenerator.class,
		property="id")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	
	private Type type = Type.ITEM;
	
	private String image;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creationDate;
	
	@ManyToOne
	private Tema tema;
}
