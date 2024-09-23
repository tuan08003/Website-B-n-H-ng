package tuanngpd08863.java6.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import tuanngpd08863.java6.entity.Category;

public interface CategoryDAO extends JpaRepository<Category , String> {

}
