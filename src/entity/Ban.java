package entity;

public class Ban {
	private String maBan;
	private String tenBan;
	private TrangThaiBan trangThai;
	
	public Ban() {
		this("", "", TrangThaiBan.TRONG);
	}

	public Ban(String maBan, String tenBan, TrangThaiBan trangThai) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.trangThai = trangThai;
	}

	public String getMaBan() {
		return maBan;
	}

	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public TrangThaiBan getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiBan trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", tenBan=" + tenBan + ", trangThai=" + trangThai + "]";
	}
	
	
}
