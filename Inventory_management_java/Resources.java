package com.curonex;

import java.time.LocalDate;

import com.curonex.enums.ResourceAvailabilityEnum;
import com.curonex.enums.ResourceCategoryEnum;

public class Resources {

    private long resource_id;
    private String name;
    private ResourceCategoryEnum category;
    private String units;
    private String supplier;
    private LocalDate manufacturing_date;
    private LocalDate expiry_date;
    private int quantity;
    private ResourceAvailabilityEnum availability_status;
    private long hospital_id;

    public Resources() {
    }

	public Resources(long resource_id, String name, ResourceCategoryEnum category, String units, String supplier,
			LocalDate manufacturing_date, LocalDate expiry_date, int quantity,
			ResourceAvailabilityEnum availability_status, long hospital_id) {
		super();
		this.resource_id = resource_id;
		this.name = name;
		this.category = category;
		this.units = units;
		this.supplier = supplier;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.quantity = quantity;
		this.availability_status = availability_status;
		this.hospital_id = hospital_id;
	}

	public long getResource_id() {
		return resource_id;
	}

	public void setResource_id(long resource_id) {
		this.resource_id = resource_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ResourceCategoryEnum category) {
		this.category = category;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public LocalDate getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(LocalDate manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ResourceAvailabilityEnum getAvailability_status() {
		return availability_status;
	}

	public void setAvailability_status(ResourceAvailabilityEnum availability_status) {
		this.availability_status = availability_status;
	}

	public long getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(long hospital_id) {
		this.hospital_id = hospital_id;
	}
}
