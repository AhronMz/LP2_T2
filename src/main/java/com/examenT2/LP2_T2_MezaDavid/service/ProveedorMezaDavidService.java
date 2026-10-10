package com.examenT2.LP2_T2_MezaDavid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_MezaDavid.model.ProveedorMezaDavid;
import com.examenT2.LP2_T2_MezaDavid.repository.ProveedorMezaDavidRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorMezaDavidService {
	
	private final ProveedorMezaDavidRepository proveedorMezaDavidRepository;
	
	public List<ProveedorMezaDavid> getAll() {
		return proveedorMezaDavidRepository.findAll();
	}
}
