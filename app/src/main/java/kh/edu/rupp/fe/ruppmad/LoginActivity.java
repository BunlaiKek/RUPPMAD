package kh.edu.rupp.fe.ruppmad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    public static final String KEY_USERNAME = "username";
    public static final String PREFERENCE_NAME = "ruppmad.pref";
    public static final String USER_PREFERENCE = "user.pref";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String DOB_KEY = "dob";

    private final String USERNAME = "rupp-fe";
    private final String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is logged in
        String username = getRememberedUsername();
        if(username == null){
            setContentView(R.layout.activity_login);
            Button btnLogin = (Button) findViewById(R.id.btn_login);
            btnLogin.setOnClickListener(this);
        }else{
            startMainActivityAndFinishLoginActivity(username);
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            EditText etxtUsername = (EditText) findViewById(R.id.etxt_username);
            String username = etxtUsername.getText().toString();
            EditText etxtPassword = (EditText) findViewById(R.id.etxt_password);
            String password = etxtPassword.getText().toString();
            if (username.equals(USERNAME) && password.equals(PASSWORD)){

                // Check remember me
                CheckBox chkRemeberMe = (CheckBox)findViewById(R.id.chk_remember_me);
                if(chkRemeberMe.isChecked()){
                    // Remember user logged in
                    rememberLoggedIn(username);
                }
                startMainActivityAndFinishLoginActivity(username);
            }else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void rememberLoggedIn(String username){
        SharedPreferences preference = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    private String getRememberedUsername(){
        SharedPreferences preference = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        String username = preference.getString(KEY_USERNAME, null);
        return username;
    }

    private void startMainActivityAndFinishLoginActivity(String username){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }

}
