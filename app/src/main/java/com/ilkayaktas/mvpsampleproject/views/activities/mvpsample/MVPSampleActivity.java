package com.ilkayaktas.mvpsampleproject.views.activities.mvpsample;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ilkayaktas.mvpsampleproject.R;
import com.ilkayaktas.mvpsampleproject.views.activities.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by ilkay on 02/08/2017.
 * TODO: DO NOT EDIT THIS CLASS SINCE THIS IS A TEMPLATE CLASS.
 */

public class MVPSampleActivity extends BaseActivity implements MVPSampleView {
	
	@Inject
	MVPSamplePresenter<MVPSampleView> presenter;

	@BindView(R.id.toolbar_title) TextView toolbarTitle;
	@BindView(R.id.tv_question) TextView question;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getActivityComponent().inject(this);

		// ButterKnife binder
		setUnBinder(ButterKnife.bind(this));
		
		// attach presenter
		presenter.onAttach(MVPSampleActivity.this);

		initUI();
	}

	@Override
	protected int getActivityLayout() {
		return R.layout.activity_mvpsample;
	}

	@Override
	protected void initUI() {
		setFont();
	}

	@Override
	protected void onDestroy() {
		// deteach is necessary to prevent memory leak
		presenter.onDetach();
		super.onDestroy();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			
			finish();
			
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	private void setFont(){
		toolbarTitle.setTypeface(fontGothic);
	}

	@OnClick(R.id.b_sorulari_goster)
	public void showQuestions(View v){
		// just call presenter methot to get questions. You don't know what happens inside or where are questions are located
		presenter.getQuestion();
	}

	@Override
	public void updateViewWithQuestions(String questionText) {
		// update text view on method invocation.
		question.setText(questionText);
	}
}
