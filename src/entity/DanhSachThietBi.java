package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import enums.PhanKhuc;

public class DanhSachThietBi {
	List<ThietBi> danhSach = new ArrayList<ThietBi>();
	
	public DanhSachThietBi() {
		this.danhSach = new ArrayList<ThietBi>();
	}

	public DanhSachThietBi(List<ThietBi> danhSach) {
		this.danhSach = new ArrayList<ThietBi>(danhSach);
	}
	
	
	/**
	 * 
	 * @param tb
	 * @return them thanh cong ? true : false
	 * nem ngoai le neu du lieu khong hop le
	 */
	public boolean themThietBi (ThietBi tb) {
		if (tb == null) {
			throw new RuntimeException("Thiet bi khong hop le!");
		}
		if (tb.maThietBi.isBlank()) {
			throw new RuntimeException("Ma thiet bi khong duoc rong!");
		}
		
		if (danhSach.contains(tb)) {
			throw new RuntimeException("Trung ma!");
		}
		
		return danhSach.add(tb);
	}
	
	/**
	 * Sap xep tang dan theo don gia
	 */
	public void sapTangDanTheoDonGia() {
		danhSach.sort(Comparator.comparing(ThietBi::getDonGia));
	}
	
	/**
	 * 
	 * @return danh sach laptop phan khuc gaming
	 */
	public String xuatDSLaptopGaming() {
		StringBuilder sb = new StringBuilder();
		for (ThietBi thietBi : danhSach) {
			if (thietBi instanceof Laptop && ((Laptop) thietBi).getPhanKhuc().equals(PhanKhuc.GAMING)) {
				sb.append(thietBi.toString()).append("\n");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<String, Integer> thongKeSoLuongTon () {
		return danhSach.stream().collect(Collectors.groupingBy(tb -> tb.getClass().getSimpleName(), Collectors.summingInt(ThietBi::getSoLuongTon)));
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ThietBi thietBi : danhSach) {
			sb.append(thietBi).append("\n");
		}
		
		return sb.toString();
	}
	
	
}
