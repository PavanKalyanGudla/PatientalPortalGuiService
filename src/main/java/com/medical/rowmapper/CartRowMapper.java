package com.medical.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.modal.Cart;

public class CartRowMapper implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setCart_id(rs.getInt("cart_id"));
		cart.setPatientId(rs.getString("patientId"));
		cart.setProducts(rs.getString("products"));
		cart.setAdded_at(rs.getString("added_at"));
		return cart;
	}

}
