package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Locale;

import grant.com.whateveriwant.R;
import viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    AppCompatEditText num1, num2;
    MaterialButton btnAdd;
    MaterialTextView result;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "we Create'n");
        setContentView(R.layout.activity_main);
        initViews();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getSum().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double sum) {
                result.setText(String.format((Locale.getDefault()), sum.toString()));
            }
        });
        initViews();
    }

    private void initViews() {
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        result = findViewById(R.id.finalNum);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temp1 = 0;
                if(num1.getText() != null){
                    temp1 = Double.parseDouble(num1.getText().toString());
                }
                double temp2 = 0;
                if(num2.getText() !=null){
                    temp2 = Double.parseDouble(num2.getText().toString());
                }
                viewModel.calculateSum(temp1,temp2);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "we Start'n");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "we Resume'n");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "we Pause'n");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "we Stop'n");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "we Restart'n");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "we Destroy'n");
        super.onDestroy();
    }
}