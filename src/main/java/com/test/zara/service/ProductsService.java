package com.test.zara.service;

import com.test.zara.DTO.ProductDetail;
import com.test.zara.DTO.SimilarProducts;
import com.test.zara.client.ProductClient;
import com.test.zara.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductsService {

    private final Logger logger = LoggerFactory.getLogger(ProductsService.class);
    private RestTemplate restTemplate;

    protected final ProductClient client;

    public ProductsService(ProductClient client) {
        this.restTemplate = new RestTemplate();
        this.client = client;
    }

    public SimilarProducts getSimilarProducts(String productId) throws ProductNotFoundException {
        try {
            return client.makeGetRequest(productId);
        } catch (HttpClientErrorException e) {
            throw e;
        }
    }

    public ProductDetail getProductDetail(String productId) throws ProductNotFoundException {
        try {
            return client.getProductDetail(productId);
        } catch (HttpClientErrorException e) {
            throw e;
        }
    }
}
