package com.mydomain.example.delivery.module;

import com.softicar.platform.common.code.reference.point.SourceCodeReferencePointUuid;
import com.softicar.platform.common.io.resource.IResource;
import com.softicar.platform.core.module.module.AbstractModule;
import com.softicar.platform.core.module.module.instance.IModuleInstanceTable;

@SourceCodeReferencePointUuid("c104026d-2c01-4289-a23f-e40c6372b8ba")
public class DeliveryModule extends AbstractModule<AGDeliveryModuleInstance> {

	@Override
	public IModuleInstanceTable<AGDeliveryModuleInstance> getModuleInstanceTable() {

		return AGDeliveryModuleInstance.TABLE;
	}
	
	@Override
	public IResource getIcon() {

		return DeliveryImages.DELIVERY_MODULE.getResource();
	}
}
