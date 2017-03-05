package com.kitchenforhire.kitchenhire;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import com.kitchenforhire.kitchenhire.CreateRealmObjects;
import com.kitchenforhire.kitchenhire.RealmObjects.User;


public class AddUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                String name = ((EditText)findViewById(R.id.editName)).getText().toString();
                long phone = 0;
                try {
                    phone = Long.parseLong(((EditText) findViewById(R.id.editPhone)).getText().toString(), 10);
                } catch(NumberFormatException E)
                {
                    Toast.makeText(getApplicationContext(), "Invalid number!", Toast.LENGTH_LONG).show();
                    return;
                }

                String address = ((EditText)findViewById(R.id.editAddress)).getText().toString();
                String mail = ((EditText)findViewById(R.id.editEmail)).getText().toString();

                CreateRealmObjects letsCreate = new CreateRealmObjects(getApplicationContext());

                User created = letsCreate.addUser(name, phone, address, mail);
                Toast.makeText(getApplicationContext(), created.name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
