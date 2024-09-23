package tuanngpd08863.java6.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanngpd08863.java6.dao.ProductDAO;
import tuanngpd08863.java6.entity.Product;
import tuanngpd08863.java6.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    ProductDAO productDAO;

	@Override
	public  Product save(Product product) {
		return productDAO.save(product);
	}

	@Override
	public  List<Product> saveAll(List<Product> entities) {
		return (List<Product>)productDAO.saveAll(entities);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productDAO.findAll();
	}

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>)productDAO.findAllById(ids);
	}

	@Override
	public Product findById(Integer id) {
		return productDAO.findById(id).get();
	}

	@Override
	public boolean existsById(Integer id) {
		return productDAO.existsById(id);
	}

	@Override
	public long count() {
		return productDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDAO.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		productDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		productDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDAO.deleteAll();
	}

	@Override
	public List<Product> findByCategoryid(String cid) {
		// TODO Auto-generated method stub
		return productDAO.findByCategoryid(cid);
	}


	
}
