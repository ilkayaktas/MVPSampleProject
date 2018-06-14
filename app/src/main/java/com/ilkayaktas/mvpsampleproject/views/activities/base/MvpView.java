package com.ilkayaktas.mvpsampleproject.views.activities.base;

/**
 * Created by ilkay on 09/03/2017.
 */

import android.support.annotation.StringRes;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

	/**
	 * Show progress dialog
	 */
	void showLoading();

	/**
	 * Hide progress dialog
	 */
	void hideLoading();

	/**
	 * Show snack bar error message
	 * @param resId String resource id
	 */
	void onError(@StringRes int resId);

	/**
	 * Show snack bar error message
	 * @param message String message
	 */
	void onError(String message);
	
}
