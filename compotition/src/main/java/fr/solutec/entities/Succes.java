package fr.solutec.entities;

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

	private String succes1;
	private String succes2;
	private String succes3;
	private String succes4;
	private String succes5;
	private String succes6;
	private String succes7;
	private String succes8;
	private String succes9;
	private String succes10;

}
