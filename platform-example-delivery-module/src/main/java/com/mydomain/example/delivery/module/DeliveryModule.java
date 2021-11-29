package com.mydomain.example.delivery.module;

import com.softicar.platform.common.io.resource.IResource;
import com.softicar.platform.core.module.module.AbstractStandardModule;
import com.softicar.platform.core.module.module.instance.standard.IStandardModuleInstanceTable;
import com.softicar.platform.emf.source.code.reference.point.EmfSourceCodeReferencePointUuid;

// Note:
// - All UUIDs in the code must be randomly generated.
@EmfSourceCodeReferencePointUuid("c104026d-2c01-4289-a23f-e40c6372b8ba")
public class DeliveryModule extends AbstractStandardModule<AGDeliveryModuleInstance> {

	@Override
	public IStandardModuleInstanceTable<AGDeliveryModuleInstance> getModuleInstanceTable() {

		return AGDeliveryModuleInstance.TABLE;
	}
	
	@Override
	public IResource getIcon() {

		return DeliveryImages.DELIVERY_MODULE.getResource();
	}
}
