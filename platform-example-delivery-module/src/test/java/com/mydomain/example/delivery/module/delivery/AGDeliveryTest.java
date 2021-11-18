package com.mydomain.example.delivery.module.delivery;

import org.junit.Test;

import com.mydomain.example.delivery.module.AGDeliveryModuleInstance;
import com.softicar.platform.core.module.test.AbstractCoreTest;

public class AGDeliveryTest extends AbstractCoreTest {

	private AGDeliveryModuleInstance deliveryModuleInstance;

	public AGDeliveryTest() {

		this.deliveryModuleInstance = insertStandardModuleInstance(AGDeliveryModuleInstance.TABLE);
	}
	
	@Test
	public void testToDisplayWithoutId() {

		AGDelivery delivery = new AGDelivery().setDeliveryModuleInstance(deliveryModuleInstance).setNumber("foo").save();
		assertEquals("foo", delivery.toDisplayWithoutId().toString());
	}
}
