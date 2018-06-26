package com.beans;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="storeinfo")
public class StoreInfo {

	public StoreInfo() {
		
	}
	
	public StoreInfo(int storeId, String storeName) {
		this.storeId = storeId;
		this.storeName = storeName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="storeId")
	private int storeId;

	@Column(name="storeName")
	private String storeName;
	
	//If you don't specify anything, then by default all will be Type of Cascade
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="storeManager")
	private LoginUserTable storeManager;
	
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		return "StoreInfo [storeId=" + storeId + ", storeName=" + storeName + ", storeManager=" + storeManager + "]";
	}
}
