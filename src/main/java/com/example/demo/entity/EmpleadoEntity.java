package com.example.demo.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpleadoEntity {
	@Id
	@Column(name = "dni_empleado",
	nullable = false,
	unique = true)
	private Integer dniEmpleado;

	@Column(name = "nombre_empleado",
			columnDefinition = "VARCHAR(45)",
			nullable = false)
	private String nomEmpleado;

	@Column(name = "apellido_empleado",
			columnDefinition = "VARCHAR(45)",
			nullable = false)
	private String apeEmpleado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecNacimiento;

	@Column(name = "direccion",
			columnDefinition = "VARCHAR(45)",
			nullable = false)
	private String dirEmpleado;

	@Column(name = "correo",
			columnDefinition = "VARCHAR(45)",
			nullable = false,
			unique = true)
	private String corEmpleado;
	
	
	
	public Integer getDniEmpleado() {
		return dniEmpleado;
	}



	public void setDniEmpleado(Integer dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}



	public String getNomEmpleado() {
		return nomEmpleado;
	}



	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}



	public String getApeEmpleado() {
		return apeEmpleado;
	}



	public void setApeEmpleado(String apeEmpleado) {
		this.apeEmpleado = apeEmpleado;
	}



	public Date getFecNacimiento() {
		return fecNacimiento;
	}



	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}



	public String getDirEmpleado() {
		return dirEmpleado;
	}



	public void setDirEmpleado(String dirEmpleado) {
		this.dirEmpleado = dirEmpleado;
	}



	public String getCorEmpleado() {
		return corEmpleado;
	}



	public void setCorEmpleado(String corEmpleado) {
		this.corEmpleado = corEmpleado;
	}



	public AreaEntity getArea() {
		return area;
	}



	public void setArea(AreaEntity area) {
		this.area = area;
	}



	@ManyToOne
	@JoinColumn(name = "area_id",
				nullable = false)
	private AreaEntity area;
}
