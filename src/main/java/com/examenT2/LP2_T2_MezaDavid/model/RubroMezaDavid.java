package com.examenT2.LP2_T2_MezaDavid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_rubro")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class RubroMezaDavid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rubro")
	private Integer idRubro;

	@Column(name = "denominacion")
	private String denominacion;
}
