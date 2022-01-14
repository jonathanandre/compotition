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

public class Conversation { // MessagedeGroupe serait un nom plus exact
	@Id
	@GeneratedValue
	private Long id;
	private String contenu;

	@ManyToOne
	private Utilisateur envoyeur;
	@ManyToOne
	private Groupe groupe; // groupe=null si le message est public (dans la conv générale)

}
