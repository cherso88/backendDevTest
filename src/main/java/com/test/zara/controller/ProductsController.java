package com.test.zara.controller;

import com.test.zara.exception.ProductNotFoundException;
import com.test.zara.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    ProductsService service;

    @GetMapping("{productId}/similar")
    ResponseEntity<?> getSimilarProducts(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseEntity<>(service.getSimilarProducts(productId.toString()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{productId}")
    ResponseEntity<?> getProduct(@PathVariable("productId") Integer productId) {
        try {
            return new ResponseEntity<>(service.getProductDetail(productId.toString()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
