package entity;

public class CongThucMon {
	private String maCongThuc;
	private Mon mon;
	private NguyenLieu nguyenLieu;
	private int soLuong;
	
	public CongThucMon() {
		this("", null, null, 0);
	}

	public CongThucMon(String maCongThuc, Mon mon, NguyenLieu nguyenLieu, int soLuong) {
		super();
		this.maCongThuc = maCongThuc;
		this.mon = mon;
		this.nguyenLieu = nguyenLieu;
		this.soLuong = soLuong;
	}

	public String getMaCongThuc() {
		return maCongThuc;
	}

	public void setMaCongThuc(String maCongThuc) {
		this.maCongThuc = maCongThuc;
	}

	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
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

	@Override
	public String toString() {
		return "CongThucMon [maCongThuc=" + maCongThuc + ", mon=" + mon + ", nguyenLieu=" + nguyenLieu + ", soLuong="
				+ soLuong + "]";
	}
	
}
