package io.destreza.android_component.MVVM.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import io.destreza.android_component.MVVM.model.LoginUser;
import io.destreza.android_component.R;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick(View view) {


        LoginUser loginUser = new LoginUser(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(loginUser);

        switch (view.getId())
        {
            case R.id.sendBtn:
                Log.e("key","Send Button");
                break;
            case R.id.btnLogin:
                Log.e("key","onClick Method");
                break;
        }

    }
}
