package com.hacorp.authen.repository.service;

import java.io.IOException;
import java.util.Map;

import com.hacorp.authen.core.exception.BaseException;


public interface BaseRepositoryService {
	
	
	public boolean save(Map<String, Object> inputParams) throws BaseException;
	
	/**
	   * This is the main method which insert list of data into correspond table.
	   * @param inputParams is a {@link Map} collection that contains document as key and correspond entities as value.
	   * @return true if insert successfully or else false.
	   * @see IOException
	   */
	public boolean saveAll(Map<String, Object> inputParams) throws BaseException;
	
	/**
	   * This is the main method which update data into correspond table.
	   * @param inputParams is a {@link Map} collection that contains document as key and correspond entity as value.
	   * @return true if insert successfully or else false.
	   * @see IOException
	   */
	public boolean update(Map<String, Object> inputParams) throws BaseException;
	
	/**
	   * This is the main method which update data into correspond table.
	   * @param inputParams is a {@link Map} collection that contains document as key and correspond list of entities as value.
	   * @return true if insert successfully or else false.
	   * @see IOException
	   */
	public boolean updateAll(Map<String, Object> inputParams) throws BaseException;
	
	public boolean delete(Map<String, Object> inputParams) throws BaseException;

}
