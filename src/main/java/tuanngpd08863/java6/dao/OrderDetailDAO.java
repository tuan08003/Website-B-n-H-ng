package tuanngpd08863.java6.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import tuanngpd08863.java6.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	
}
