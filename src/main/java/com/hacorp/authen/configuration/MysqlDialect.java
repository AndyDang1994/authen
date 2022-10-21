package com.hacorp.authen.configuration;

import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.annotation.Configuration;

import java.sql.Types;

@Configuration
public class MysqlDialect extends org.hibernate.dialect.MySQLDialect {

	public MysqlDialect() {
		registerColumnType(Types.VARCHAR, 200, "nvarchar2($l)");
		registerColumnType(Types.VARCHAR, 255, "nvarchar2($l)");
		registerColumnType(Types.VARCHAR, 4000, "nvarchar2($l)");
		registerColumnType(Types.VARCHAR, "nvarchar2(max)");
		registerColumnType(Types.DECIMAL, "number($p,$s)");
		
		registerHibernateType(Types.DECIMAL, "big_decimal");
		registerHibernateType(Types.NCLOB, StandardBasicTypes.CLOB.getName());
		registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
		registerColumnType(Types.LONGNVARCHAR, "NUMBER");
	}
}
