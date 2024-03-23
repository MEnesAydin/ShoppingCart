package com.backendchallange.ShoppingCart.business.concretes;

import com.backendchallange.ShoppingCart.business.abstracts.ProductService;
import com.backendchallange.ShoppingCart.business.dtos.Product.CreateProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.GetProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.UpdateProduct;
import com.backendchallange.ShoppingCart.entities.concretes.Product;
import com.backendchallange.ShoppingCart.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    @Override
    public void Add(CreateProduct createProduct) {
        Product product = new Product();

        product.setName(createProduct.getName());
        product.setQuantity(createProduct.getQuantity());
        product.setPrice(createProduct.getPrice());

        productRepository.save(product);
    }

    @Override
    public GetProduct GetById(int id) {
        Product product = productRepository.findById(id);
        GetProduct getProduct = new GetProduct();

        getProduct.setId(product.getId());
        getProduct.setName(product.getName());
        getProduct.setQuantity(product.getQuantity());
        getProduct.setPrice(product.getPrice());

        return getProduct;
    }

    @Override
    public void Update(UpdateProduct updateProduct) {
        Product product = new Product();

        product.setId(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setQuantity(updateProduct.getQuantity());
        product.setPrice(updateProduct.getPrice());

        productRepository.save(product);
    }

    @Override
    public void UpdateQuantity(int productId, int quantity) {
        Product product = productRepository.findById(productId);
        product.setQuantity(quantity);
        productRepository.save(product);
    }


    @Override
    public void Delete(int id) {
        productRepository.deleteById(id);
    }
}
