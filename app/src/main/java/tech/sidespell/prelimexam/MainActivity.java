package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private SeekBar myseekbar;
    private TextView result;
    private int value;
    private RadioGroup radioGroup;
    private RadioButton rbtnIncrement, rbtnDecrement, selected;
    private ToggleButton tbtnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SeekBar myseekbar = (SeekBar) findViewById(R.id.seekBar);
        TextView result = (TextView) findViewById (R.id.tvNum);

        setSupportActionBar(toolbar);
        myseekbar.setOnSeekBarChangeListener((OnSeekBarChangeListener) this);

        addListenerOnRbtn();
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        value = progress;
        result.setText (" "+result);
    }

    public void addListenerOnRbtn(){

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbtnIncrement = (RadioButton) findViewById(R.id.rbtnIncrement);
        rbtnDecrement = (RadioButton) findViewById(R.id.rbtnDecrement);
        tbtnSwitch = (ToggleButton) findViewById(R.id.tbtnSwitch);
        int getSelected = radioGroup.getCheckedRadioButtonId();

        selected = (RadioButton) findViewById(getSelected);

        final Handler handler = new Handler();

        tbtnSwitch.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                if(rbtnIncrement.isChecked() ){

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {

                            result.setText(value + "");

                            if (value> 0) {
                                handler.postDelayed(this, value);
                            }
                        }
                    };

                    handler.postDelayed(runnable, value);
                }




                }


            });
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
}
