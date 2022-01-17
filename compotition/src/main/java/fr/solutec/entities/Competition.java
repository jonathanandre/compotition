package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
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
public class Competition {
	@Id
	@GeneratedValue
	private Long id;
	private String activite;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	private Date limiteInscription;
	private String format;
	private String description;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean pari;
	@ManyToOne
	private Groupe groupe;
}
