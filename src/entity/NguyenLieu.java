package entity;

public class NguyenLieu {
	private String maNguyenLieu;
	private String tenNguyenLieu;
	private String donViTinh;
	private int soLuongTon;
	private double mucCanhBao;
	
	public NguyenLieu() {
		this("", "", "", 0, 0.0);
	}

	public NguyenLieu(String maNguyenLieu, String tenNguyenLieu, String donViTinh, int soLuongTon, double mucCanhBao) {
		super();
		this.maNguyenLieu = maNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.donViTinh = donViTinh;
		this.soLuongTon = soLuongTon;
		this.mucCanhBao = mucCanhBao;
	}

	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public double getMucCanhBao() {
		return mucCanhBao;
	}

	public void setMucCanhBao(double mucCanhBao) {
		this.mucCanhBao = mucCanhBao;
	}

	@Override
	public String toString() {
		return "NguyenLieu [maNguyenLieu=" + maNguyenLieu + ", tenNguyenLieu=" + tenNguyenLieu + ", donViTinh="
				+ donViTinh + ", soLuongTon=" + soLuongTon + ", mucCanhBao=" + mucCanhBao + "]";
	}
	
}
