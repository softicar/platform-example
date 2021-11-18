package com.mydomain.example.delivery.module;

import com.softicar.platform.core.module.access.module.instance.AGModuleInstance;
import com.softicar.platform.core.module.module.instance.standard.StandardModuleInstanceTable;
import com.softicar.platform.db.runtime.object.sub.IDbSubObjectTableBuilder;

public class AGDeliveryModuleInstanceTable extends StandardModuleInstanceTable<AGDeliveryModuleInstance> {

	public AGDeliveryModuleInstanceTable(IDbSubObjectTableBuilder<AGDeliveryModuleInstance, AGModuleInstance, Integer> builder) {

		super(builder, DeliveryModule.class);
	}
}
