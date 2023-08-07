package com.asha.fruits.Service;

import java.util.List;

import com.asha.fruits.Dto.FruitsDto;

public interface FruitsService {
	
	public String insert(FruitsDto dto);
	
	public FruitsDto readById(Integer id);
	
	public List<FruitsDto> readAll();
	
	public String deleteById(Integer id);
	
	

}
