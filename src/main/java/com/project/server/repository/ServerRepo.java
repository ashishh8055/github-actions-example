package com.project.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.server.entity.ServerInfo;
@Repository
public interface ServerRepo extends MongoRepository<ServerInfo, Integer> {

	@Query("{'name': ?0}")
	List<ServerInfo> getByName(String name);

}
