package tuanngpd08863.java6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import tuanngpd08863.java6.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping("/order/checkout")
	public String Checkout() {
		return "order/checkout";
	}
	
	@RequestMapping("/order/list")
	public String List(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername (username));
		return "order/list";
	}
	
	@RequestMapping("/order/detailOrder/{id}")
	public String detailOrder(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detailOrder";
	}
}
