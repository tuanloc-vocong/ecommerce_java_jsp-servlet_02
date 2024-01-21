package com.ecommerce.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderIdGenerator {
	public static String getorderId() {
		String orderId = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddhhmmss");
		orderId = sdf.format(new Date());
		orderId = "ORD-" + orderId;
		
		return orderId;
	}
}
