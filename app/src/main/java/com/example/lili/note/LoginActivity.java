package com.example.lili.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

// AWSMobileClient imports
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.AWSStartupResult;

// AWS SDK sign-in UI imports
import com.amazonaws.mobile.auth.core.IdentityHandler;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.ui.SignInUI;

public class LoginActivity extends AppCompatActivity {

    static final String LOG_TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Add a call to initialize AWSMobileClient
        AWSMobileClient.getInstance().initialize(this).execute();

        // Sign-in listener
        IdentityManager.getDefaultIdentityManager().addSignInStateChangeListener(new SignInStateChangeListener() {
            @Override
            public void onUserSignedIn() {
                Log.d(LOG_TAG, "User Signed In");
            }

            // Sign-out listener
            @Override
            public void onUserSignedOut() {

                Log.d(LOG_TAG, "User Signed Out");
                showSignIn();
            }
        });

        showSignIn();
    }

    private void showSignIn() {
        Log.d(LOG_TAG, "showSignIn");

        SignInUI signin = (SignInUI) AWSMobileClient.getInstance().getClient(LoginActivity.this, SignInUI.class);
        signin.login(LoginActivity.this, Menu.class).execute();
    }
}
