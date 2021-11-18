package com.mydomain.example.delivery.module;

import com.softicar.platform.common.io.resource.container.ResourceSupplierContainer;
import com.softicar.platform.common.io.resource.supplier.IResourceSupplier;
import com.softicar.platform.common.io.resource.supplier.ResourceSupplierFactory;

// Note:
// - Resource files are listed in a Resource Supplier Container interface like this.
// - Each resource file must have a corresponding entry in such an interface, and vice-versa.
// - The interface and the resource files must reside in mutually-corresponding packages,
//   in their respective source folders.
@ResourceSupplierContainer
public interface DeliveryImages {

	ResourceSupplierFactory FACTORY = new ResourceSupplierFactory(DeliveryImages.class);

	IResourceSupplier DELIVERY_MODULE = FACTORY.create("delivery-module.svg");
	// Add further IResourceSupplier constants here...
}
