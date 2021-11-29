package com.mydomain.example.delivery.module.delivery;

import com.softicar.platform.common.core.i18n.IDisplayString;
import com.softicar.platform.emf.object.IEmfObject;

public class AGDelivery extends AGDeliveryGenerated implements IEmfObject<AGDelivery> {

	@Override
	public IDisplayString toDisplayWithoutId() {

		return IDisplayString.create(getNumber());
	}
}
