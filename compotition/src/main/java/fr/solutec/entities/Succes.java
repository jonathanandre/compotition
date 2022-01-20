package fr.solutec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Succes {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String libelle;

}
