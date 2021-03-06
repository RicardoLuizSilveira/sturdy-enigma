package com.projetochernobyl.sturdyenigma.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sic_product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "sic_product_category",
			joinColumns = 
				@JoinColumn(name = "product_id", referencedColumnName = "id"),
			inverseJoinColumns = 
				@JoinColumn(name = "category_id", referencedColumnName = "id")
		)
	private List<Category> categories = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> itens = new HashSet<>();
	
	public Product() {
	}

	public Product(Long id, String name, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		categories.add(category);
	}
	
	@JsonIgnore
	public List<Order> getOrders() {
		List<Order> list = new ArrayList<>();
		itens.stream().map(x -> list.add(x.getOrder()));
		return list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public Set<OrderItem> getItens() {
		return itens;
	}

	public void setItens(Set<OrderItem> orders) {
		this.itens = orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
