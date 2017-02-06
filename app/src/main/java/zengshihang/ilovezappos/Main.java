package zengshihang.ilovezappos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.content.Context;

public class Main extends AppCompatActivity {
    private EditText search;
    private Button button;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (EditText) findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button2);
        context = Main.this;

        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                String target = search.getText().toString();
                Intent intent = new Intent(context,SearchResult.class);
                intent.putExtra(target,"target");
                startActivity(intent);

            }
        });
    }



}
