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
public class SuccesUtilisateur {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Succes succes;

	@ManyToOne
	private Utilisateur utilisateur;

}
