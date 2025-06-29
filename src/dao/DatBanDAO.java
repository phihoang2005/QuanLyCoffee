package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entity.Ban;
import entity.DatBan;
import entity.KhachHang;
import entity.TrangThaiBan;

public class DatBanDAO {
	public boolean themDatBan(DatBan datBan) {
		Connection con=ConnectDB.getConnection();
		int n=0;
		try {
			String sql="insert into DatBan (maKhachHang,maBan,thoiGianDat,ghiChu) values (?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, datBan.getKhachHang().getMaKhachHang());
			stmt.setString(2, datBan.getBan().getMaBan());
			stmt.setTimestamp(3, Timestamp.valueOf(datBan.getThoiGianDat()));
			stmt.setString(4, datBan.getGhiChu());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public DatBan layDatBanTheoTenBan(String tenBan){
		Connection con=ConnectDB.getConnection();
		DatBan datban=null;
		try {
			String sql="Select TOP 1 * "
					+ "From DatBan db JOIN KhachHang kh ON db.maKhachHang=kh.maKhachHang JOIN Ban b ON db.maBan=b.maBan "
					+ "Where b.tenBan=? "
					+ "Order by db.thoiGianDat DESC ";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, tenBan);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Ban ban=new Ban(rs.getString("maBan"),rs.getString("tenBan") ,TrangThaiBan.valueOf(rs.getString("trangThai")));
				KhachHang khachHang=new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTen"),rs.getString("soDienThoai"), rs.getString("email"), rs.getInt("diemTichLuy"), rs.getDate("ngayDangKy").toLocalDate());
				datban=new DatBan(khachHang, ban, rs.getTimestamp("thoiGianDat").toLocalDateTime(), rs.getString("ghiChu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datban;
	}
}
