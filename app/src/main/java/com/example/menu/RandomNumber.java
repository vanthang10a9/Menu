package com.example.menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class RandomNumber extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditTextMax;
    private EditText mEditTextMin;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);

        mTextView = (TextView) findViewById(R.id.textViewNumberRandom);
        mEditTextMin = findViewById(R.id.editTextMin);
        mEditTextMax = findViewById(R.id.editTextMax);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        if (!(mEditTextMax.getText().toString().length() == 0) && !(mEditTextMin.getText().toString().isEmpty())) {
            runRandom();
        }
        if (mEditTextMax.getText().toString().length() == 0 && !mEditTextMin.getText().toString().isEmpty()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(RandomNumber.this);
            builder.setTitle("Thông báo")
                    .setMessage("Chỉ nhập Min khi đã nhập Max rồi")
                    .setNegativeButton("Đã hiểu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        if ((!mEditTextMax.getText().toString().isEmpty() || mEditTextMax.getText().toString().isEmpty())
                && mEditTextMin.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo");
            builder.setMessage("Bạn chưa nhập đầy đủ Min, Max. Bạn có muốn nhập lại?")
                    .setPositiveButton("Có chứ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton("Thôi khỏi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            runRandom();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }


    private void runRandom() {
        Random random = new Random();
        String editTextMax = mEditTextMax.getText().toString();
        String editTextMin = mEditTextMin.getText().toString();
        if (editTextMax.isEmpty() && editTextMin.isEmpty()) {
            mTextView.setText(String.valueOf(random.nextInt()));
        }
        if (editTextMin.isEmpty() && !editTextMax.isEmpty()) {
            int randomNumber = random.nextInt(Integer.parseInt(editTextMax));
            mTextView.setText(String.valueOf(randomNumber));
        }
        if (!editTextMax.isEmpty() && !editTextMin.isEmpty()) {
            int min = 0, max = 0;
            try {
                max = Integer.parseInt(editTextMax);
                min = Integer.parseInt(editTextMin);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "edit text ko phai số", LENGTH_SHORT).show();
            }
            if(min>max){
                min = max+min;
                max = min-max;
                min = min-max;
                mEditTextMax.setText(String.valueOf(max));
                mEditTextMin.setText(String.valueOf(min));
                Toast.makeText(this, "Đã hoán đổi Min, Max cho phù hợp", LENGTH_SHORT).show();
            }
            int randomNumber = random.nextInt(max - min + 1) + min;
            mTextView.setText(String.valueOf(randomNumber));
        }
    }
}
