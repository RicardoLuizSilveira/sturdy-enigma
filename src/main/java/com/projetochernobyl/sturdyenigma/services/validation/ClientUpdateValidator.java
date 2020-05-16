package com.projetochernobyl.sturdyenigma.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.projetochernobyl.sturdyenigma.domain.Client;
import com.projetochernobyl.sturdyenigma.dto.ClientDTO;
import com.projetochernobyl.sturdyenigma.repository.ClientRepository;
import com.projetochernobyl.sturdyenigma.resouces.exceptions.FieldMessage;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClientDTO> {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private ClientRepository repo;

	@Override
	public boolean isValid(ClientDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		
		Optional<Client> opt = repo.findByEmail(objDto.getEmail());
		if (opt.isPresent() && !opt.get().getId().equals(uriId)) {
			list.add(new FieldMessage("email", "This field already exist"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
