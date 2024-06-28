package org.yearup.data.mysql;

import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Category;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    public ShoppingCart getByUserId(int userId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String sql = "SELECT * FROM shopping_cart " + "JOIN products ON products.product_id=shopping_cart.product_id " + "WHERE user_id = ?;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return shoppingCart;
    }

    @Override
    public ShoppingCart create(int userId, int productId) {
        ShoppingCart shoppingCart = new ShoppingCart();

        String sql = "INSERT INTO shopping_cart(user_id, product_id, quantity) " + "VALUES (?,?,1);";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, productId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return shoppingCart;
    }

    @Override
    public void update(int userId, int productId) {
        String sql = "UPDATE shopping_cart " + "SET quantity = ? " +
                "WHERE product_id =?;";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM shopping_cart WHERE user_id = ?;";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

