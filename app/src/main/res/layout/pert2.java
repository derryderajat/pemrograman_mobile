package derry.project.pert2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button btnLogin,btnClear;
    SharedPreferences sharedPreferences;

    public static final String KEY_PREF = "Key Pref";
    public static final String KEY_USERNAME = "admin";
    public static final String KEY_PWD = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(KEY_USERNAME) && (sharedPreferences.contains(KEY_PWD))){
            username.setText(sharedPreferences.getString(KEY_USERNAME,""));
            password.setText(sharedPreferences.getString(KEY_PWD,""));

        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginPreferences();
            }
        });


    }
    public void LoginPreferences(){
        String user=username.getText().toString().trim();
        String pass= password.getText().toString().trim();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME,user);
        editor.putString(KEY_PWD, pass);
        editor.apply();
        Toast.makeText(this, "Username dan Password telah disimpan", Toast.LENGTH_SHORT).show();
    }
    public void ClearEditText(View view){
        username.setText("");
        password.setText("");
    }
}
