package com.kajal.roomdb;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView txtInfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        txtInfo = view.findViewById(R.id.displayTable);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

        String info = "";

        for (User usr : users){
            int id = usr.getId();
            String Name = usr.getName();
            String Email = usr.getEmail();

            info = info + "\n\n ID : " +id+ "\n Name : " +Name+ "\n Email : " + Email;
        }

        txtInfo.setText(info);

        return view;
    }

}
