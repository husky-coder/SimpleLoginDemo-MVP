package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.ILoginModel;
import com.example.mvpdemo.model.ILoginModel.OnLoginListener;
import com.example.mvpdemo.model.ILoginModelImpl;
import com.example.mvpdemo.view.ILoginView;

/**
 * 登陆中间者
 * 
 * @author luhailong
 * 
 */
public class ILoginPresenter {

	private ILoginView iLoginView;
	private ILoginModel iLoginModel;

	public ILoginPresenter(ILoginView iLoginView) {
		// TODO Auto-generated constructor stub
		this.iLoginView = iLoginView;
		this.iLoginModel = new ILoginModelImpl();
	}

	public void doLogin(String name, String pwd) {
		if (iLoginModel != null) {
			iLoginModel.login(name, pwd, new OnLoginListener() {

				@Override
				public void onLoginSuc(String sucMessage) {
					// TODO Auto-generated method stub
					iLoginView.loginSuc(sucMessage);
				}

				@Override
				public void onShowDialog() {
					// TODO Auto-generated method stub
					iLoginView.showDialog();
				}

				@Override
				public void onDismissDialog() {
					// TODO Auto-generated method stub
					iLoginView.dismissDialog();
				}

				@Override
				public void onLoginFail(String failMessage) {
					// TODO Auto-generated method stub
					iLoginView.loginFail(failMessage);
				}
			});
		}
	}

}
