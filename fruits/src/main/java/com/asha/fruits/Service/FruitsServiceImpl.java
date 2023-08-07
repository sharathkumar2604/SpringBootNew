package com.asha.fruits.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asha.fruits.Dto.FruitsDto;
import com.asha.fruits.Repositary.FruitsRepo;
import com.asha.fruits.customException.BusinessException;

@Service
public class FruitsServiceImpl implements FruitsService {

	@Autowired
	private FruitsRepo repo;

	@Override
	public String insert(FruitsDto dto) {
		try {
			if(dto.getName().length()<2)
			{
				throw new BusinessException("901","the name is very short");
			}else {
			
			repo.save(dto);
			return "success";
		}
		}
		catch (Exception e) {
throw new BusinessException("902","the dto is null"+e.getMessage());
		}
	}

	@Override
	public FruitsDto readById(Integer id) {
		Optional<FruitsDto> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;

	}

	@Override
	public List<FruitsDto> readAll() {
try {
		List<FruitsDto> fruitsList = repo.findAll();
		if(fruitsList.isEmpty())
		
		throw new BusinessException("903","nothing is there to print,please do add some and start retrieve");
		return fruitsList;
}

		catch (Exception e) {
			throw new BusinessException("904","Something went wrong in service layer while feetching all fruits"+e.getMessage());
			
		}

}
	

	@Override
	public String deleteById(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "found and deleted";
		}
		return "no record found";
	}

}
