package com.projetochernobyl.sturdyenigma.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.projetochernobyl.sturdyenigma.domain.enums.ClientType;
import com.projetochernobyl.sturdyenigma.dto.ClientNewDTO;
import com.projetochernobyl.sturdyenigma.resouces.exceptions.FieldMessage;
import com.projetochernobyl.sturdyenigma.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (ClientType.NATURAL_PERSON.getCode().equals(objDto.getType()) && !BR.isValidCPF(objDto.getNinOrNif())) {
			list.add(new FieldMessage("ninOrNif", "NIN is not valid"));
		}
		if (ClientType.JURIDICAL_PERSON.getCode().equals(objDto.getType()) && !BR.isValidCNPJ(objDto.getNinOrNif())) {
			list.add(new FieldMessage("ninOrNif", "NIF is not valid"));
		}
		if (objDto.getCityId() == null) {
			list.add(new FieldMessage("cityId", "Field should not be empty"));
		}
		if (objDto.getType() == null) {
			list.add(new FieldMessage("type", "Field should not be empty"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
