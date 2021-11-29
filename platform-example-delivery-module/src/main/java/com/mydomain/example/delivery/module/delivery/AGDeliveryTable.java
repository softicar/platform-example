package com.mydomain.example.delivery.module.delivery;

import com.mydomain.example.delivery.module.AGDeliveryModuleInstance;
import com.softicar.platform.db.runtime.object.IDbObjectTableBuilder;
import com.softicar.platform.emf.log.EmfChangeLoggerSet;
import com.softicar.platform.emf.object.table.EmfObjectTable;

public class AGDeliveryTable extends EmfObjectTable<AGDelivery, AGDeliveryModuleInstance> {

	public AGDeliveryTable(IDbObjectTableBuilder<AGDelivery> builder) {

		super(builder);
	}
	
	@Override
	public void customizeLoggers(EmfChangeLoggerSet<AGDelivery> loggerSet) {

		loggerSet//
			.addPlainChangeLogger(AGDeliveryLog.DELIVERY, AGDeliveryLog.TRANSACTION)
			.addMapping(AGDelivery.ACTIVE, AGDeliveryLog.ACTIVE)
			.addMapping(AGDelivery.NUMBER, AGDeliveryLog.NUMBER)
			.addMapping(AGDelivery.DATE, AGDeliveryLog.DATE);
	}
}
