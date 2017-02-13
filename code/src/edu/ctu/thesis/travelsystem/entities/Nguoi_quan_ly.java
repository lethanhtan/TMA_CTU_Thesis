/***********************************************************************
 * Module:  Nguoi_quan_ly.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Nguoi_quan_ly
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "NGUOI_QUAN_LI", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_NQL" }) })
public class Nguoi_quan_ly {
	private char id_nql;
	private String ten_nql;
	private String loai_nql;

	public java.util.Collection<Tour> tour;
	public java.util.Collection<Gia_tour> gia_tour;
	public java.util.Collection<Dia_diem> dia_diem;
	public java.util.Collection<Tai_khoan> tai_khoan;
	public java.util.Collection<Tour_bi_huy> tour_bi_huy;
	public java.util.Collection<Import> imporT;
	public java.util.Collection<Export> export;
	public java.util.Collection<Khuyen_mai> khuyen_mai;

	/* Contructor for Nguoi_quan_ly */
	public Nguoi_quan_ly(char id_nql, String ten_nql, String loai_nql) {
		this.id_nql = id_nql;
		this.ten_nql = ten_nql;
		this.loai_nql = loai_nql;
	}

	/* Setter and Getter method */
	@Id
	@Column
	public char getID() {
		return id_nql;
	}

	public void setId(char id_nql) {
		this.id_nql = id_nql;
	}

	@Column
	public String getTenNql() {
		return ten_nql;
	}

	public void setTenNql(String ten_nql) {
		this.ten_nql = ten_nql;
	}

	@Column
	public String getLoaiNql() {
		return loai_nql;
	}

	public void setLoaiNql(String loai_nql) {
		this.loai_nql = loai_nql;
	}

	/** @pdOid 9c0d5ecc-d78b-4f27-8555-33a69fee666f */
	public void taoTour() {
		// TODO: implement
	}

	/**
	 * @param ma_tour
	 * @pdOid 5db50bd6-1738-443b-abeb-0d32ad43e5b1
	 */
	public void huyTour(char ma_tour) {
		// TODO: implement
	}

	/**
	 * @param ma_tour
	 * @pdOid a7e3c249-9752-4cf3-8227-ea0a5e5de359
	 */
	public void suaTour(char ma_tour) {
		// TODO: implement
	}

	/**
	 * @param ma_tour
	 * @pdOid ea8ff3e6-7a03-4742-aa1a-578bad56c79a
	 */
	public void capNhatGia(char ma_tour) {
		// TODO: implement
	}

	/**
	 * @param ma_dd
	 * @pdOid e80015a9-7fc7-48be-b227-d7cdd03e6e59
	 */
	public void capNhatDd(char ma_dd) {
		// TODO: implement
	}

	/** @pdOid d9cf5bc3-26aa-4fc2-83a8-03c91ad820a3 */
	public void timKiemTour() {
		// TODO: implement
	}

	/**
	 * @param ma_tk
	 * @pdOid 0f0bfd37-8235-4ee0-b3b4-e324e1a0371d
	 */
	public void capNhatTkNd(char ma_tk) {
		// TODO: implement
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Tour> getTour() {
		if (tour == null)
			tour = new java.util.HashSet<Tour>();
		return tour;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTour() {
		if (tour == null)
			tour = new java.util.HashSet<Tour>();
		return tour.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTour
	 */
	public void setTour(java.util.Collection<Tour> newTour) {
		removeAllTour();
		for (java.util.Iterator iter = newTour.iterator(); iter.hasNext();)
			addTour((Tour) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTour
	 */
	public void addTour(Tour newTour) {
		if (newTour == null)
			return;
		if (this.tour == null)
			this.tour = new java.util.HashSet<Tour>();
		if (!this.tour.contains(newTour))
			this.tour.add(newTour);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTour
	 */
	public void removeTour(Tour oldTour) {
		if (oldTour == null)
			return;
		if (this.tour != null)
			if (this.tour.contains(oldTour))
				this.tour.remove(oldTour);
	}

	/** @pdGenerated default removeAll */
	public void removeAllTour() {
		if (tour != null)
			tour.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Gia_tour> getGia_tour() {
		if (gia_tour == null)
			gia_tour = new java.util.HashSet<Gia_tour>();
		return gia_tour;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorGia_tour() {
		if (gia_tour == null)
			gia_tour = new java.util.HashSet<Gia_tour>();
		return gia_tour.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newGia_tour
	 */
	public void setGia_tour(java.util.Collection<Gia_tour> newGia_tour) {
		removeAllGia_tour();
		for (java.util.Iterator iter = newGia_tour.iterator(); iter.hasNext();)
			addGia_tour((Gia_tour) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newGia_tour
	 */
	public void addGia_tour(Gia_tour newGia_tour) {
		if (newGia_tour == null)
			return;
		if (this.gia_tour == null)
			this.gia_tour = new java.util.HashSet<Gia_tour>();
		if (!this.gia_tour.contains(newGia_tour))
			this.gia_tour.add(newGia_tour);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldGia_tour
	 */
	public void removeGia_tour(Gia_tour oldGia_tour) {
		if (oldGia_tour == null)
			return;
		if (this.gia_tour != null)
			if (this.gia_tour.contains(oldGia_tour))
				this.gia_tour.remove(oldGia_tour);
	}

	/** @pdGenerated default removeAll */
	public void removeAllGia_tour() {
		if (gia_tour != null)
			gia_tour.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Dia_diem> getDia_diem() {
		if (dia_diem == null)
			dia_diem = new java.util.HashSet<Dia_diem>();
		return dia_diem;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDia_diem() {
		if (dia_diem == null)
			dia_diem = new java.util.HashSet<Dia_diem>();
		return dia_diem.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDia_diem
	 */
	public void setDia_diem(java.util.Collection<Dia_diem> newDia_diem) {
		removeAllDia_diem();
		for (java.util.Iterator iter = newDia_diem.iterator(); iter.hasNext();)
			addDia_diem((Dia_diem) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDia_diem
	 */
	public void addDia_diem(Dia_diem newDia_diem) {
		if (newDia_diem == null)
			return;
		if (this.dia_diem == null)
			this.dia_diem = new java.util.HashSet<Dia_diem>();
		if (!this.dia_diem.contains(newDia_diem))
			this.dia_diem.add(newDia_diem);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDia_diem
	 */
	public void removeDia_diem(Dia_diem oldDia_diem) {
		if (oldDia_diem == null)
			return;
		if (this.dia_diem != null)
			if (this.dia_diem.contains(oldDia_diem))
				this.dia_diem.remove(oldDia_diem);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDia_diem() {
		if (dia_diem != null)
			dia_diem.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Tai_khoan> getTai_khoan() {
		if (tai_khoan == null)
			tai_khoan = new java.util.HashSet<Tai_khoan>();
		return tai_khoan;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTai_khoan() {
		if (tai_khoan == null)
			tai_khoan = new java.util.HashSet<Tai_khoan>();
		return tai_khoan.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTai_khoan
	 */
	public void setTai_khoan(java.util.Collection<Tai_khoan> newTai_khoan) {
		removeAllTai_khoan();
		for (java.util.Iterator iter = newTai_khoan.iterator(); iter.hasNext();)
			addTai_khoan((Tai_khoan) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTai_khoan
	 */
	public void addTai_khoan(Tai_khoan newTai_khoan) {
		if (newTai_khoan == null)
			return;
		if (this.tai_khoan == null)
			this.tai_khoan = new java.util.HashSet<Tai_khoan>();
		if (!this.tai_khoan.contains(newTai_khoan))
			this.tai_khoan.add(newTai_khoan);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTai_khoan
	 */
	public void removeTai_khoan(Tai_khoan oldTai_khoan) {
		if (oldTai_khoan == null)
			return;
		if (this.tai_khoan != null)
			if (this.tai_khoan.contains(oldTai_khoan))
				this.tai_khoan.remove(oldTai_khoan);
	}

	/** @pdGenerated default removeAll */
	public void removeAllTai_khoan() {
		if (tai_khoan != null)
			tai_khoan.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Tour_bi_huy> getTour_bi_huy() {
		if (tour_bi_huy == null)
			tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
		return tour_bi_huy;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTour_bi_huy() {
		if (tour_bi_huy == null)
			tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
		return tour_bi_huy.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTour_bi_huy
	 */
	public void setTour_bi_huy(java.util.Collection<Tour_bi_huy> newTour_bi_huy) {
		removeAllTour_bi_huy();
		for (java.util.Iterator iter = newTour_bi_huy.iterator(); iter.hasNext();)
			addTour_bi_huy((Tour_bi_huy) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTour_bi_huy
	 */
	public void addTour_bi_huy(Tour_bi_huy newTour_bi_huy) {
		if (newTour_bi_huy == null)
			return;
		if (this.tour_bi_huy == null)
			this.tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
		if (!this.tour_bi_huy.contains(newTour_bi_huy))
			this.tour_bi_huy.add(newTour_bi_huy);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTour_bi_huy
	 */
	public void removeTour_bi_huy(Tour_bi_huy oldTour_bi_huy) {
		if (oldTour_bi_huy == null)
			return;
		if (this.tour_bi_huy != null)
			if (this.tour_bi_huy.contains(oldTour_bi_huy))
				this.tour_bi_huy.remove(oldTour_bi_huy);
	}

	/** @pdGenerated default removeAll */
	public void removeAllTour_bi_huy() {
		if (tour_bi_huy != null)
			tour_bi_huy.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Import> getImport() {
		if (imporT == null)
			imporT = new java.util.HashSet<Import>();
		return imporT;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorImport() {
		if (imporT == null)
			imporT = new java.util.HashSet<Import>();
		return imporT.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newImport
	 */
	public void setImport(java.util.Collection<Import> newImport) {
		removeAllImport();
		for (java.util.Iterator iter = newImport.iterator(); iter.hasNext();)
			addImport((Import) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newImport
	 */
	public void addImport(Import newImport) {
		if (newImport == null)
			return;
		if (this.imporT == null)
			this.imporT = new java.util.HashSet<Import>();
		if (!this.imporT.contains(newImport))
			this.imporT.add(newImport);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldImport
	 */
	public void removeImport(Import oldImport) {
		if (oldImport == null)
			return;
		if (this.imporT != null)
			if (this.imporT.contains(oldImport))
				this.imporT.remove(oldImport);
	}

	/** @pdGenerated default removeAll */
	public void removeAllImport() {
		if (imporT != null)
			imporT.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Export> getExport() {
		if (export == null)
			export = new java.util.HashSet<Export>();
		return export;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorExport() {
		if (export == null)
			export = new java.util.HashSet<Export>();
		return export.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newExport
	 */
	public void setExport(java.util.Collection<Export> newExport) {
		removeAllExport();
		for (java.util.Iterator iter = newExport.iterator(); iter.hasNext();)
			addExport((Export) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newExport
	 */
	public void addExport(Export newExport) {
		if (newExport == null)
			return;
		if (this.export == null)
			this.export = new java.util.HashSet<Export>();
		if (!this.export.contains(newExport))
			this.export.add(newExport);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldExport
	 */
	public void removeExport(Export oldExport) {
		if (oldExport == null)
			return;
		if (this.export != null)
			if (this.export.contains(oldExport))
				this.export.remove(oldExport);
	}

	/** @pdGenerated default removeAll */
	public void removeAllExport() {
		if (export != null)
			export.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Khuyen_mai> getKhuyen_mai() {
		if (khuyen_mai == null)
			khuyen_mai = new java.util.HashSet<Khuyen_mai>();
		return khuyen_mai;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorKhuyen_mai() {
		if (khuyen_mai == null)
			khuyen_mai = new java.util.HashSet<Khuyen_mai>();
		return khuyen_mai.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newKhuyen_mai
	 */
	public void setKhuyen_mai(java.util.Collection<Khuyen_mai> newKhuyen_mai) {
		removeAllKhuyen_mai();
		for (java.util.Iterator iter = newKhuyen_mai.iterator(); iter.hasNext();)
			addKhuyen_mai((Khuyen_mai) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newKhuyen_mai
	 */
	public void addKhuyen_mai(Khuyen_mai newKhuyen_mai) {
		if (newKhuyen_mai == null)
			return;
		if (this.khuyen_mai == null)
			this.khuyen_mai = new java.util.HashSet<Khuyen_mai>();
		if (!this.khuyen_mai.contains(newKhuyen_mai))
			this.khuyen_mai.add(newKhuyen_mai);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldKhuyen_mai
	 */
	public void removeKhuyen_mai(Khuyen_mai oldKhuyen_mai) {
		if (oldKhuyen_mai == null)
			return;
		if (this.khuyen_mai != null)
			if (this.khuyen_mai.contains(oldKhuyen_mai))
				this.khuyen_mai.remove(oldKhuyen_mai);
	}

	/** @pdGenerated default removeAll */
	public void removeAllKhuyen_mai() {
		if (khuyen_mai != null)
			khuyen_mai.clear();
	}

}