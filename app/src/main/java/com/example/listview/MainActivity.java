package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener  {

    private EditText Text;
    private ListView list;
    private Button button;


    private ArrayList<String> tareas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        list = findViewById(R.id.tasklist);


        tareas = Save.leertareas(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tareas);
        list.setAdapter(adapter);
        button.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        tareas.remove(i);
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"Tarea eliminada", Toast.LENGTH_LONG).show();
        return true;
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button:
                String itemEntered = Text.getText().toString();
                adapter.add(itemEntered);
                Text.setText("");
                Save.guardar(tareas,this);
                Toast.makeText(this, "La tarea fue agregada", Toast.LENGTH_LONG).show();
                break;
        }
    }



}
