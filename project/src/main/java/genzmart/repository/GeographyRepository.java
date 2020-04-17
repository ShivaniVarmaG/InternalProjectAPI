package genzmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genzmart.model.Geography;

@Repository
public interface GeographyRepository extends JpaRepository<Geography, Long>{
	
	@Query(value = "SELECT city FROM geography", nativeQuery = true)
	List findAllByCity();

}
