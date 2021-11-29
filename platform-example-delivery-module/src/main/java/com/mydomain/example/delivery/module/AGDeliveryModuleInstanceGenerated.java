package com.mydomain.example.delivery.module;

import com.softicar.platform.common.core.annotations.Generated;
import com.softicar.platform.core.module.access.module.instance.AGModuleInstance;
import com.softicar.platform.core.module.transaction.AGTransaction;
import com.softicar.platform.db.runtime.field.IDbBaseField;
import com.softicar.platform.db.runtime.field.IDbForeignField;
import com.softicar.platform.db.runtime.object.sub.AbstractDbSubObject;
import com.softicar.platform.db.runtime.object.sub.DbSubObjectTableBuilder;

/**
 * This is the automatically generated class AGDeliveryModuleInstance for
 * database table <i>Delivery.DeliveryModuleInstance</i>.
 */
@Generated
@SuppressWarnings("all")
public class AGDeliveryModuleInstanceGenerated extends AbstractDbSubObject<AGDeliveryModuleInstance, AGModuleInstance> {

	// -------------------------------- STATIC CONSTANTS -------------------------------- //

	// @formatter:off
	private static final DbSubObjectTableBuilder<AGDeliveryModuleInstance, AGDeliveryModuleInstanceGenerated, AGModuleInstance, Integer> BUILDER = new DbSubObjectTableBuilder<>("Delivery", "DeliveryModuleInstance", AGDeliveryModuleInstance::new, AGDeliveryModuleInstance.class);
	static {
		BUILDER.setTitle(DeliveryI18n.DELIVERY_MODULE_INSTANCE);
		BUILDER.setPluralTitle(DeliveryI18n.DELIVERY_MODULE_INSTANCES);
	}

	public static final IDbBaseField<AGDeliveryModuleInstance, AGModuleInstance, Integer> MODULE_INSTANCE = BUILDER.addBaseField("moduleInstance", o->o.m_moduleInstance, (o,v)->o.m_moduleInstance=v, AGModuleInstance.TABLE).setTitle(DeliveryI18n.MODULE_INSTANCE);
	public static final IDbForeignField<AGDeliveryModuleInstance, AGTransaction> TRANSACTION = BUILDER.addForeignField("transaction", o->o.m_transaction, (o,v)->o.m_transaction=v, AGTransaction.ID).setTitle(DeliveryI18n.TRANSACTION);
	public static final AGDeliveryModuleInstanceTable TABLE = new AGDeliveryModuleInstanceTable(BUILDER);
	// @formatter:on

	// -------------------------------- GETTERS AND SETTERS -------------------------------- //

	public final AGModuleInstance getModuleInstance() {

		return pk();
	}

	public final Integer getTransactionID() {

		return getValueId(TRANSACTION);
	}

	public final AGTransaction getTransaction() {

		return getValue(TRANSACTION);
	}

	public final AGDeliveryModuleInstance setTransaction(AGTransaction value) {

		return setValue(TRANSACTION, value);
	}

	// -------------------------------- UTILS -------------------------------- //

	@Override
	public final AGDeliveryModuleInstanceTable table() {

		return TABLE;
	}

	// -------------------------------- FIELD MEMBERS -------------------------------- //

	private AGModuleInstance m_moduleInstance;
	private AGTransaction m_transaction;
}

