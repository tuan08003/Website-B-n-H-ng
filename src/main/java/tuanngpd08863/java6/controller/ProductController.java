package tuanngpd08863.java6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tuanngpd08863.java6.entity.Product;
import tuanngpd08863.java6.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/product/test")
	public String list(Model model, @RequestParam("cid")Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> ls = productService.findByCategoryid(cid.get());
			model.addAttribute("item", ls);
		}else {
			List<Product> ls = productService.findAll();
			model.addAttribute("item", ls);
		}
		
		
		return "product/test";
	}
	
	@RequestMapping("/product/detailProduct/{id}")
	public String detailProduct(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detailProduct";
	}
}
