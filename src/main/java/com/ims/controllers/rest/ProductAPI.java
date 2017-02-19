package com.ims.controllers.rest;

import com.example.controllers.rest.FlashCard;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.domain.Product;
import com.ims.dto.ProductDTO;
import com.ims.logic.ProductLogic;
import java.util.Arrays;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/product")
public class ProductAPI {
	
	@Autowired
	private ProductLogic productLogic;
        @Autowired
        private HttpSession session;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ProductDTO getProduct(@PathVariable("id") Integer id) {
		Product product = productLogic.getProduct(id);
		ProductDTO productDto = new ProductDTO(product);
		return productDto;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public List<ProductDTO> getAllProducts() {

            List<Product> products = productLogic.getAllProducts();
            List<ProductDTO> productsDto = new ArrayList<>();
            products.forEach((product) -> {
                productsDto.add(new ProductDTO(product));
            });

            return productsDto;
	}
	
//	@RequestMapping(method=RequestMethod.GET, value="/", params={"limit","offset"})
//	public List<Product> getAllProducts(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
//		
//		List<Product> products = ProductLogic.getAllProducts();
//		return products;
//	}
		
}
