package com.dylproject.model;

import java.util.Date;

public class Vacante {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fechaPub;
	private Double salario;
	private Integer destacado;
	private String imagen = "no-image.png";
	
	
	public Vacante() {}

	

	public Vacante(Integer id, String nombre, String descripcion, Date fechaPub, Double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaPub = fechaPub;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaPub() {
		return fechaPub;
	}


	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}

	

	public Integer getDestacado() {
		return destacado;
	}



	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}

	

	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaPub=" + fechaPub
				+ ", salario=" + salario + ", destacado=" + destacado+"]";
	}
	
	
}
