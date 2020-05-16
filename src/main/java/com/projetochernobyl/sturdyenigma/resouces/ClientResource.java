package com.projetochernobyl.sturdyenigma.resouces;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.dto.ClientDTO;
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
	
//	@PostMapping
//	public ResponseEntity<Void> insert(@Valid @RequestBody ClientDTO objDto){
//		Client obj = service.fromDto(objDto);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<Client>> updateClient(@PathVariable(value = "id") Long id, @Valid @RequestBody ClientDTO objDto) {
		ResponseDTO<Client> data = new ResponseDTO<>();
		Client obj = service.fromDto(objDto);
		obj.setId(id);
		data.setData(service.update(obj));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<ClientDTO>>> findAll() {
		ResponseDTO<List<ClientDTO>> data = new ResponseDTO<>();
		List<Client> list = service.findAll();
		List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		data.setData(listDto);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<ResponseDTO<Page<ClientDTO>>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		ResponseDTO<Page<ClientDTO>> data = new ResponseDTO<>();
		Page<Client> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<ClientDTO> listDto = list.map(x -> new ClientDTO(x));
		data.setData(listDto);
		return ResponseEntity.ok(data);
	}
}
