package com.leantaas.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nithya Kogaleru Entity for projector DB object model.
 *
 */
@Entity
@Table(name = "projectors")
public class Projector implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projector", cascade = CascadeType.ALL)
	private Set<ProjectorManagement> projectorManagement;

	public Set<ProjectorManagement> getProjectorManagement() {
		return projectorManagement;
	}

	public void setProjectorManagement(Set<ProjectorManagement> projectorManagement) {
		this.projectorManagement = projectorManagement;
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
}
