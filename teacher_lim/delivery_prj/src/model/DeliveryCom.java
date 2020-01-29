package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeliveryCom {
	private Map<Integer, DeliveryItem> map;
	
	public DeliveryCom() {
		map = new HashMap<>();
	}
	
	public int addDeliveryItem(DeliveryItem item) {
		int key = item.hashCode();
		
		DeliveryItem prev = map.get(key);
		if (prev == null) {
			map.put(key, item);
		} else {
			while (prev != null) {
				key += 1;
				prev = map.get(key);
				if (prev == null) {
					map.put(key, item);
				}
			}
		}
		return key;
	}
	
	public DeliveryItem getDeliveryItem(int key) {
		return map.get(key);
	}
	
	public DeliveryItem[] queryDeliveryItem(String address) {
		List<DeliveryItem> list = new ArrayList<> ();
		for (int key : map.keySet()) {
			DeliveryItem item = map.get(key);
			if (item.getAddress().equalsIgnoreCase(address)) {
				list.add(item);
			}
		}
		
		return list.toArray(new DeliveryItem[0]);
	}
	
	public int getTotalWeightFromAddress(String address) {
		DeliveryItem[] items = queryDeliveryItem(address);
		int sum = 0;
		for (int i = 0; i < items.length; i++) {
			sum += items[i].getTotalWeight();
		}
		return sum;
	}
	
	public double getWeightAvgFromAddress(String address) {
		DeliveryItem[] items = queryDeliveryItem(address);
		double sum = 0;
		for (int i = 0; i < items.length; i++) {
			sum += items[i].getWeightAvg();
		}
		return sum / items.length;
	}
	
	public void completeDelivery(String address) {
		/*
		for (int key : map.keySet()) {
			if (map.get(key).getAddress().equalsIgnoreCase(address)) {
				map.remove(key);
			}
		}
		*/
		Iterator<Entry<Integer, DeliveryItem>> iter = 
				map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, DeliveryItem> entry = iter.next();
			if (entry.getValue().getAddress().equalsIgnoreCase(address)) {
				iter.remove();
			}
		}
	}
	
	public void printAllDeliveryItems() {
		for (Entry<Integer, DeliveryItem> entry : map.entrySet()) {
			System.out.println("[" + entry.getKey() + "] --> " +
					"{" + entry.getValue().getAddress() + "} - " +
					entry.getValue().getTotalWeight() +"g.");
		}
	}
}
