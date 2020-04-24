package com.sk.java.ProductManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sk.java.ProductManager.model.Product;
import com.sk.java.ProductManager.service.ProductService;

@Controller
public class AppController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> productList = service.listAll();
		model.addAttribute("productList", productList);
		return "index";
	}
	
//	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product p = service.get(id);
		mav.addObject("p", p);
		return mav;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/new")
	public String createNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
