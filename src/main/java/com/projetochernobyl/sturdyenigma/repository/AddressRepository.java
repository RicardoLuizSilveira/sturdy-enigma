package com.projetochernobyl.sturdyenigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetochernobyl.sturdyenigma.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
