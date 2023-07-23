package com.asha.watches.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asha.watches.Dto.WatchesDto;
import com.asha.watches.Repo.WatchesRepo;

@Service
public class WatchesServiceImpl implements WatchesService {

	@Autowired
	private WatchesRepo repo;

	@Override
	public String insert(WatchesDto dto) {
		repo.save(dto);

		return "success";
	}

	@Override
	public WatchesDto getById(Integer id) {

		Optional<WatchesDto> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}

		return null;
	}

	@Override
	public List<WatchesDto> getAllWatches() {
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "found and deleted sucessfully";

		}

		return "no record found";

	}
}