package eri.cs193aproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    //ListView myView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = new ArrayList<String>();
        ListView list = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);

        list.setAdapter(arrayAdapter);

        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    public boolean onItemLongClick(AdapterView<?> list, View row, int index, long rowID) {
                        myList.remove(myList.get(index));
                        arrayAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );
    }

    public void addToList(View view) {
        EditText myItem = (EditText) findViewById(R.id.editText);
        String itemText = myItem.getText().toString();
        if (itemText.trim().length() != 0) {
            myList.add(itemText);
            myItem.setText("");
        }
    }



}
