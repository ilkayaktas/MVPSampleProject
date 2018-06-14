package com.ilkayaktas.mvpsampleproject.controller.db.crud;

import java.util.List;

import io.realm.RealmQuery;


public interface DatabaseManager<E>{
	void saveOrUpdate(Object obj);
	void saveOrUpdate(Iterable<E> objects);
	void saveOrUpdateAsync(Object object);
	List<Object> getAll(Class clss);
	List<Object> getAll(Class clss, String field, boolean isDescending);
	List<Object> get(Class clss, String fieldName, int equalValue);
	List<Object> get(Class clss, String fieldName, boolean equalValue);
	List<Object> get(Class clss, String fieldName, String equalValue);
	List<Object> get(RealmQuery query);
	void close();
	void delete(Class clss, String fieldName, String equalValue);
	void deleteAll(Class clss);
}
