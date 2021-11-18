package com.mydomain.example.delivery.module.delivery;

import com.mydomain.example.delivery.module.AGDeliveryModuleInstance;
import com.mydomain.example.delivery.module.DeliveryModule;
import com.softicar.platform.emf.management.page.AbstractEmfManagementPage;
import com.softicar.platform.emf.source.code.reference.point.EmfSourceCodeReferencePointUuid;
import com.softicar.platform.emf.table.IEmfTable;

// Note:
// - All UUIDs in the code must be randomly generated.
@EmfSourceCodeReferencePointUuid("f81cd3c2-6a39-48ac-90f2-170865abcbb0")
public class DeliveryManagementPage extends AbstractEmfManagementPage<AGDeliveryModuleInstance> {

	@Override
	public Class<DeliveryModule> getModuleClass() {

		return DeliveryModule.class;
	}

	@Override
	protected IEmfTable<?, ?, AGDeliveryModuleInstance> getTable() {

		return AGDelivery.TABLE;
	}
}
