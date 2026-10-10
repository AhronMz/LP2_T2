package com.examenT2.LP2_T2_MezaDavid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.LP2_T2_MezaDavid.model.OrdenCompraMezaDavid;

public interface OrdenCompraMezaDavidRepository extends JpaRepository<OrdenCompraMezaDavid, Integer> {
	
	List<OrdenCompraMezaDavid> findAllByOrderByNroOrdenDesc();
}
