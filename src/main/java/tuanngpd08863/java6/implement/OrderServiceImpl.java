package tuanngpd08863.java6.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tuanngpd08863.java6.dao.OrderDAO;
import tuanngpd08863.java6.dao.OrderDetailDAO;
import tuanngpd08863.java6.entity.Order;
import tuanngpd08863.java6.entity.OrderDetail;
import tuanngpd08863.java6.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	  @Autowired
	    private OrderDAO orderDAO;  // Sử dụng tên biến theo chuẩn camelCase
	    
	    @Autowired
	    private OrderDetailDAO orderDetailDAO;

	    @Override
	    public Order create(JsonNode orderData) {
	        ObjectMapper mapper = new ObjectMapper();
	        
	        // Chuyển đổi JsonNode thành đối tượng Order
	        Order order = mapper.convertValue(orderData, Order.class);
	        
	        // Kiểm tra dữ liệu Order
	        System.out.println("Order: " + order);
	        
	        orderDAO.save(order);
	        
	        // Chuyển đổi JsonNode thành danh sách các đối tượng OrderDetail
	        TypeReference<List<OrderDetail>> typeRef = new TypeReference<List<OrderDetail>>() {}; 
	        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), typeRef)
	                .stream()
	                .peek(detail -> detail.setOrder(order))
	                .collect(Collectors.toList());
	        
	        // Kiểm tra dữ liệu OrderDetail
	        details.forEach(detail -> System.out.println("OrderDetail: " + detail));
	        
	        orderDetailDAO.saveAll(details);
	        
	        return order;
	    }

	@Override
	public Order findById(Long id) {
		return orderDAO.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return orderDAO.findByUsername(username);
	}
}