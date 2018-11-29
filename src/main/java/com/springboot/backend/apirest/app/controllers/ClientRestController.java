package com.springboot.backend.apirest.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.app.exceptions.NotFoundException;
import com.springboot.backend.apirest.app.models.dto.ClientDTO;
import com.springboot.backend.apirest.app.models.dto.ResponseClient;
import com.springboot.backend.apirest.app.services.IClientService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClientRestController {

	@Autowired
	private IClientService clientService;

	@GetMapping("/clients")
	public List<ClientDTO> list() {
		return this.clientService.findAll();
	}

	@PostMapping("/client")
	public ClientDTO createClient(@RequestBody ClientDTO client) {
		return this.clientService.save(client);
	}

	@GetMapping("/client/{id}")
	public ClientDTO getClient(@PathVariable String id) throws NotFoundException {
		return this.clientService.get(Long.valueOf(id));
	}

	@PutMapping("/client/{id}")
	public ClientDTO updateClient(@RequestBody ClientDTO client, @PathVariable String id) throws NotFoundException {
		return this.clientService.update(Long.valueOf(id), client);
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<ResponseClient> deleteClient(@PathVariable String id) throws NotFoundException {
		ResponseClient response = new ResponseClient();
		response.setClient(this.clientService.delete(Long.valueOf(id)));
		response.setMessage("Se ha eliminado la entidad");
		
		return new ResponseEntity<ResponseClient>(response, HttpStatus.OK);
	}

}
