package fr.solutec.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DuelConstraint implements Serializable {

	@SuppressWarnings("unused")
	private Long competition;

	@SuppressWarnings("unused")
	private Long adversaire1;

	@SuppressWarnings("unused")
	private Long adversaire2;

	public DuelConstraint() {
	}
}
