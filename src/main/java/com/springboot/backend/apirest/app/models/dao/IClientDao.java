package com.springboot.backend.apirest.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.apirest.app.models.entity.ClientEntity;

public interface IClientDao extends CrudRepository<ClientEntity, Long> {

}
