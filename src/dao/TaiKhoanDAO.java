package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.TaiKhoan;

public class TaiKhoanDAO {
	//0:khong tồn tại | 1:mật khẩu đúng | 2: mật khẩu sai
	public int kiemTraTaiKhoan(String tenDangNhap,String matKhau) {
		Connection con=ConnectDB.getConnection();	
		int ketQua=0;
		try {
			String sql="Select * from TaiKhoan where tenDangNhap=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {
				String matKhauDB=rs.getString(3);
				if(matKhau.equals(matKhauDB)) {
					ketQua=1;
				}else {
					ketQua=2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	//Đổi mật khẩu
	public boolean doiMatKhau(String soDienThoai,String matKhau) {
		Connection con=ConnectDB.getConnection();
		int n=0;
		try {
			String sql="UPDATE TaiKhoan"
					+ " SET matKhau = ?"
					+ " WHERE maTaiKhoan IN "
					+ " (SELECT maTaiKhoan FROM NhanVien WHERE soDienThoai = ?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, matKhau);
			stmt.setString(2, soDienThoai);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
