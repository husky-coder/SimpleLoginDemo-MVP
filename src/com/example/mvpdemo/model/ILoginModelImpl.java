package com.example.mvpdemo.model;

import android.os.Handler;

/**
 * 业务逻辑实现类
 * 
 * @author luhailong
 * 
 */
public class ILoginModelImpl implements ILoginModel {

	@Override
	public void login(final String name, final String pwd,
			final OnLoginListener loginListener) {
		// TODO Auto-generated method stub
		loginListener.onShowDialog(); // 回调显示对话框
		new Handler().postDelayed(new Runnable() {
			// 模拟登陆耗时操作(3s)
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if ("123".equals(name) && "123".equals(pwd))
					loginListener.onLoginSuc("SUC");
				else
					loginListener.onLoginFail("FAIL");
				loginListener.onDismissDialog(); // 回调隐藏对话框
			}
		}, 3000);
	}

}
