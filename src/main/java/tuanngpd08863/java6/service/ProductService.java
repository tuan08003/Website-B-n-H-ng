package tuanngpd08863.java6.service;

import java.util.List;


import tuanngpd08863.java6.entity.Product;

public interface ProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void deleteAllById(List<Integer> ids);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Product findById(Integer id);

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	List<Product> saveAll(List<Product> entities);

	Product save(Product entity);

	List<Product> findByCategoryid(String cid);


}
