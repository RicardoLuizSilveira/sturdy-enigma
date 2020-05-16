package com.projetochernobyl.sturdyenigma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projetochernobyl.sturdyenigma.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Transactional(readOnly = true)
	Optional<Client> findByEmail(String email);
	
}
