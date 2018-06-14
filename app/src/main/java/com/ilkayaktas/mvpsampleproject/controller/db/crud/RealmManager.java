package com.ilkayaktas.mvpsampleproject.controller.db.crud;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

@Singleton
public class RealmManager implements DatabaseManager {

	private Realm realm = null;

	@Inject
	public RealmManager(Realm realm){
		this.realm = realm;
	}

	/**
	 * If RealmObject has primary key, use this function to create or update
	 * @param object RealmObject with primary key
	 */
	@Override
	public void saveOrUpdate(Object object){

		final RealmObject obj = (RealmObject) object;
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm bgRealm) {
				bgRealm.copyToRealmOrUpdate(obj);
			}
		});
	}

	public void saveOrUpdateAsync(Object object){
		final RealmObject obj = (RealmObject) object;

		realm.executeTransactionAsync(new Realm.Transaction() {

				@Override
				public void execute(Realm bgRealm) {
					bgRealm.copyToRealmOrUpdate(obj);
				}
			}, new Realm.Transaction.OnSuccess() {
				@Override
				public void onSuccess() {

				}
			}, new Realm.Transaction.OnError() {
				@Override
				public void onError(Throwable error) {

				}
			});
	}

	@Override
	public void saveOrUpdate(Iterable objects) {
		final Iterable obj = objects;
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm bgRealm) {
				bgRealm.copyToRealmOrUpdate(obj);
			}
		});
	}

	@Override
	public RealmResults getAll(final Class clss){
		return realm.where(clss).findAll();
	}

	@Override
	public RealmResults getAll(Class clss, String field, boolean isDescending) {
		return realm.where(clss).findAll().sort(field, isDescending ? Sort.DESCENDING : Sort.ASCENDING);
	}

	@Override
	public RealmResults get(final Class clss, String fieldName, int equalValue){
		return realm.where(clss).equalTo(fieldName,equalValue).findAll();
	}

	@Override
	public RealmResults get(final Class clss, String fieldName, boolean equalValue){
		return realm.where(clss).equalTo(fieldName,equalValue).findAll();
	}

	@Override
	public RealmResults get(final Class clss, String fieldName, String equalValue){
		return realm.where(clss).equalTo(fieldName,equalValue).findAll();
	}

	@Override
	public RealmResults get(RealmQuery query) {
		return query.findAll();
	}

	@Override
	public void close(){
		realm.close();

		realm = null;
	}
	
	@Override
	public void delete(Class clss, String fieldName, String equalValue) {
		final RealmResults result = get(clss, fieldName, equalValue);
		
		// Delete all results
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				result.deleteAllFromRealm();
			}
		});
	}
	
	public Realm getRealm() {
		return realm;
	}

	@Override
	public void deleteAll(final Class clss) {
		final RealmResults result = getAll(clss);

		// Delete all results
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				result.deleteAllFromRealm();
			}
		});
	}

}
