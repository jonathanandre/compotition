package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Succes succes;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateur utilisateur;

}
