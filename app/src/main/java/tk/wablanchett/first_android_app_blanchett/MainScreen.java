package tk.wablanchett.first_android_app_blanchett;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    ArrayList<String> peoplelist;
    int numppl = 1;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        peoplelist = new ArrayList<>(5);

        ListView sL = (ListView) findViewById(R.id.showList);
        Button aP = (Button) findViewById(R.id.addlist);

        aP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPerson();
            }
        });



        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peoplelist);
        sL.setAdapter(adapter);

        sL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String oletext = peoplelist.get(position).toString();
                peoplelist.remove(position);
                numppl -= 1;
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), oletext + " has been removed", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        sL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                makeDia(position);


/**



 */

            }
        });

    }

    public void addPerson() {
        String newperson = "Player Number " + numppl;
        peoplelist.add(newperson);
        numppl += 1;
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), newperson + " added", Toast.LENGTH_SHORT).show();
    }

    public void makeDia(final int pos){
        //Dialogue
        final String curtxt = peoplelist.get(pos).toString();
        AlertDialog.Builder popup = new AlertDialog.Builder(this);
        popup.setTitle("Rename " + curtxt);

        final EditText rename = new EditText(getApplicationContext());
        rename.setInputType(InputType.TYPE_CLASS_TEXT);
        popup.setView(rename);

        popup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                peoplelist.set(pos, rename.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),curtxt + " has been renamed!",Toast.LENGTH_SHORT).show();
            }
        });

        popup.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );

        AlertDialog al = popup.create();
        al.show();
    }




}
