package entity;

import java.time.LocalDate;

import enums.HeDieuHanh;
import enums.XuatXu;

public class DienThoai extends ThietBi {
	private LocalDate ngayNhapKho;
	private HeDieuHanh heDieuHanh;
	
	public DienThoai() {
		this("", "", XuatXu.NOI_DIA, 0.0, 0, LocalDate.now(), HeDieuHanh.ANDROID);
	}
	
	public DienThoai(String maThietBi, String tenThietBi, XuatXu xuatXu, double donGia, int soLuongTon,
			LocalDate ngayNhapKho, HeDieuHanh heDieuHanh) {
		super(maThietBi, tenThietBi, xuatXu, donGia, soLuongTon);
		this.ngayNhapKho = ngayNhapKho;
		this.heDieuHanh = heDieuHanh;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public HeDieuHanh getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho.isAfter(LocalDate.now())) {
			throw new RuntimeException("NGay nhap kho phai truoc hoc bang ngay hien hanh.");
		}
		this.ngayNhapKho = ngayNhapKho;
	}

	public void setHeDieuHanh(HeDieuHanh heDieuHanh) {
		if (heDieuHanh != HeDieuHanh.IOS && heDieuHanh != HeDieuHanh.ANDROID && heDieuHanh != HeDieuHanh.HARMONYOS) {
			throw new RuntimeException("He dieu hanh khong hop le.");
		}
		this.heDieuHanh = heDieuHanh;
	}

	@Override
	public double tinhGiaBanLe() {
		double phiBaoHanh = 0.0;
		double thueNhapKhau = 0.0;
		// Tinh phi bao hanh
		phiBaoHanh = heDieuHanh.equals(HeDieuHanh.IOS) ? getDonGia() * 0.15 : getDonGia() * 0.08;
		
		// Tinh thue nhap khau
		thueNhapKhau = getXuatXu().equals(XuatXu.NHAP_KHAU) ? getDonGia() * 0.1 : getDonGia() * 0.02;
		
		return getDonGia() + phiBaoHanh + thueNhapKhau;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s | %15s | ", ngayNhapKho, heDieuHanh);
	}
	
	
}
