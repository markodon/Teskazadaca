package com.example.markodonovski.teskazadaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {
    @BindView(R.id.spinner)
    Spinner spi;
    @BindView(R.id.edit)
    Button ed;
    @BindView(R.id.add)
    Button ad;
    @BindView(R.id.imeprezime)
    TextView ip;
    String text;
    @BindView(R.id.slikam)
    ImageView sm;
    @BindView(R.id.slikaz)
    ImageView sz;
    @BindView(R.id.internet)
    TextView internet1;
    @BindView(R.id.radio1)
    RadioButton f;
    @BindView(R.id.radio2)
    RadioButton m;
    @BindView(R.id.grupa)
    RadioGroup rgrupa;
    String network = "";
    ArrayList<User> users;
    ArrayAdapter<User> mojadapter;
    User guest;
    User user;
    User selektiranuser;
    static int kluc = 1000;
    static int kluc1 = 1000;
    static int kluc5 = 1000;
    char pol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        sz.setVisibility(View.INVISIBLE);
        sm.setVisibility(View.INVISIBLE);


        users = new ArrayList<>();

        Intent intent = getIntent();
        if (intent.hasExtra("EXTRA_U")) {
            user = (User) intent.getSerializableExtra("EXTRA_U");
            users.add(user);
//           ip.setText(user + "") ;

        }
        if (intent.hasExtra("GUEST")) {
            guest = (User) intent.getSerializableExtra("GUEST");
            users.add(guest);
        }


        mojadapter = new ArrayAdapter<User>(this, android.R.layout.simple_expandable_list_item_1, users);
        spi.setAdapter(mojadapter);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selektiranuser = mojadapter.getItem(position);
                pol = selektiranuser.getGender();
                text = selektiranuser.getName() + " " + selektiranuser.getLastname();
                ip.setText(text);
                if (pol == 'F') {
                    sz.setVisibility(View.VISIBLE);

                }
                if (pol == 'M') {
                    sm.setVisibility(View.VISIBLE);
                }

                rgrupa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int check = rgrupa.getCheckedRadioButtonId();


                        switch (check) {
                            case R.id.radio1:
                                pol = 'F';
                                selektiranuser.setGender('F');
                                sz.setVisibility(View.VISIBLE);
                                sm.setVisibility(View.INVISIBLE);
                                break;

                            case R.id.radio2:
                                pol = 'M';
                                selektiranuser.setGender('M');
                                sm.setVisibility(View.VISIBLE);
                                sz.setVisibility(View.INVISIBLE);
                                break;


                        }


                    }
                });
//

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @OnClick(R.id.edit)
    public void EditUser(View view) {
        Intent edit = new Intent(this, Main2Activity.class);
        edit.putExtra("EDIT", (Serializable) selektiranuser);
        startActivityForResult(edit, kluc1);
    }

    @OnClick(R.id.add)
    public void AddUser(View view) {

        Intent add = new Intent(this, Main2Activity.class);
        add.putExtra("ADD", user);
        startActivityForResult(add, kluc);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == kluc || resultCode == RESULT_OK && requestCode == kluc1 || resultCode == RESULT_OK && requestCode == kluc5) {
            if (data.hasExtra("ADD_USER")) {
                User user = (User) data.getSerializableExtra("ADD_USER");
                users.add(user);
                mojadapter = new ArrayAdapter<User>(this, android.R.layout.simple_expandable_list_item_1, users);
                spi.setAdapter(mojadapter);

            }

           else if (data.hasExtra("NET")){
                network = data.getStringExtra("NET");
                internet1.setText(network);
            }

        }
    }

    @OnClick(R.id.check)
    public void Check(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivityForResult(intent,kluc5);
    }
}
