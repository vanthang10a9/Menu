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
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);

        mTextView = (TextView) findViewById(R.id.textViewNumberRandom);
        mEditText = (EditText) findViewById(R.id.editTextGioiHanTop);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDiaolog();
            }
        });
    }
    private void showAlertDiaolog(){
        if(!(mEditText.getText().toString().isEmpty())){
            runRandom();
        }else {
            AlertDialog.Builder builder  = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo");
            builder.setMessage("Bạn có muốn nhập giới hạn random trên!")
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
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    private void runRandom(){
        mEditText.setText("đã nhấn button");
//        Random random = new Random();
//        if(mEditText.getText().toString().isEmpty()){
//            mTextView.setText(random.nextInt());
//        }else{
//            int max=Integer.parseInt(mEditText.getText().toString());
//            int randomNumber = random.nextInt(max);
//            mTextView.setText(randomNumber);
//        }
    }
}
