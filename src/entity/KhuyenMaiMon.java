package entity;

public class KhuyenMaiMon {
	private KhuyenMai khuyenMai;
	private Mon mon;
	private String ghiChu;
	
	public KhuyenMaiMon() {
		this(null, null, "");
	}

	public KhuyenMaiMon(KhuyenMai khuyenMai, Mon mon, String ghiChu) {
		super();
		this.khuyenMai = khuyenMai;
		this.mon = mon;
		this.ghiChu = ghiChu;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "KhuyenMaiMon [khuyenMai=" + khuyenMai + ", mon=" + mon + ", ghiChu=" + ghiChu + "]";
	}
	
}
