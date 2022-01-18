package fr.solutec.entities;

import java.util.Date;

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
//@IdClass(DuelConstraint.class)
public class Duel {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Competition competition;

	@ManyToOne
	private Utilisateur adversaire1;

	@ManyToOne
	private Utilisateur adversaire2;

	private Date date;
	private int scoreAdversaire1;
	private int scoreAdversaire2;
}
