package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entity.KhachHang;

public class KhachHangDAO {
	public ArrayList<KhachHang> layTatCaKhachHang() {
		Connection con=ConnectDB.getConnection();
		ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();
		try {
			String sql="Select * from KhachHang ";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				 	String maKhachHang = rs.getString("maKhachHang");
		            String hoTen = rs.getString("hoTen");
		            String soDienThoai = rs.getString("soDienThoai");
		            String email = rs.getString("email");
		            int diemTichLuy = rs.getInt("diemTichLuy");
		            LocalDate ngayDangKy = rs.getDate("ngayDangKy").toLocalDate();

		            KhachHang khachhang = new KhachHang(maKhachHang, hoTen, soDienThoai, email, diemTichLuy, ngayDangKy);
		            dsKhachHang.add(khachhang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	public boolean themKhachHang(KhachHang khachHang) {
		Connection con=ConnectDB.getConnection();
		int n=0;
		try {
			String sql="insert into KhachHang (maKhachHang,hoTen,soDienThoai,email,diemTichLuy,ngayDangKy) values (?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, khachHang.getMaKhachHang());
			stmt.setString(2,khachHang.getHoTen() );
			stmt.setString(3,khachHang.getSoDienThoai());
			stmt.setString(4,khachHang.getEmail() );
			stmt.setInt(5,khachHang.getDiemTichLuy() );
			stmt.setDate(6,Date.valueOf(khachHang.getNgayDangKy()));
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public String taoMaKhachHang() {
		Connection con=ConnectDB.getConnection();
		LocalDate now=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMyy");
		String MMyy=now.format(dtf);
		String cauTruc= "KH-"+MMyy+"-";
		try {
			String sql="Select Count(*) from KhachHang where maKhachHang like ?";
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setString(1, cauTruc+"%");
			ResultSet rs=stmt.executeQuery();
			int soLuong=0;
			if(rs.next()){
				soLuong = rs.getInt(1);
			}
			String soTiepTheo=String.format("%04d", soLuong+1);
			return cauTruc+soTiepTheo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
