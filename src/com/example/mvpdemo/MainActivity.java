package com.example.mvpdemo;

import com.example.mvpdemo.presenter.ILoginPresenter;
import com.example.mvpdemo.view.ILoginView;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements ILoginView {

	// 中间者
	private ILoginPresenter iLoginPresenter;
	// 带滚动控件的弹出框
	private Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初始化输入框
		final EditText name = ((EditText) findViewById(R.id.name));
		final EditText pwd = ((EditText) findViewById(R.id.pwd));

		// 初始化dialog
		dialog = new ProgressDialog(this);
		dialog.setTitle("登陆中...");

		// 设置登录按钮事件监听
		findViewById(R.id.login).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				// 初始化中间者
				iLoginPresenter = new ILoginPresenter(MainActivity.this);
				// 执行登陆操作
				iLoginPresenter.doLogin(name.getText().toString(), pwd
						.getText().toString());
			}
		});

	}

	@Override
	public void showDialog() {
		// TODO Auto-generated method stub
		dialog.show();
	}

	@Override
	public void dismissDialog() {
		// TODO Auto-generated method stub
		dialog.dismiss();
	}

	@Override
	public void loginSuc(String sucMessage) {
		// TODO Auto-generated method stub
		Toast.makeText(this, sucMessage, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void loginFail(String failMessage) {
		// TODO Auto-generated method stub
		Toast.makeText(this, failMessage, Toast.LENGTH_SHORT).show();
	}
}
