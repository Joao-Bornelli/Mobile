package com.example.listview_layout_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity{
    static String [] nomes = new String[] {"João", "Pedrinho", "Carlos", "Luiza", "James","Vegas","Bryan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ListView lv = findViewById(R.id.listUsuarios);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Snackbar snackbar = Snackbar.make(view,"Clicou no item: " + i,BaseTransientBottomBar.LENGTH_LONG);
                    snackbar.show();

                    Intent intent = new Intent(getBaseContext(),MsgActivity.class);
                    intent.putExtra("O_nome: ", nomes[i]);
                    startActivity(intent);
                }
            });
            lv.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return nomes.length;
                }

                @Override
                public Object getItem(int i) {
                    return nomes[i];
                }

                @Override
                public long getItemId(int i) {
                    return i;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {

                    if (view == null){
                        view = getLayoutInflater().inflate(R.layout.layout_linha, viewGroup, false);
                    }
                    TextView temp = view.findViewById(R.id.txtPrincipal);
                    temp.setText(nomes[i]);
                    return view;
                }
            });
    }
}