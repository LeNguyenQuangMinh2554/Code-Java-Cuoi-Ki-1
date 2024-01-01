package Model;

import java.sql.PreparedStatement;

import java.sql.Connection;

import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelThemHoaDon {

	public void insertHoaDon(String tenNguoiMua, int soDienThoai, String ngayMua, int idSanPham,
			String tenSanPham, int soLuongMua, Double tongGia) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO HoaDon (TenNguoiMua, SoDienThoai, NgayMua, IDSanPham, TenSanPham, SoLuongMua, TongGia) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, tenNguoiMua);
			statement.setInt(2, soDienThoai);
			statement.setString(3, ngayMua);
			statement.setInt(4, idSanPham);
			statement.setString(5, tenSanPham);
			statement.setInt(6, soLuongMua);
			statement.setDouble(7, tongGia);
			statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
