package com.asha.watches.Repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asha.watches.Dto.WatchesDto;

@Repository
public interface WatchesRepo extends JpaRepository<WatchesDto, Serializable>{

}
