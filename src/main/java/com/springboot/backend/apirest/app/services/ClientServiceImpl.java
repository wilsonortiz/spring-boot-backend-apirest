package com.springboot.backend.apirest.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.backend.apirest.app.exceptions.NotFoundException;
import com.springboot.backend.apirest.app.models.dao.IClientDao;
import com.springboot.backend.apirest.app.models.dto.ClientDTO;
import com.springboot.backend.apirest.app.models.entity.ClientEntity;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ClientDTO> findAll() {
		List<ClientDTO> response = new ArrayList<ClientDTO>();

		if (this.clientDao.findAll() != null)
			for (ClientEntity source : this.clientDao.findAll()) {
				response.add(this.modelMapper.map(source, ClientDTO.class));
			}

		return response;
	}

	@Override
	public ClientDTO save(ClientDTO client) {

		ClientEntity clientEntity = this.modelMapper.map(client, ClientEntity.class);
		this.clientDao.save(clientEntity);
		return this.modelMapper.map(clientEntity, ClientDTO.class);
	}

	@Override
	public ClientDTO get(Long id) {
		Optional<ClientEntity> client = this.clientDao.findById(id);

		if (!client.isPresent())
			throw new NotFoundException("id-" + id);

		return this.modelMapper.map(client.get(), ClientDTO.class);
	}

	@Override
	public ClientDTO update(Long id, ClientDTO client) {

		Optional<ClientEntity> clientEntity = this.clientDao.findById(id);

		if (clientEntity.isPresent()) {
			client.setId(clientEntity.get().getId());
			return this.save(client);

		} else {
			throw new NotFoundException("id-" + id);
		}
	}

}
