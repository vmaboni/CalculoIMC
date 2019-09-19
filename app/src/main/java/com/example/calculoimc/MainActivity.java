package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button  = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("button", "botão foi clicado");
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                Double altura = getAltura();
                Double peso = getPeso();

                if(altura <= 0 || peso <= 0){
                    showMessage("Insira Peso e Altura maiores que zero");
                }
                else
                {
                    intent.putExtra("ALTURA", getAltura());
                    intent.putExtra("PESO", getPeso());

                    startActivity(intent);
                }


            }
        });

    }

    private Double getAltura(){

        try{
            EditText text = findViewById(R.id.editAltura);
            Double altura = Double.parseDouble(text.getText().toString());

            return altura;

        }
        catch (Exception e){
            return 0.0;
        }

    }

    private Double getPeso(){

        try{

            EditText text = findViewById(R.id.editPeso);
            Double peso = Double.parseDouble(text.getText().toString());

            return peso;

        }catch (Exception e){
            return 0.0;
        }
    }

    private void showMessage(String msg){

        Context context = getApplicationContext();
        String text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
