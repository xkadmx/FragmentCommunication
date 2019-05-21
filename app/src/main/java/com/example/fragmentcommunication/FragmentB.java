package com.example.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private Button buttonOk;

    public interface FragmentBListener{
        void onInputBSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b,  container, false);

        editText = v.findViewById(R.id.edit_text);
        buttonOk = v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText(); // getting input from editText widget
                listener.onInputBSent(input); // using interface method to send text to activity
            }
        });

        return v;
    }
    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context) { //callback method
        super.onAttach(context);
        if (context instanceof FragmentBListener) { //context is our activity; checking if activity implements interface
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}


