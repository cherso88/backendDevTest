package com.test.zara.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.zara.DTO.ProductDetail;

import java.lang.reflect.Type;
import java.util.Set;

public final class Util {
    public static Set<String> parseStringIntoSet(String string) {
        Gson gson = new Gson();
        Type setType = new TypeToken<Set<String>>() {
        }.getType();
        Set<String> stringSet = gson.fromJson(string, setType);
        return stringSet;
    }

    public static ProductDetail parseToProductDetails(String responseBody) {
        Gson gson = new Gson();
        ProductDetail productDetail = gson.fromJson(responseBody, ProductDetail.class);
        return productDetail;
    }
}
