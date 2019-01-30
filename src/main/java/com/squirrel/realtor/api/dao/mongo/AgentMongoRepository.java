package com.squirrel.realtor.api.dao.mongo;

import com.squirrel.realtor.api.dto.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentMongoRepository extends MongoRepository<Agent, String> {

}