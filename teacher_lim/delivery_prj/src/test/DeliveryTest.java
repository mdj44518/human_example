package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import model.DeliveryCom;
import model.DeliveryItem;

public class DeliveryTest {
	DeliveryCom company;
	
	@Before
	public void setup() {
		company = new DeliveryCom();
		File file = new File("delivery_input.txt");
		try {
			Scanner scann = new Scanner(file);
			
			while (scann.hasNextLine()) {
				String line = scann.nextLine();
				if (line.length() == 0) break;
				DeliveryItem item = DeliveryItem.makeDeliveryItem(line);
				if (item != null) {
					company.addDeliveryItem(item);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDeliveryComTotalWeight() {
		
		assertEquals(85, company.getTotalWeightFromAddress("abc 123"));
	}
	
	@Test
	public void testDeliveryComWeightAvg() {
		assertEquals(28.333, company.getWeightAvgFromAddress("abc 123"), 0.001);
	}

}
