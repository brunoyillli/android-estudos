package io.github.brunoyillli.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkVerde;
    private CheckBox checkBranco;
    private CheckBox checkVermelho;
    private RadioButton sexoMasculino;
    private RadioButton sexoFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.editNome);
        textoResultado = findViewById(R.id.textResultado);
        campoEmail = findViewById(R.id.editEmail);

        checkVerde = findViewById(R.id.checkVerde);
        checkVermelho = findViewById(R.id.checkVermelho);
        checkBranco = findViewById(R.id.checkBranco);

        sexoMasculino = findViewById(R.id.radioButtonM);
        sexoFeminino = findViewById(R.id.radioButtonF);
        opcaoSexo = findViewById(R.id.radioGroupSexo);

        radioButton();
    }

    public void enviar(View view) {
        String textoCheck = checkbox();
        String textoSexo = radioButton();
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText("Nome: " + nome + " Email: " + email + textoCheck + textoSexo);

    }

    public String radioButton() {
        String sexo = "";
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.radioButtonM){
                    textoResultado.setText(" Masculino ");
                }else if(checkedId == R.id.radioButtonF){
                    textoResultado.setText(" Feminino ");
                }
            }
        });

        if (sexoMasculino.isChecked()) {
            sexo += " Masculino ";
        } else if (sexoFeminino.isChecked()) {
            sexo += " Feminino ";
        }
        return sexo;
    }

        private String checkbox () {
            String texto = "";
            String corSelecionada = "";
            if (checkVerde.isChecked()) {
                corSelecionada = checkVerde.getText().toString();
                texto = " " + corSelecionada + " selecionado - ";
            }
            if (checkBranco.isChecked()) {
                corSelecionada = checkBranco.getText().toString();
                texto += " " + corSelecionada + " selecionado - ";
            }
            if (checkVermelho.isChecked()) {
                corSelecionada = checkVermelho.getText().toString();
                texto += " " + corSelecionada + " selecionado - ";
            }
            return texto;
        }

        public void limpar (View view){
            campoNome.setText("");
            campoEmail.setText("");
        }
    }