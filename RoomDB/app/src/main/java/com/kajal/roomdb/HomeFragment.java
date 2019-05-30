package com.kajal.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button btnAdd;
    private Button btnRead;
    private Button btnDelete;
    private Button btnUpdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnAdd = view.findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(this);
        btnRead = view.findViewById(R.id.buttonView);
        btnRead.setOnClickListener(this);
        btnDelete = view.findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(this);
        btnUpdate = view.findViewById(R.id.buttonUpdate);
        btnUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAdd :
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new AddUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.buttonView :
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new ReadUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.buttonDelete :
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new DeleteUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.buttonUpdate :
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new UpdateFragment())
                        .addToBackStack(null)
                        .commit();
                break;

        }
    }
}
