package com.projetochernobyl.sturdyenigma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.dto.ClientDTO;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.DataIntegrityException;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository rep;
	
	public Client findById(Long id) {
		Optional<Client> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-6", "Client not found. id: " + id));
	}
	
	public List<Client> findAll() {
		return rep.findAll();
	}

	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public void delete(Long id) {
		findById(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("SIC-8745", "Its not possible delete a client that contains orders");
		}
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return rep.findAll(pageRequest);
	}
	
	public Client fromDto(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
}
