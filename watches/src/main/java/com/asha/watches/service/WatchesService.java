package com.asha.watches.service;

import java.util.List;

import com.asha.watches.Dto.WatchesDto;

public interface WatchesService {
	
public String insert(WatchesDto dto);
	
	public WatchesDto getById(Integer id);
	
	public List<WatchesDto> getAllWatches();
	
	public String deleteById(Integer id);

}
