package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreationPari { // cette classe aurait pu fusionner avec competition (1 attribut descriptionpari
							// dans competition)
	@Id // il n'y a pas de contrainte mais il ne doit pas y avoir 2 creation de pari
		// pour une même compétition
	@GeneratedValue
	private Long id;
	private String description;
	@ManyToOne
	private Competition competition;

}
