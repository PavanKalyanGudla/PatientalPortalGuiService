package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.Cart;
import com.medical.modal.CartOrders;

public class CartOrdersMapper implements RowMapper<CartOrders>{

	@Override
	public CartOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartOrders orders = new CartOrders();
		orders.setOrder_id(rs.getInt("order_id"));
		orders.setPatientId(rs.getString("patientId"));
		orders.setCart_id(rs.getInt("cart_id"));
		orders.setTotal_amount(rs.getDouble("total_amount"));
		orders.setOrder_status(rs.getString("order_status"));
		orders.setProducts(rs.getString("products"));
		orders.setCreated_at(rs.getString("created_at"));
		return orders;
	}

}
