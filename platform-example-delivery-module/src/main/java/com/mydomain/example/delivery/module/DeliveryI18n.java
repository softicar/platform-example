package com.mydomain.example.delivery.module;

import com.softicar.platform.common.core.i18n.I18n0;
import com.softicar.platform.core.module.CoreI18n;

// Note:
// - Use I18n0 for labels w/o arguments.
// - Use I18n1, I18n2, ... for labels w/ 1, 2, ... arguments.
// - Use "%s" as an argument placeholder, regardless of the replacement type.
// - Let the constant names reflect the content of the original label; see examples below.
public interface DeliveryI18n extends CoreI18n {

	I18n0 DELIVERIES = new I18n0("Deliveries")//
		.de("Lieferungen");
	I18n0 DELIVERY = new I18n0("Delivery")//
		.de("Lieferung");
	I18n0 DELIVERY_LOG = new I18n0("Delivery Log")//
		.de("Lieferungs-Log");
	I18n0 DELIVERY_LOGS = new I18n0("Delivery Logs")//
		.de("Lieferungs-Logs");
	I18n0 DELIVERY_MODULE_INSTANCE = new I18n0("Delivery Module Instance")//
		.de("Lieferungs-Modulinstanz");
	I18n0 DELIVERY_MODULE_INSTANCES = new I18n0("Delivery Module Instances")//
		.de("Lieferungs-Modulinstanzen");
}
