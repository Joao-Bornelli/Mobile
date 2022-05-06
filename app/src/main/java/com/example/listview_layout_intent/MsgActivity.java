package com.example.listview_layout_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MsgActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        TextView txt = findViewById(R.id.txtTitulo);

        //Capturar o intent
        Intent i = getIntent();
        String nome = i.getStringExtra("O_nome");
        txt.setText(nome);
    }
}
