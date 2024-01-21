package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.entities.Cart;

public class CartDao {
    private Connection connection;

    public CartDao(Connection connection){
        super();
        this.connection = connection;
    }

    public boolean addToCart(Cart cart){
        boolean flag = false;
        try {
            String query = "INSERT INTO cart(uid, pid, quantity) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, cart.getUserId());
            preparedStatement.setInt(2, cart.getProductId());
            preparedStatement.setInt(3, cart.getQuantity());

            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Cart> getCartListByUserId(int uid){
        List<Cart> list = new ArrayList<Cart>();
        try {
            String query = "SELECT * FROM cart WHERE uid = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, uid);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setCartId(resultSet.getInt("id"));
                cart.setUserId(resultSet.getInt("uid"));
                cart.setProductId(resultSet.getInt("pid"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
