package com.jordy.projetoweb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//Implementação da classe Category, representando a organização dos dados na tabela categoria no banco de dados H2
@Entity
@Table(name = "categoria")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	//os annotations especificam que Id será a chave primária da tabela e auto incrementada
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	//referencia para coluna categoria
	@Column(name = "categoria")
	private String categoria;
	
	//no banco de dados foi criada uma tabela para relacionar as chaves primarias de produto e categoria, implementando o conceito de chaves estrangeiras
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "prod_cat",//tabela de relações
				joinColumns = @JoinColumn(name = "Id"),//ID de produto é relacionado com...
				inverseJoinColumns = @JoinColumn(name = "categoria_id"))//a categoria do mesmo produto, ou seja, ao retornar uma requisição Produto 
																		//é exibido juntamente com sua categoria
	private Set<Product> produtos = new HashSet<>();

	public Category() {
	}

	public Category(Long id, String categoria) {
		super();
		Id = id;
		this.categoria = categoria;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setProdutos(Set<Product> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Category other = (Category) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
