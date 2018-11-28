package com.springboot.backend.apirest.app.services;

import java.util.List;

import com.springboot.backend.apirest.app.models.dto.ClientDTO;

public interface IClientService {

	public List<ClientDTO> findAll();

	public ClientDTO save(ClientDTO client);

	public ClientDTO get(Long id);

	public ClientDTO update(Long id, ClientDTO client);

}
