 package com.asha.fruits.Repositary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asha.fruits.Dto.FruitsDto;

@Repository
public interface FruitsRepo extends JpaRepository<FruitsDto,Serializable>{

	
}
