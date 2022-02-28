package com.onedirect.redis.repository;

import com.onedirect.redis.entity.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private RedisTemplate template;
    public Product save(Product product){
        template.opsForHash().put("Product",product.getId(),product);
        return product;
    }
    public List<Product> findAll(){
        return template.opsForHash().values("Product");
    }
    public Product findProductById(int id){
        return (Product) template.opsForHash().get("Product",id);
    }
    public String deleteProduct(int id){
        template.opsForHash().delete("Product",id);
        return "product removed!!";
    }
}
