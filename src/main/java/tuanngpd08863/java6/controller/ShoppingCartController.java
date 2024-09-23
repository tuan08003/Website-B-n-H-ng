package tuanngpd08863.java6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	@RequestMapping("/cart/view")
	public String cart() {
		return "cart/view";
	}
	
	@RequestMapping("/layout/index")
	public String view() {
		return "layout/index";
	}
}
