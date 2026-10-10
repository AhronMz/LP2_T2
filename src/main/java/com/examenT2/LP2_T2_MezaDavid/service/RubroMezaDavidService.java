package com.examenT2.LP2_T2_MezaDavid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_MezaDavid.model.RubroMezaDavid;
import com.examenT2.LP2_T2_MezaDavid.repository.RubroMezaDavidRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroMezaDavidService {
	
	private final RubroMezaDavidRepository rubroMezaDavidRepository;
	
	public List<RubroMezaDavid> getAll(){
		return rubroMezaDavidRepository.findAll();
	}
}
