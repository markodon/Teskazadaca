package com.example.markodonovski.teskazadaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.next)
    Button kopcenext;
    @BindView(R.id.name)
    EditText ime;
    String ime1;
    @BindView(R.id.lastname)
    EditText prezime;
    String prezime1;
    @BindView(R.id.username)
    EditText userime;
    String userime1;
    @BindView(R.id.radio1)
    RadioButton r1;
    @BindView(R.id.radio2)
    RadioButton r2;
    @BindView(R.id.grupa)
    RadioGroup gr;
    char gender = 'N';
    User klasa;
//    static int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.hasExtra("EDIT")) {
            klasa = (User) intent.getSerializableExtra("EDIT");
            ime.setText(klasa.getName());
            prezime.setText(klasa.getLastname());
            userime.setText(klasa.getUsername());
            gender = klasa.getGender();
            if (gender == 'M') {
                r2.setChecked(true);
                gender = 'M';
            } else {
                r1.setChecked(true);
                gender = 'F';
            }
        } else if (intent.hasExtra("ADD")) {
            klasa = (User) intent.getSerializableExtra("ADD");
        }

    }

    @OnClick(R.id.next)
    public void OnClick(View view) {
        Intent intent = getIntent();
        ime1 = ime.getText().toString();
        prezime1 = prezime.getText().toString();
        userime1 = userime.getText().toString();
        klasa = new User(ime1, prezime1, userime1, gender);
        if (intent.hasExtra("EDIT") || intent.hasExtra("ADD")) {
            intent.putExtra("ADD_USER", klasa);
            setResult(RESULT_OK, intent);
            finish();


        } else {
            intent = new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("EXTRA_U", klasa);
            startActivity(intent);

        }


    }

    @OnClick({R.id.radio1, R.id.radio2})
    public void onRadioButtonClicked(RadioButton radioB) {

        boolean checked = radioB.isChecked();

        switch (radioB.getId()) {
            case R.id.radio1:
                if (checked) {

                    gender = 'F';

                }
                break;
            case R.id.radio2:
                if (checked) {
                    gender = 'M';
                }
                break;
        }
    }


}
