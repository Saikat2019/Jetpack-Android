package com.kajal.roomdb;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateFragment extends Fragment {

    private EditText updateId;
    private EditText updateName;
    private EditText updateEmail;

    private Button btnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        updateId = view.findViewById(R.id.updateUserID);
        updateName = view.findViewById(R.id.updateUserName);
        updateEmail = view.findViewById(R.id.updateUserEmail);
        btnUpdate = view.findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(updateId.getText().toString());
                String name = updateName.getText().toString();
                String email = updateEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);

                Toast.makeText(getActivity(),"User successfully updated",Toast.LENGTH_LONG).show();

                updateId.setText("");
                updateName.setText("");
                updateEmail.setText("");
            }
        });
        return view;
    }


}
