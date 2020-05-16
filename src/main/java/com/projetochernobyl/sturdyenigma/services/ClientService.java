package com.projetochernobyl.sturdyenigma.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projetochernobyl.sturdyenigma.domain.Address;
import com.projetochernobyl.sturdyenigma.domain.City;
import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.domain.enums.ClientType;
import com.projetochernobyl.sturdyenigma.dto.ClientDTO;
import com.projetochernobyl.sturdyenigma.dto.ClientNewDTO;
import com.projetochernobyl.sturdyenigma.repository.AddressRepository;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.services.exceptions.DataIntegrityException;
import com.projetochernobyl.sturdyenigma.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository rep;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Client findById(Long id) {
		Optional<Client> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("SIC-6", "Client not found. id: " + id));
	}
	
	public List<Client> findAll() {
		return rep.findAll();
	}
	
	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = rep.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		return obj;
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
	
	public Client fromDto(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getNinOrNif(), ClientType.toEnum(objDto.getType()));
		City city = new City(objDto.getCityId(), null, null);
		Address adr = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getNeighborhood(), objDto.getZipCode(), cli, city); 
		cli.getAddresses().add(adr);
		cli.getPhones().add(objDto.getPhoneNumber1());
		if (objDto.getPhoneNumber2() != null) {
			cli.getPhones().add(objDto.getPhoneNumber2());
		}
		if (objDto.getPhoneNumber3() != null) {
			cli.getPhones().add(objDto.getPhoneNumber3());
		}
		return cli;
	}
}
