package entity;

import java.time.LocalDateTime;

public class DatBan {
	private String maDatBan;
	private KhachHang khachHang;
	private Ban ban;
	private LocalDateTime thoiGianDat;
	private String ghiChu;
	
	public DatBan() {
		this("", null, null, LocalDateTime.now(), "");
	}

	public DatBan(String maDatBan, KhachHang khachHang, Ban ban, LocalDateTime thoiGianDat, String ghiChu) {
		super();
		this.maDatBan = maDatBan;
		this.khachHang = khachHang;
		this.ban = ban;
		this.thoiGianDat = thoiGianDat;
		this.ghiChu = ghiChu;
	}

	public String getMaDatBan() {
		return maDatBan;
	}

	public void setMaDatBan(String maDatBan) {
		this.maDatBan = maDatBan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Ban getBan() {
		return ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "DatBan [maDatBan=" + maDatBan + ", khachHang=" + khachHang + ", ban=" + ban + ", thoiGianDat="
				+ thoiGianDat + ", ghiChu=" + ghiChu + "]";
	}
	
}
