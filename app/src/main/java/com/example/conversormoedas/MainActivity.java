package com.example.conversormoedas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    private static class ViewHolder {
        EditText edit_valor;
        TextView text_dollar;
        TextView text_real;
        Button button_converter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.edit_valor = findViewById(R.id.edit_valor);
        this.mViewHolder.text_dollar = findViewById(R.id.text_dollar);
        this.mViewHolder.text_real = findViewById(R.id.text_real);
        this.mViewHolder.button_converter = findViewById(R.id.button_converter);

        this.mViewHolder.button_converter.setOnClickListener(this);

        this.clearValues();
    }

    @SuppressLint(value = "DefaultLocale")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_converter) {
            String valor = this.mViewHolder.edit_valor.getText().toString();
            if ("".equals(valor)) {
                // Mensagem de erro para o utilizador
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            } else {
                //Calculos das conversões
                double euro = Double.parseDouble(valor);
                this.mViewHolder.text_dollar.setText(String.format("%.2f", (euro * 1.184)));
                this.mViewHolder.text_real.setText(String.format("%.2f", (euro * 6.38)));
            }
        }
    }

    private void clearValues() {
        this.mViewHolder.text_dollar.setText("");
        this.mViewHolder.text_real.setText("");
    }
}