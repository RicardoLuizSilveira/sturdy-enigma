package com.projetochernobyl.sturdyenigma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetochernobyl.sturdyenigma.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
