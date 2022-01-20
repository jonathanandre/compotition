package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(VotePariConstraint.class)
public class VotePari {
	@Id
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Competition competition;
	@Id
	@ManyToOne
	private Utilisateur predicteur;
	@ManyToOne
	private Utilisateur favori;
	private int remuneration;

}
