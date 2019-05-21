package com.example.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private EditText editText;
    private Button buttonOk;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
