package course.assignment.tipcalc;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button[] btnPercentage = new Button[3];
        btnPercentage[0] = (Button) findViewById(R.id.btn10);
        btnPercentage[1] = (Button) findViewById(R.id.btn15);
        btnPercentage[2] = (Button) findViewById(R.id.btn20);
        
        for (Button btn : btnPercentage) {
        	btn.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    				EditText text = (EditText) findViewById(R.id.etCheckAmount);
    				TextView tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
    				
    				Float amount = Float.valueOf(text.getText().toString());
    				float percent = Float.valueOf( ((Button) view).getText().toString().substring(0,2) )
    									.floatValue()/100;
    				String tipAmount = formatDecimal(amount.floatValue() * percent);
    				
    				tvTipAmount.setText("$"+String.valueOf(tipAmount));
    				Log.d("DEBUG", "App: Percent="+percent+", amount="+amount+", tip="+tipAmount);
    				
    			}
    		});
        }
        
        
    }

    
    public static String formatDecimal(Float number) {
        Float epsilon = 0.004f; // 4 tenths of a cent
        if (Math.abs(Math.round(number) - number) < epsilon) {
            return String.format("%10.0f", number); // sdb
        } else {
            return String.format("%10.2f", number); // dj_segfault
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
