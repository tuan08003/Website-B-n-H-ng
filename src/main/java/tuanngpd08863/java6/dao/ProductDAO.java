package tuanngpd08863.java6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tuanngpd08863.java6.entity.Product;

public interface ProductDAO extends JpaRepository<Product , Integer> {

	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryid(String cid);

}
