package com.automate.automation.bo;

public class Item {

	private String deliveryLocation;
	private String itemName;
	private String DifferentVerietyOfItem;
	private String itemBase;
	private boolean rightLocationSelected;
	private boolean result;

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDifferentVerietyOfItem() {
		return DifferentVerietyOfItem;
	}

	public void setDifferentVerietyOfItem(String differentVerietyOfItem) {
		DifferentVerietyOfItem = differentVerietyOfItem;
	}

	public String getItemBase() {
		return itemBase;
	}

	public void setItemBase(String itemBase) {
		this.itemBase = itemBase;
	}

	public boolean isRightLocationSelected() {
		return rightLocationSelected;
	}

	public void setRightLocationSelected(boolean rightLocationSelected) {
		this.rightLocationSelected = rightLocationSelected;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
