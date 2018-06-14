package com.ilkayaktas.mvpsampleproject.views.activities.mvpsample;


import android.annotation.SuppressLint;
import android.util.Log;
import com.ilkayaktas.mvpsampleproject.model.app.SorularAppModel;
import com.ilkayaktas.mvpsampleproject.views.activities.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilkay on 02/08/2017.
 */

public class MVPSamplePresenterImpl<V extends MVPSampleView> extends BasePresenter<V>
		implements MVPSamplePresenter<V> {

	private static final String TAG = "MVPSamplePresenterImpl";

	List<SorularAppModel> questions = new ArrayList<>();

	public MVPSamplePresenterImpl(com.ilkayaktas.mvpsampleproject.controller.IDataManager IDataManager) {
		super(IDataManager);
	}

	@SuppressLint("CheckResult")
	@Override
	public void getQuestion() {
		// RXJava is used here.
		getIDataManager().getQuestions()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::onNext,
						this::onError,
						this::onComplete);
	}

	private void onError(Throwable throwable) {
		Log.e(TAG, "onError: " + throwable.getMessage());
	}

	private void onNext(SorularAppModel sorularAppModel) {
		questions.add(sorularAppModel);
	}

	private void onComplete() {
		String generatedText = "";

		// Generate text
		for (SorularAppModel question : questions) {
		    generatedText += question.soru + "\n";
		}

		// update ui here. You don't know what happens on UI.
		getMvpView().updateViewWithQuestions(generatedText);
	}
}
