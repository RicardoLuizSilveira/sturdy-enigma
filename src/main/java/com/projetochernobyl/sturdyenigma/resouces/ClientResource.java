package com.projetochernobyl.sturdyenigma.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.resouces.responses.ResponseDTO;
import com.projetochernobyl.sturdyenigma.services.ClientService;

@RestController
@RequestMapping(value = "/api/v1/clients")
public class ClientResource {
	
	@Autowired
	ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<Client>> findById(@PathVariable(value = "id") Long id) {
		ResponseDTO<Client> responseDto = new ResponseDTO<>();
		Client obj = service.findById(id);
		responseDto.setData(obj);
		return ResponseEntity.ok(responseDto);
		
	}
}
