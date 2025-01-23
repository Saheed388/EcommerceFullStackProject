package com.eccomerce.Ikhlas_eccomerce.repository;

import com.eccomerce.Ikhlas_eccomerce.model.CartItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartItemsRepository extends CrudRepository<CartItems, Long> {
    @Query("SELECT ci FROM CartItems ci WHERE ci.cart.cartId= ?1 AND ci.product.productId = ?2")

    CartItems findCartItemByProductIdAndCartId(Long cartId, Long productId);
}
