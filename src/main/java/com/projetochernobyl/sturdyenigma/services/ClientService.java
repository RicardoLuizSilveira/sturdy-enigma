package com.projetochernobyl.sturdyenigma.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository rep;
	
	public Client findById(Long id) {
		Optional<Client> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-6", "Client not found. id: " + id));
	}
}
