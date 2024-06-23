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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {
	@Id
	@Column(name = "dni_empleado",
	columnDefinition = "CHAR(8)",
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
	
	@ManyToOne
	@JoinColumn(name = "area_id",
				nullable = false)
	private AreaEntity area;
}
