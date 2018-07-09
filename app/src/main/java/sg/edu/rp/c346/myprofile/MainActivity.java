package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);
        rgGender = findViewById(R.id.radioGroupGender);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        Float floatGPA = Float.parseFloat(etGPA.getText().toString());
        Integer intGender = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name" ,strName);
        prefEdit.putFloat("gpa" ,floatGPA);
        prefEdit.putInt("gender" ,intGender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String namemsg =  prefs.getString("name","No Name!");
        Float gpamsg =  prefs.getFloat("gpa", 0);
        Integer gendermsg = prefs.getInt("gender", 0);
        etName.setText(namemsg);
        etGPA.setText(gpamsg.toString());
        rgGender.check(gendermsg);
    }
}

