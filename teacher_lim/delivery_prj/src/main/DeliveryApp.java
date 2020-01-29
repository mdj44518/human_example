package main;

import java.util.Arrays;

import model.DeliveryCom;
import model.DeliveryItem;

public class DeliveryApp {

	public static void main(String[] args) {
		DeliveryItem item = new DeliveryItem();
		int[] w = {10, 15, 20, 30};
		DeliveryItem item2 = new DeliveryItem("서울시 동작구", w);
		DeliveryItem item3 = new DeliveryItem("강원도 춘천시", 
				new int[] {5, 10});
		
		item.setAddress("강원도 춘천시");
		item.addItem(10);
		item.addItem(4);
		item.addItem(new int[] {11, 3});
		
		System.out.println(item);
		System.out.println(item.getTotalWeight());
		System.out.println(item.getWeightAvg());
		
		DeliveryCom com = new DeliveryCom();
		int key = com.addDeliveryItem(item);
		int key2 = com.addDeliveryItem(item2);
		int key3 = com.addDeliveryItem(item3);
		
		int key4 = com.addDeliveryItem(item);
		
		System.out.println(key + ", " + key2 + ", " + key3 + ", " + key4);
		
		DeliveryItem temp = com.getDeliveryItem(key4);
		if (temp.equals(item)) {
			System.out.println(temp);
		}
		
		DeliveryItem[] items = com.queryDeliveryItem("강원도 춘천시");
		System.out.println(Arrays.toString(items));
		System.out.println(com.getTotalWeightFromAddress("강원도 춘천시"));
		com.printAllDeliveryItems();
		com.completeDelivery("강원도 춘천시");
		System.out.println("\n배송완료 후...");
		com.printAllDeliveryItems();
	}

}
