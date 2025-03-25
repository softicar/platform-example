package com.mydomain.example.delivery.module;

import com.softicar.platform.core.module.module.instance.AGModuleInstanceBase;
import com.softicar.platform.core.module.module.instance.ModuleInstanceTable;
import com.softicar.platform.db.runtime.object.sub.IDbSubObjectTableBuilder;

public class AGDeliveryModuleInstanceTable extends ModuleInstanceTable<AGDeliveryModuleInstance> {

	public AGDeliveryModuleInstanceTable(IDbSubObjectTableBuilder<AGDeliveryModuleInstance, AGModuleInstanceBase, Integer> builder) {

		super(builder, DeliveryModule.class);
	}
}
