package com.test.zara.client;

import com.test.zara.DTO.ProductDetail;
import com.test.zara.DTO.SimilarProducts;
import com.test.zara.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.test.zara.utils.Util.*;

@Component
public class ProductClient {

    private final String BASE_URL = "http://host.docker.internal:3001/product/";
    private final String END_URL = "/similarids";

    public SimilarProducts makeGetRequest(String productId) throws ProductNotFoundException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + productId + END_URL))
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String responseBody = httpResponse.body();
            if (responseBody != null) {
                return new SimilarProducts(parseStringIntoSet(responseBody));
            }

        } catch (Exception e) {
            throw new ProductNotFoundException("Producto no encontrado: " + productId);
        }
        return null;
    }

    public ProductDetail getProductDetail(String productId) throws ProductNotFoundException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + productId))
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String responseBody = httpResponse.body();
            if (responseBody != null) {
                return parseToProductDetails(responseBody);
            }

        } catch (Exception e) {
            throw new ProductNotFoundException("Producto no encontrado: " + productId);
        }
        return null;
    }

}
