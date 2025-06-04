package entity;

import java.time.LocalDateTime;

public class DatMonOnline {
	private String maDatMon;
	private KhachHang khachHang;
	private LocalDateTime ngayDat;
	private double tongTien;
	private String trangThai;
	
	public DatMonOnline() {
		this("", null, LocalDateTime.now(), 0.0, "");
	}

	
	public DatMonOnline(String maDatMon, KhachHang khachHang, LocalDateTime ngayDat, double tongTien,
			String trangThai) {
		super();
		this.maDatMon = maDatMon;
		this.khachHang = khachHang;
		this.ngayDat = ngayDat;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}


	public String getMaDatMon() {
		return maDatMon;
	}

	public void setMaDatMon(String maDatMon) {
		this.maDatMon = maDatMon;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public LocalDateTime getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	@Override
	public String toString() {
		return "DatMonOnline [maDatMon=" + maDatMon + ", khachHang=" + khachHang + ", ngayDat=" + ngayDat
				+ ", tongTien=" + tongTien + ", trangThai=" + trangThai + "]";
	}
	
}
