package com.example.mvpdemo.view;

/**
 * 登陆View接口
 * 
 * @author luhailong
 * 
 */
public interface ILoginView {

	void showDialog();

	void dismissDialog();

	void loginSuc(String sucMessage);

	void loginFail(String failMessage);

}
