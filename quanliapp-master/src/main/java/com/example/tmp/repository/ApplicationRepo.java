package com.example.tmp.repository;

import com.example.tmp.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer> {
    Optional<Application> findApplicationById( Integer id);
    
    @Query("SELECT p FROM Application p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Application> searchApplicationBy(String query);
    
}
