package com.fatec.G2scm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.br.CPF;

/**
 * @author Emerson Rodrigues da Costa
 *
 */
@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CPF(message = "CPF inválido")
	@Column(unique = true) // nao funciona com @Valid tem que tratar na camada de persistencia
	private String cpfCliente;

	@NotNull
	@Size(min = 1, max = 50, message = "Nome deve ser preenchido")
	private String nomeCliente;

	@NotNull
	@Size(min = 2, max = 2)
	private String turmaCurso;

	public Matricula() {

	}

	public Matricula(Long id, String cpfCliente, String nomeCliente, String turmaCurso) {
		super();
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.turmaCurso = turmaCurso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTurmaCurso() {
		return turmaCurso;
	}

	public void setTurmaCurso(String turmaCurso) {
		this.turmaCurso = turmaCurso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (cpfCliente == null) {
			if (other.cpfCliente != null)
				return false;
		} else if (!cpfCliente.equals(other.cpfCliente))
			return false;

		if (turmaCurso == null) {
			if (other.turmaCurso != null)
				return false;
		} else if (!turmaCurso.equals(other.turmaCurso))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", cpfCliente=" + cpfCliente + ", turmaCurso=" + turmaCurso + "]";
	}
}