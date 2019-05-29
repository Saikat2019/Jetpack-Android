package com.kajal.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userId;
    private EditText userName;
    private EditText userEmail;

    private Button btnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userId = view.findViewById(R.id.userID);
        userName = view.findViewById(R.id.userName);
        userEmail = view.findViewById(R.id.userEmail);

        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idofUser = Integer.parseInt(userId.getText().toString());
                String nameofUser = userName.getText().toString();
                String  emailofUser = userEmail.getText().toString();

                User user = new User();
                user.setId(idofUser);
                user.setName(nameofUser);
                user.setEmail(emailofUser);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(),"User added successfully",Toast.LENGTH_LONG).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });
        return view;
    }

}
