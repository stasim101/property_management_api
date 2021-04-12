package com.upwork.propman.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upwork.propman.model.ApiKey;

@Repository
public interface ApiKeyRepository extends CrudRepository<ApiKey, Integer> {

	Optional<ApiKey> findByKey(String key);

}
