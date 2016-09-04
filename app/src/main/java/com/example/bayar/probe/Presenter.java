package com.example.bayar.probe;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements PresenterInterface {

    private static final String TAG = Presenter.class.getSimpleName();
    private static List<User> mUserList = new ArrayList<>();
    private MainActivity mMainActivity;
    private Context mContext;

    public Presenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mContext = mainActivity;
    }

    public void methodWithAllMightyLogic() {
        Log.d(TAG, "methodWithAllMightyLogic: ");
        String firstName = getFirstName().toString();
        String lastName = getLastName().toString();
        Log.d(TAG, "firstName.length(): " + firstName.length());

        if (firstName.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(mContext, "empty value detected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "values is correct", Toast.LENGTH_SHORT).show();
            updateModel(new User(firstName, lastName));
        }
    }

    private void updateModel(User user) {
        Log.d(TAG, "updateModel: ");
        mUserList.add(user);
        Log.d(TAG, "user added, mUserList.size(): " + mUserList.size());
    }

    @Override
    public EditText getFirstName() {
        return mMainActivity.getFirstName();
    }

    @Override
    public EditText getLastName() {
        return mMainActivity.getLastName();
    }
}
