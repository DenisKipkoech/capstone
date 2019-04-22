package com.example.denis.podcatch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.denis.podcatch.Models.AppPreferences;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class SignInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private boolean isSignedIn;
    private SignInButton signInButton;
    private GoogleApiClient apiClient;
    private static final int REQ_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInButton = findViewById(R.id.bt_sign_google);

        isSignedIn = AppPreferences.checkIfSignedIn(this);
        if (!isSignedIn){
            GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(
                    GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

            apiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                    .build();

            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = Auth.GoogleSignInApi.getSignInIntent(apiClient);
                    startActivityForResult(intent, REQ_CODE);
                }
            });

        }else {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);

            startActivity(intent);
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE){
            GoogleSignInResult signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(signInResult);
        }

    }

    public void handleResult(GoogleSignInResult signInResult){
        GoogleSignInAccount signInAccount = signInResult.getSignInAccount();

        String name = signInAccount.getDisplayName();
        String email = signInAccount.getEmail();

        AppPreferences.setUserDetails(this, name, email, true);
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
