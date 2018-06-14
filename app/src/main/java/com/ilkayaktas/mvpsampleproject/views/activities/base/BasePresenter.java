package com.ilkayaktas.mvpsampleproject.views.activities.base;

/**
 * Created by iaktas on 10.03.2017.
 */

import com.ilkayaktas.mvpsampleproject.controller.IDataManager;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter <V extends MvpView> implements MvpPresenter<V> {

    private final IDataManager IDataManager;

    private V mMvpView;

    public BasePresenter(IDataManager IDataManager) {
        this.IDataManager = IDataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public IDataManager getIDataManager() {
        return IDataManager;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
