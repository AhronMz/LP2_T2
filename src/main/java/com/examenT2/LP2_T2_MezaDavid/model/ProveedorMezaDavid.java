package com.examenT2.LP2_T2_MezaDavid.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_proveedor")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@DynamicInsert

public class ProveedorMezaDavid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	private Integer idProveedor;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="fecha_registro")
	private LocalDateTime fechaRegistro;
	
	@Column(name="direccion")
	private String direccion;	
	
	@Column(name="pagina_web")
	private String paginaWeb;
	
	@JoinColumn(name = "id_rubro")
	@ManyToOne
	private RubroMezaDavid rubro;
}