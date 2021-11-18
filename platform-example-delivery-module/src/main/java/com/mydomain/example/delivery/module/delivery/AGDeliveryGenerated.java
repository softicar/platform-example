package com.mydomain.example.delivery.module.delivery;

import com.mydomain.example.delivery.module.AGDeliveryModuleInstance;
import com.mydomain.example.delivery.module.DeliveryI18n;
import com.softicar.platform.common.core.annotations.Generated;
import com.softicar.platform.common.date.DayTime;
import com.softicar.platform.core.module.access.module.instance.AGModuleInstance;
import com.softicar.platform.db.runtime.field.IDbBooleanField;
import com.softicar.platform.db.runtime.field.IDbDayTimeField;
import com.softicar.platform.db.runtime.field.IDbForeignRowField;
import com.softicar.platform.db.runtime.field.IDbIdField;
import com.softicar.platform.db.runtime.field.IDbStringField;
import com.softicar.platform.db.runtime.logic.AbstractDbObject;
import com.softicar.platform.db.runtime.object.DbObjectTableBuilder;
import com.softicar.platform.db.sql.statement.ISqlSelect;

/**
 * This is the automatically generated class AGDelivery for
 * database table <i>Delivery.Delivery</i>.
 */
@Generated
@SuppressWarnings("all")
public class AGDeliveryGenerated extends AbstractDbObject<AGDelivery> {

	// -------------------------------- STATIC CONSTANTS -------------------------------- //

	// @formatter:off
	private static final DbObjectTableBuilder<AGDelivery, AGDeliveryGenerated> BUILDER = new DbObjectTableBuilder<>("Delivery", "Delivery", AGDelivery::new, AGDelivery.class);
	static {
		BUILDER.setTitle(DeliveryI18n.DELIVERY);
		BUILDER.setPluralTitle(DeliveryI18n.DELIVERIES);
	}

	public static final IDbIdField<AGDelivery> ID = BUILDER.addIdField("id", o->o.m_id, (o,v)->o.m_id=v).setTitle(DeliveryI18n.ID);
	public static final IDbForeignRowField<AGDelivery, AGDeliveryModuleInstance, AGModuleInstance> DELIVERY_MODULE_INSTANCE = BUILDER.addForeignRowField("deliveryModuleInstance", o->o.m_deliveryModuleInstance, (o,v)->o.m_deliveryModuleInstance=v, AGDeliveryModuleInstance.MODULE_INSTANCE).setTitle(DeliveryI18n.DELIVERY_MODULE_INSTANCE);
	public static final IDbBooleanField<AGDelivery> ACTIVE = BUILDER.addBooleanField("active", o->o.m_active, (o,v)->o.m_active=v).setTitle(DeliveryI18n.ACTIVE).setDefault(true);
	public static final IDbStringField<AGDelivery> NUMBER = BUILDER.addStringField("number", o->o.m_number, (o,v)->o.m_number=v).setTitle(DeliveryI18n.NUMBER).setMaximumLength(255);
	public static final IDbDayTimeField<AGDelivery> DATE = BUILDER.addDayTimeField("date", o->o.m_date, (o,v)->o.m_date=v).setTitle(DeliveryI18n.DATE).setDefaultNow();
	public static final AGDeliveryTable TABLE = new AGDeliveryTable(BUILDER);
	// @formatter:on

	// -------------------------------- STATIC FUNCTIONS -------------------------------- //

	public static ISqlSelect<AGDelivery> createSelect() {

		return TABLE.createSelect();
	}

	public static AGDelivery get(Integer id) {

		return TABLE.get(id);
	}

	// -------------------------------- GETTERS AND SETTERS -------------------------------- //

	public final AGDeliveryModuleInstance getDeliveryModuleInstance() {

		return getValue(DELIVERY_MODULE_INSTANCE);
	}

	public final AGDelivery setDeliveryModuleInstance(AGDeliveryModuleInstance value) {

		return setValue(DELIVERY_MODULE_INSTANCE, value);
	}

	public final Boolean isActive() {

		return getValue(ACTIVE);
	}

	public final AGDelivery setActive(Boolean value) {

		return setValue(ACTIVE, value);
	}

	public final String getNumber() {

		return getValue(NUMBER);
	}

	public final AGDelivery setNumber(String value) {

		return setValue(NUMBER, value);
	}

	public final DayTime getDate() {

		return getValue(DATE);
	}

	public final AGDelivery setDate(DayTime value) {

		return setValue(DATE, value);
	}

	// -------------------------------- UTILS -------------------------------- //

	@Override
	public final AGDeliveryTable table() {

		return TABLE;
	}

	// -------------------------------- FIELD MEMBERS -------------------------------- //

	private Integer m_id;
	private AGDeliveryModuleInstance m_deliveryModuleInstance;
	private Boolean m_active;
	private String m_number;
	private DayTime m_date;
}

