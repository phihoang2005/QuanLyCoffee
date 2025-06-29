package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Ban;
import entity.TrangThaiBan;

public class BanDAO {
	public ArrayList<Ban> layTatCaBan() {
		Connection con=ConnectDB.getConnection();
		ArrayList<Ban> dsBan=new ArrayList<Ban>();
		try {
			String sql="Select * from Ban ";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Ban ban=new Ban(rs.getString(1).toString(),
								rs.getString(2).toString(), 
								TrangThaiBan.valueOf(rs.getString(3).toString()));
				dsBan.add(ban);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBan;
	}
	public boolean capNhatTrangThaiTheoBan(Ban ban) {
		Connection con=ConnectDB.getConnection();
		int n=0;
		try {
			String sql="update Ban set trangThai=? where maBan=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, ban.getTrangThai().toString());
			stmt.setString(2, ban.getMaBan());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean capNhatTrangThaiTheoTen(String tenBan,TrangThaiBan trangThai) {
		Connection con=ConnectDB.getConnection();
		int n=0;
		try {
			String sql="update Ban set trangThai=? where tenBan=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, trangThai.toString());
			stmt.setString(2, tenBan);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
