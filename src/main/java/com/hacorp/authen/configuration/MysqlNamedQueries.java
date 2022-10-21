/**
 * 
 */
package com.hacorp.authen.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class MysqlNamedQueries extends HashMap<String, String> {
	private static final long serialVersionUID = 1060286526025776068L;

	public MysqlNamedQueries(Map<String, String> namedQueries) {
		super(namedQueries);
		System.out.print("Hoang ffffffffffffffffffffffffff");
	}

}
