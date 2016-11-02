package edu.umd.cs.androiddoodle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearDrawingButton = (Button) findViewById(R.id.clear_button);


        clearDrawingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DrawView dv = (DrawView) findViewById(R.id.draw_view);
                dv.clearDrawing();
            }
        });
    }
}
