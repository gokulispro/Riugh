package com.curonex;

import java.time.LocalDateTime;

import com.curonex.enums.TransferStatusEnum;

public class ResourceTransfers {

    private long transfer_id;
    private long resource_id;
    private long source_hospital_id;
    private long destination_hospital_id;
    private int quantity;
    private LocalDateTime transfer_date;
    private TransferStatusEnum transfer_status;

    public ResourceTransfers() {
    }

	public ResourceTransfers(long transfer_id, long resource_id, long source_hospital_id, long destination_hospital_id,
			int quantity, LocalDateTime transfer_date, TransferStatusEnum transfer_status) {
		super();
		this.transfer_id = transfer_id;
		this.resource_id = resource_id;
		this.source_hospital_id = source_hospital_id;
		this.destination_hospital_id = destination_hospital_id;
		this.quantity = quantity;
		this.transfer_date = transfer_date;
		this.transfer_status = transfer_status;
	}

	public long getTransfer_id() {
		return transfer_id;
	}

	public void setTransfer_id(long transfer_id) {
		this.transfer_id = transfer_id;
	}

	public long getResource_id() {
		return resource_id;
	}

	public void setResource_id(long resource_id) {
		this.resource_id = resource_id;
	}

	public long getSource_hospital_id() {
		return source_hospital_id;
	}

	public void setSource_hospital_id(long source_hospital_id) {
		this.source_hospital_id = source_hospital_id;
	}

	public long getDestination_hospital_id() {
		return destination_hospital_id;
	}

	public void setDestination_hospital_id(long destination_hospital_id) {
		this.destination_hospital_id = destination_hospital_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(LocalDateTime transfer_date) {
		this.transfer_date = transfer_date;
	}

	public TransferStatusEnum getTransfer_status() {
		return transfer_status;
	}

	public void setTransfer_status(TransferStatusEnum transfer_status) {
		this.transfer_status = transfer_status;
	}
}
