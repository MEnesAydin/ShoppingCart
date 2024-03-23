package com.backendchallange.ShoppingCart.business.concretes;

import com.backendchallange.ShoppingCart.business.abstracts.CartService;
import com.backendchallange.ShoppingCart.business.dtos.Cart.GetCart;
import com.backendchallange.ShoppingCart.business.dtos.CartItem.CartItemDTO;
import com.backendchallange.ShoppingCart.entities.concretes.Cart;
import com.backendchallange.ShoppingCart.entities.concretes.CartItem;
import com.backendchallange.ShoppingCart.entities.concretes.Product;
import com.backendchallange.ShoppingCart.exceptions.BusinessException;
import com.backendchallange.ShoppingCart.repositories.CartItemRepository;
import com.backendchallange.ShoppingCart.repositories.CartRepository;
import com.backendchallange.ShoppingCart.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private CartItemRepository cartItemRepository;
    @Override
    public GetCart GetById(int id) {
        Cart cart = cartRepository.findById(id);
        List<CartItem> products = cartItemRepository.findCartItemsByCartId(cart.getId());

        GetCart getCart = new GetCart();
        getCart.setId(cart.getId());
        getCart.setTotalPrice(cart.getTotalprice());


        List<CartItemDTO> cartItems = new ArrayList<>();
        for(CartItem cartItem : products){
            CartItemDTO cartItemDTO = new CartItemDTO();

            cartItemDTO.setProductId(cartItem.getProduct().getId());
            cartItemDTO.setProductName(cartItem.getProduct().getName());
            cartItemDTO.setQuantity(cartItem.getQuantity());
            cartItemDTO.setPrice(cartItem.getPrice());
            cartItems.add(cartItemDTO);
        }
        getCart.setProducts(cartItems);

        return getCart;

    }

    @Override
    public void Update(int cartId, int productId, int quantity) {
        Cart cart = cartRepository.findById(cartId);
        Product product = productRepository.findById(productId);
        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(cartId, productId);

        if(product.getQuantity()<quantity-cartItem.getQuantity()){
            throw new RuntimeException();
        }

        cart.setTotalprice(cart.getTotalprice() + product.getPrice()*(quantity-cartItem.getQuantity()));
        cartItem.setPrice(product.getPrice());
        cartItem.setQuantity(product.getQuantity());

        cartItemRepository.save(cartItem);
    }

    @Transactional
    @Override
    public void EmptyCart(int cartId) {
        Cart cart = cartRepository.findById(cartId);
        cart.setTotalprice(0);
        cartRepository.save(cart);
        cartItemRepository.deleteAllByCartId(cartId);
    }

    @Override
    public void AddProduct(int cartId, int productId, int quantity) {
        Cart cart = cartRepository.findById(cartId);
        Product product = productRepository.findById(productId);

        if(product.getQuantity() < quantity) {
            throw new BusinessException("ürün stoğu yetersiz. Kalan stok: "+product.getQuantity());
        }
        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(productId, cartId);
        if(cartItem != null){
            throw new BusinessException("Ürün zaten sepette var: "+product.getName());
        }
        cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(product.getPrice());
        cart.setTotalprice(cart.getTotalprice() + product.getPrice()*quantity);

        cartItemRepository.save(cartItem);

    }

    @Override
    public void RemoveProductFromCart(int cartId, int productId) {
        Cart cart = cartRepository.findById(cartId);
        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(cartId, productId);
        cart.setTotalprice(cart.getTotalprice() - (cartItem.getPrice() * cartItem.getQuantity()));

        cartItemRepository.delete(cartItem);
    }


}
