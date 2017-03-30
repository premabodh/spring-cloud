package se.callista.microservises.core.product.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.callista.microservises.support.discovery.model.Product;

/**
 * Created by magnus on 04/03/15.
 */
@RestController
public class ProductService {

    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return
     */
    @RequestMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
    	
    	System.out.println("Inside getProduct Service *********************************");

        return new ResponseEntity<Product>(new Product(productId, "name", 123),HttpStatus.OK);
    }
}
