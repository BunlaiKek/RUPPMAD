package kh.edu.rupp.fe.ruppmad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Kek Bunlai on 07-May-17.
 */

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String USER_PREF = "user.pref";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String DOB_KEY = "dob";
    public TextView textName;
    public TextView textEmail;
    public TextView textDob;
    public Button btnOk;
    public Button btnEdit;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textName = (TextView) findViewById(R.id.txt_namecontent);
        textEmail = (TextView)findViewById(R.id.txt_emailcontent);
        textDob = (TextView)findViewById(R.id.txt_dobcontent);
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(this);
        if (setContentFromSharePref() == null)
        {
            createSharePref();
        }
        setContentFromSharePref();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ok)
        {
            goBack();
        }
        if (v.getId() == R.id.btn_edit)
        {
            goToEdith();
        }
    }
    public void createSharePref()
    {
        String name = "Sok Sao";
        String email = "soksao@gmail.com";
        String dob = "12/12/1995";
        SharedPreferences preferences = getSharedPreferences(USER_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NAME_KEY,name);
        editor.putString(EMAIL_KEY,email);
        editor.putString(DOB_KEY,dob);
        editor.commit();
        Log.d("Bunlai","SharePreference is created");
    }
    public String setContentFromSharePref()
    {
        SharedPreferences preferences = getSharedPreferences(USER_PREF,MODE_PRIVATE);
        textEmail.setText(preferences.getString(EMAIL_KEY,null));
        textName.setText(preferences.getString(NAME_KEY,null));
        textDob.setText(preferences.getString(DOB_KEY,null));
        return preferences.getString(NAME_KEY,null);
    }
    public void goBack()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToEdith()
    {
        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);
    }
}
