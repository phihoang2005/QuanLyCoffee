package entity;

public class Mon {
	private String maMon;
	private String tenMon;
	private String loaiMon;
	private double giaBan;
	private String moTa;
	private String hinhAnh;
	private boolean trangThai;
	
	public Mon() {
		this("", "", "", 0.0, "", "", true);
	}

	public Mon(String maMon, String tenMon, String loaiMon, double giaBan, String moTa, String hinhAnh,
			boolean trangThai) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.giaBan = giaBan;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getLoaiMon() {
		return loaiMon;
	}

	public void setLoaiMon(String loaiMon) {
		this.loaiMon = loaiMon;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "Mon [maMon=" + maMon + ", tenMon=" + tenMon + ", loaiMon=" + loaiMon + ", giaBan=" + giaBan + ", moTa="
				+ moTa + ", hinhAnh=" + hinhAnh + ", trangThai=" + trangThai + "]";
	}
	
}
