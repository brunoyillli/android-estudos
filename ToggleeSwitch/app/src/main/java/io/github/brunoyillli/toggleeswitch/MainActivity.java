package io.github.brunoyillli.toggleeswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private TextView textResultado;
    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progresso = 0;
    private SeekBar seekBarEscala;
    private TextView textViewResultadoSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        textResultado = findViewById(R.id.textResultado);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        seekBarEscala = findViewById(R.id.seekBarEscala);
        textViewResultadoSeek = findViewById(R.id.textResultadoSpeek);

        progressBarCircular.setVisibility(View.GONE);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textViewResultadoSeek.setText("Progresso: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void enviar(View view){
        if( switchSenha.isChecked()){
            textResultado.setText("Switch ligado");
        }else{
            textResultado.setText("Switch desligado");
        }
    }

    public void abrirToast(View view){
        /**Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!", Toast.LENGTH_LONG).show();**/
        //toast customizavel
        ImageView imagem = new ImageView(this);
        imagem.setImageResource(android.R.drawable.star_big_off);
        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.purple_200);
        textView.setText("Olá Toast");
        Toast toast = new Toast( getApplicationContext() );
        toast.setDuration( Toast.LENGTH_LONG );
        //toast.setView(textView);
        toast.setView(imagem);
        toast.show();
    }

    public void abrirDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Titulo da dialog");
        dialog.setMessage("Mensagem da dialog");

        dialog.setCancelable(false);

        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão Sim",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão Não",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.create();
        dialog.show();
    }

    public void carregarProgressBar(View view){
        this.progresso = this.progresso + 1;
        progressBarHorizontal.setProgress(this.progresso);

        progressBarCircular.setVisibility(View.VISIBLE);

        if( this.progresso == 10 ){
            progressBarCircular.setVisibility(View.GONE);
        }
    }

    public void recuperarProgresso(View view){
        textViewResultadoSeek.setText("Escolhido: " + seekBarEscala.getProgress());
    }
}