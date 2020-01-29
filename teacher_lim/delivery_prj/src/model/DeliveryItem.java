package model;

import java.util.ArrayList;
import java.util.List;

public class DeliveryItem {
	private String address;
	private List<Integer> itemWeight;
	//private int sum;
	
	public DeliveryItem() {
		itemWeight = new ArrayList<> ();
	}
	
	public DeliveryItem(String address, int[] weights) {
		this.address = address;
		itemWeight = new ArrayList<> ();
		for (int i = 0; i < weights.length; i++) {
			itemWeight.add(weights[i]);
		}
	}
	
	public void addItem(int w) {
		itemWeight.add(w);
	}
	
	public void addItem(int[] weights) {
		for (int i = 0; i < weights.length; i++) {
			itemWeight.add(weights[i]);
		}
	}
	
	public int getTotalWeight() {
		int sum = 0;
		for (int w : itemWeight) {
			sum += w;
		}
		
		return sum;
	}
	
	public double getWeightAvg() {
		int total = getTotalWeight();
		return (double)total / itemWeight.size();
	}
	
	public boolean removeItem(int w) {
		Integer item = itemWeight.remove(w);
		if (item == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "DeliveryItem [address=" + address + ", itemWeight=" + itemWeight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((itemWeight == null) ? 0 : itemWeight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryItem other = (DeliveryItem) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (itemWeight == null) {
			if (other.itemWeight != null)
				return false;
		} else if (!itemWeight.equals(other.itemWeight))
			return false;
		return true;
	}
	
	public static DeliveryItem makeDeliveryItem(String line) {
		String[] tokens = line.split("/");
		if (tokens != null) {
			DeliveryItem item = new DeliveryItem();
			item.setAddress(tokens[0]);
			for (int i = 1; i < tokens.length; i++) {
				item.addItem(Integer.parseInt(tokens[i]));
			}
			
			return item;
		}
		
		return null;
	}
}










