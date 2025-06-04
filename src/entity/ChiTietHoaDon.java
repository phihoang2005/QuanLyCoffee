package entity;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private Mon mon;
	private int soLuong;
	private String ghiChu;
	
	public ChiTietHoaDon() {
		this(null, null, 0, "");
	}

	public ChiTietHoaDon(HoaDon hoaDon, Mon mon, int soLuong, String ghiChu) {
		super();
		this.hoaDon = hoaDon;
		this.mon = mon;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", mon=" + mon + ", soLuong=" + soLuong + ", ghiChu=" + ghiChu + "]";
	}
	
}
