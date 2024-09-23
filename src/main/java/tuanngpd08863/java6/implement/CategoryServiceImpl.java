package tuanngpd08863.java6.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanngpd08863.java6.dao.CategoryDAO;
import tuanngpd08863.java6.entity.Category;
import tuanngpd08863.java6.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cateDAO;
	
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDAO.findAll();
	}

}
