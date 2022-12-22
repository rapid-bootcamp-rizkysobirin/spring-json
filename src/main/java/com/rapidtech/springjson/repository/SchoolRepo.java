package com.rapidtech.springjson.repository;

import com.rapidtech.springjson.entity.AddressEntity;
import com.rapidtech.springjson.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<SchoolEntity, Long> {
}
