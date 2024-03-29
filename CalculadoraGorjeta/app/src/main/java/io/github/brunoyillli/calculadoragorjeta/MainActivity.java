package io.github.brunoyillli.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import kotlin.math.UMathKt;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        double valorDigitado = 0;
        double gorjeta = 0;
        double total = 0;
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(
                            getApplicationContext(),
                            "Digite um valor primeiro!", Toast.LENGTH_LONG)
                    .show();
        } else {
            valorDigitado = Double.parseDouble(valorRecuperado);
            gorjeta = valorDigitado * (porcentagem/100);
            total = gorjeta + valorDigitado;

            textGorjeta.setText("R$ " + gorjeta );
            textTotal.setText("R$ " + total);
        }
    }
}