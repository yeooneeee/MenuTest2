package com.example.menutest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        registerForContextMenu(tv1);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red :
                tv1.setBackgroundColor(Color.RED); return true;
            case R.id.green:
                tv1.setBackgroundColor(Color.GREEN); return true;
            case R.id.blue:
                tv1.setBackgroundColor(Color.BLUE); return true;
        }
        return super.onContextItemSelected(item);
    }


    public void onClick(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.inflate(R.menu.popupmenu);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.smp:
                        tv1.setText(R.string.text_smp); return true;
                    case R.id.advp:
                        tv1.setText(R.string.text_advp); return true;
                    case R.id.db:
                        tv1.setText(R.string.text_db); return true;
                }
                return false;
            }
        });
        popup.show();
    }
}