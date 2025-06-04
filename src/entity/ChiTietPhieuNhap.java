package entity;

public class ChiTietPhieuNhap {
	private PhieuNhap phieuNhap;
	private NguyenLieu nguyenLieu;
	private int soLuong;
	private double donGia;
	
	public ChiTietPhieuNhap() {
		this(null, null, 0, 0.0);
	}

	public ChiTietPhieuNhap(PhieuNhap phieuNhap, NguyenLieu nguyenLieu, int soLuong, double donGia) {
		super();
		this.phieuNhap = phieuNhap;
		this.nguyenLieu = nguyenLieu;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public PhieuNhap getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public NguyenLieu getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap [phieuNhap=" + phieuNhap + ", nguyenLieu=" + nguyenLieu + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + "]";
	}
	
}
