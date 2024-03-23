package com.backendchallange.ShoppingCart.controllers;

import com.backendchallange.ShoppingCart.business.abstracts.CartService;
import com.backendchallange.ShoppingCart.business.dtos.Cart.GetCart;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@AllArgsConstructor
public class CartController {
    private CartService cartService;

    @GetMapping("/GetById")
    public ResponseEntity<GetCart> getById(@RequestParam int id) {
        GetCart cart = cartService.GetById(id);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void Update(int cartId, int productId, int quantity){
        cartService.Update(cartId,productId,quantity);
    }

    @DeleteMapping("/EmptyCart")
    public ResponseEntity<Void> emptyCart(@RequestParam int cartId) {
        cartService.EmptyCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/AddProductToCart")
    public ResponseEntity<Void> AddProductToCart(int cartId, int productId, int quantity){
        cartService.AddProduct(cartId, productId, quantity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/removeProductFromCart")
    public ResponseEntity<Void> removeProductFromCart(int cartId,int productId) {
        cartService.RemoveProductFromCart(cartId, productId);
        return ResponseEntity.noContent().build();
    }



}
