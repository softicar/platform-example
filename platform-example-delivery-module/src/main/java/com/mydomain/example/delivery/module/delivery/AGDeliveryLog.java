package com.mydomain.example.delivery.module.delivery;

import com.mydomain.example.delivery.module.DeliveryI18n;
import com.softicar.platform.common.container.tuple.Tuple2;
import com.softicar.platform.common.core.annotations.Generated;
import com.softicar.platform.common.date.DayTime;
import com.softicar.platform.core.module.transaction.AGTransaction;
import com.softicar.platform.db.runtime.field.IDbBooleanField;
import com.softicar.platform.db.runtime.field.IDbDayTimeField;
import com.softicar.platform.db.runtime.field.IDbForeignField;
import com.softicar.platform.db.runtime.field.IDbStringField;
import com.softicar.platform.db.runtime.key.DbTableKeyFactory;
import com.softicar.platform.db.runtime.key.IDbTableKey;
import com.softicar.platform.db.runtime.record.AbstractDbRecord;
import com.softicar.platform.db.runtime.record.DbRecordTable;
import com.softicar.platform.db.runtime.table.DbTableBuilder;

/**
 * This is the automatically generated class AGDeliveryLog for
 * database table <i>Delivery.DeliveryLog</i>.
 */
@Generated
@SuppressWarnings("all")
public class AGDeliveryLog extends AbstractDbRecord<AGDeliveryLog, Tuple2<AGDelivery, AGTransaction>> {

	// -------------------------------- STATIC CONSTANTS -------------------------------- //

	// @formatter:off
	private static final DbTableBuilder<AGDeliveryLog, AGDeliveryLog, Tuple2<AGDelivery, AGTransaction>> BUILDER = new DbTableBuilder<>("Delivery", "DeliveryLog", AGDeliveryLog::new, AGDeliveryLog.class);
	static {
		BUILDER.setTitle(DeliveryI18n.DELIVERY_LOG);
		BUILDER.setPluralTitle(DeliveryI18n.DELIVERY_LOGS);
	}

	public static final IDbForeignField<AGDeliveryLog, AGDelivery> DELIVERY = BUILDER.addForeignField("delivery", o->o.m_delivery, (o,v)->o.m_delivery=v, AGDelivery.ID).setTitle(DeliveryI18n.DELIVERY);
	public static final IDbForeignField<AGDeliveryLog, AGTransaction> TRANSACTION = BUILDER.addForeignField("transaction", o->o.m_transaction, (o,v)->o.m_transaction=v, AGTransaction.ID).setTitle(DeliveryI18n.TRANSACTION);
	public static final IDbBooleanField<AGDeliveryLog> ACTIVE = BUILDER.addBooleanField("active", o->o.m_active, (o,v)->o.m_active=v).setTitle(DeliveryI18n.ACTIVE).setNullable().setDefault(null);
	public static final IDbStringField<AGDeliveryLog> NUMBER = BUILDER.addStringField("number", o->o.m_number, (o,v)->o.m_number=v).setTitle(DeliveryI18n.NUMBER).setNullable().setDefault(null).setMaximumLength(255);
	public static final IDbDayTimeField<AGDeliveryLog> DATE = BUILDER.addDayTimeField("date", o->o.m_date, (o,v)->o.m_date=v).setTitle(DeliveryI18n.DATE).setNullable().setDefault(null);
	public static final IDbTableKey<AGDeliveryLog, Tuple2<AGDelivery, AGTransaction>> PRIMARY_KEY = BUILDER.setPrimaryKey(DbTableKeyFactory.createKey(DELIVERY, TRANSACTION));
	public static final DbRecordTable<AGDeliveryLog, Tuple2<AGDelivery, AGTransaction>> TABLE = new DbRecordTable<>(BUILDER);
	// @formatter:on

	// -------------------------------- CONSTRUCTORS -------------------------------- //

	protected AGDeliveryLog() {

		// protected
	}

	// -------------------------------- GETTERS AND SETTERS -------------------------------- //

	public final Integer getDeliveryID() {

		return getValueId(DELIVERY);
	}

	public final AGDelivery getDelivery() {

		return getValue(DELIVERY);
	}

	public final Integer getTransactionID() {

		return getValueId(TRANSACTION);
	}

	public final AGTransaction getTransaction() {

		return getValue(TRANSACTION);
	}

	public final Boolean isActive() {

		return getValue(ACTIVE);
	}

	public final AGDeliveryLog setActive(Boolean value) {

		return setValue(ACTIVE, value);
	}

	public final String getNumber() {

		return getValue(NUMBER);
	}

	public final AGDeliveryLog setNumber(String value) {

		return setValue(NUMBER, value);
	}

	public final DayTime getDate() {

		return getValue(DATE);
	}

	public final AGDeliveryLog setDate(DayTime value) {

		return setValue(DATE, value);
	}

	// -------------------------------- UTILS -------------------------------- //

	@Override
	public final DbRecordTable<AGDeliveryLog, Tuple2<AGDelivery, AGTransaction>> table() {

		return TABLE;
	}

	// -------------------------------- FIELD MEMBERS -------------------------------- //

	private AGDelivery m_delivery;
	private AGTransaction m_transaction;
	private Boolean m_active;
	private String m_number;
	private DayTime m_date;
}

