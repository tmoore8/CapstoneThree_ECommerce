package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    // add additional method signatures here
    ShoppingCart getByUserId(int userId);
    ShoppingCart create(int userId, int productId);
    void update(int userId, int productId);
    void delete(int userId);


}
