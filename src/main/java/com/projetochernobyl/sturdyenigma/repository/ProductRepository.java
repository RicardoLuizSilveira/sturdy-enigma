package com.projetochernobyl.sturdyenigma.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projetochernobyl.sturdyenigma.domain.Category;
import com.projetochernobyl.sturdyenigma.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cat WHERE obj.name LIKE %:name% AND cat IN :categories")
	Page<Product> search(@Param(value = "name") String name, @Param(value = "categories") List<Category> categories, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Page<Product> findDistinctByNameIgnoreCaseContainingAndCategoriesIn(String name, List<Category> categories, Pageable pageRequest);

}
