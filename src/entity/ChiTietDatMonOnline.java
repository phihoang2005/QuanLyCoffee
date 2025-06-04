package entity;

public class ChiTietDatMonOnline {
	private DatMonOnline datMonOnline;
	private Mon mon;
	private int soLuong;
	
	public ChiTietDatMonOnline() {
		this(null, null, 0);
	}

	public ChiTietDatMonOnline(DatMonOnline datMonOnline, Mon mon, int soLuong) {
		super();
		this.datMonOnline = datMonOnline;
		this.mon = mon;
		this.soLuong = soLuong;
	}

	public DatMonOnline getDatMonOnline() {
		return datMonOnline;
	}

	public void setDatMonOnline(DatMonOnline datMonOnline) {
		this.datMonOnline = datMonOnline;
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

	@Override
	public String toString() {
		return "ChiTietDatMonOnline [datMonOnline=" + datMonOnline + ", mon=" + mon + ", soLuong=" + soLuong + "]";
	}
	
}
