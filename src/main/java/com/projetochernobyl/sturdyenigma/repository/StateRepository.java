package com.projetochernobyl.sturdyenigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetochernobyl.sturdyenigma.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
