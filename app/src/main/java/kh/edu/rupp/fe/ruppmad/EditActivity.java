package kh.edu.rupp.fe.ruppmad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Kek Bunlai on 07-May-17.
 */

public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String USER_PREF = "user.pref";
    public static final String NAME_KEY = "name";
    public static final String EMAIL_KEY = "email";
    public static final String DOB_KEY = "dob";
    public EditText editTextName;
    public EditText editTextEmail;
    public EditText editTextDob;
    public Button buttonSave;
    public Button buttonCancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editTextName = (EditText)findViewById(R.id.edtxt_name);
        editTextEmail = (EditText)findViewById(R.id.edtxt_email);
        editTextDob = (EditText)findViewById(R.id.edtxt_dob);
        buttonSave = (Button)findViewById(R.id.btn_save);
        buttonSave.setOnClickListener(this);
        buttonCancel = (Button)findViewById(R.id.btn_cancel);
        buttonCancel.setOnClickListener(this);
        setDataFromSharedPref();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_cancel)
        {
            goBackToProfile();
        }
        if(v.getId() == R.id.btn_save)
        {
            saveAndGoBackToProfile();
        }

    }
    public void setDataFromSharedPref()
    {
        SharedPreferences preferences = getSharedPreferences(USER_PREF,MODE_PRIVATE);
        editTextName.setText(preferences.getString(NAME_KEY,null));
        editTextEmail.setText(preferences.getString(EMAIL_KEY,null));
        editTextDob.setText(preferences.getString(DOB_KEY,null));
    }
    public void goBackToProfile()
    {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
        finish();
    }
    public void saveAndGoBackToProfile()
    {
        String nameValue = editTextName.getText().toString();
        String emailValue = editTextEmail.getText().toString();
        String dobValue = editTextDob.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(USER_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY,nameValue);
        editor.putString(EMAIL_KEY,emailValue);
        editor.putString(DOB_KEY,dobValue);
        editor.commit();
        goBackToProfile();
    }

}
