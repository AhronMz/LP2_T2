package com.examenT2.LP2_T2_MezaDavid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_MezaDavid.dto.ResultadoResponse;
import com.examenT2.LP2_T2_MezaDavid.model.OrdenCompraMezaDavid;
import com.examenT2.LP2_T2_MezaDavid.repository.OrdenCompraMezaDavidRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraMezaDavidService {

	private final OrdenCompraMezaDavidRepository ordenCompraMezaDavidRepository;

	public List<OrdenCompraMezaDavid> getAll() {
		return ordenCompraMezaDavidRepository.findAllByOrderByNroOrdenDesc();
	}

	@Transactional
	public ResultadoResponse create(OrdenCompraMezaDavid o) {
		try {
			var registrado = ordenCompraMezaDavidRepository.save(o);
			var mensaje = String.format("Orden de compra Nro. %d registrada", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	public OrdenCompraMezaDavid getOne(Integer nroOrden) {
		return ordenCompraMezaDavidRepository.findById(nroOrden).orElse(null);
	}

	@Transactional
	public ResultadoResponse update(OrdenCompraMezaDavid o) {
		try {
			var registrado = ordenCompraMezaDavidRepository.save(o);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", registrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
