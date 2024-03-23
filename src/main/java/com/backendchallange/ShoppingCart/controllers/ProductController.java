package com.backendchallange.ShoppingCart.controllers;

import com.backendchallange.ShoppingCart.business.abstracts.ProductService;
import com.backendchallange.ShoppingCart.business.dtos.Product.CreateProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.GetProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.UpdateProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/getProduct/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public GetProduct getById(@PathVariable int id){
        return productService.GetById(id);
    }

    @PostMapping("/createProduct")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void Add(@RequestBody() CreateProduct createProduct){
        productService.Add(createProduct);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody()UpdateProduct updateProduct){
        productService.Update(updateProduct);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        productService.Delete(id);
    }
}
