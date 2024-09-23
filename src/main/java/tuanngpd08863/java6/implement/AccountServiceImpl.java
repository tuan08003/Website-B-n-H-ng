package tuanngpd08863.java6.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanngpd08863.java6.dao.AccountDAO;
import tuanngpd08863.java6.entity.Account;
import tuanngpd08863.java6.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO acDAO;
	
	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return acDAO.findById(username).get();
	}

}
