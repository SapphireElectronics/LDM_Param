package ca.sapphire.ldmparam;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private Button calc_button;
    private Spinner bin_spinner;
    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> bins = new ArrayList<>();
        bins.add("C");
        bins.add("D");
        bins.add("ALL");

        ArrayAdapter<CharSequence> adapter;
        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item);

        for( String bin : bins )
            adapter.add( bin );

        bin_spinner = (Spinner) findViewById(R.id.bin_spinner);
        bin_spinner.setAdapter(adapter);

        addListenerOnCalcButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void addListenerOnCalcButton() {
        calc_button = (Button) findViewById(R.id.calc_button);
        bin_spinner = (Spinner) findViewById(R.id.bin_spinner);
        result_text = (TextView) findViewById(R.id.result_text);

        calc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bin = String.valueOf(bin_spinner.getSelectedItem());

                result_text.setText( bin );


                //               String region_code = Regions.REGION.get( region );

                //               Toast.makeText(MainActivity.this,
                //                       "Attempting to set region to: " + region,
                //                               Toast.LENGTH_SHORT).show();
            }
        });
    }
}
