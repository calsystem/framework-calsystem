package br.com.calcard.framework_calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class CalsystemEntity implements Serializable {

	private static final long serialVersionUID = -1987985993444509435L;

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_STATUS = "status";
	public static final String COLUNA_DATA_REGISTRO = "data_registro";
	public static final String COLUNA_DATA_ATUALIZACAO = "data_atualizacao";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COLUNA_ID, length = 6, nullable = false, unique = true)
	protected Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_REGISTRO, unique = false, nullable = false)
	protected Date dataRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_ATUALIZACAO, unique = false, nullable = false)
	protected Date dataAtualizacao;

	public CalsystemEntity() {
		super();

		this.dataAtualizacao = new Date();
		this.dataRegistro = new Date();
	}

	public CalsystemEntity(Integer id, Date dataRegistro, Date dataAtualizacao) {
		super();
		this.id = id;
		this.dataRegistro = dataRegistro;
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result
				+ ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalsystemEntity other = (CalsystemEntity) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}