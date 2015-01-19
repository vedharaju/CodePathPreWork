package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {
    EditText etEditItm;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String editText = getIntent().getStringExtra("edit_text");
        position = getIntent().getIntExtra("position", 0);
        etEditItm = (EditText) findViewById(R.id.etEditItm);
        etEditItm.setText(editText);
        etEditItm.requestFocus();
        etEditItm.setSelection(editText.length());
    }

    public void onSaveItem(View v) {
        Intent savedData = new Intent();
        savedData.putExtra("saved_item", etEditItm.getText().toString());
        savedData.putExtra("position", position);
        setResult(RESULT_OK, savedData);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
