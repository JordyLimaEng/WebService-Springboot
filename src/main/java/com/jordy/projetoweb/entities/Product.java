package com.jordy.projetoweb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Implementação da classe Product, representando a organização dos dados na tabela produto no banco de dados H2

@Entity
@Table(name = "produto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	//os annotations especificam que Id será a chave primária da tabela e auto incrementada
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	//referencia para coluna id_categoria
	@Column(name = "id_categoria")
	private Long Id_categoria;

	//referencia para coluna descricao
	@Column(name = "descricao")
	private String descricao;
	
	//a relação implementada aqui foi de que vários produtos serão relacionados com várias categorias e organizados de acordo com produtos
	@ManyToMany(mappedBy = "produtos")
	private Set<Category> categorias = new HashSet<>();

	public Product() {
	}

	public Product(Long id, Long id_categoria, String descricao) {
		super();
		Id = id;
		Id_categoria = id_categoria;
		this.descricao = descricao;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getId_categoria() {
		return Id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		Id_categoria = id_categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCategorias(Set<Category> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Id_categoria == null) ? 0 : Id_categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Product other = (Product) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Id_categoria == null) {
			if (other.Id_categoria != null)
				return false;
		} else if (!Id_categoria.equals(other.Id_categoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}
