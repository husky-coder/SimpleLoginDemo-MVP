package com.example.mvpdemo.model;

/**
 * 业务逻辑接口
 * 
 * @author luhailong
 * 
 */
public interface ILoginModel {

	void login(String name, String pwd, OnLoginListener loginListener);

	interface OnLoginListener {
		void onShowDialog();

		void onDismissDialog();

		void onLoginSuc(String sucMessage);

		void onLoginFail(String failMessage);
	}

}
