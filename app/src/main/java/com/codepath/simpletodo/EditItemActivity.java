package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra("itemText");
        itemPosition = getIntent().getIntExtra("itemPosition", 0);
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);
        etEditItem.setSelection(etEditItem.getText().length());
    }

    public void onEditItem(View w) {
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        Intent data = new Intent();
        data.putExtra("itemText", etEditItem.getText().toString());
        data.putExtra("itemPosition", itemPosition);
        setResult(RESULT_OK, data);
        finish();
    }

}
