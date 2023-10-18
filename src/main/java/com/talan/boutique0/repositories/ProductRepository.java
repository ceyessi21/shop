package com.talan.boutique0.repositories;

import com.talan.boutique0.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p Where p.description like 'ET%'")
    List<Product> getAllProductStartByET();

    @Transactional
    @Modifying
    @Query("DELETE FROM Product WHERE id IN ?1")
    void deleteAllByIds(List<Long> ids);

    @Query("SELECT DISTINCT category From Product")
    public List<String> getAllCategories();
}
