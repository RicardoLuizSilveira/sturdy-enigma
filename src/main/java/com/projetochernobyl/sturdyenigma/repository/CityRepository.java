package com.projetochernobyl.sturdyenigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetochernobyl.sturdyenigma.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
