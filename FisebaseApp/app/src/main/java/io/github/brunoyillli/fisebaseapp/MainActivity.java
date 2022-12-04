package io.github.brunoyillli.fisebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");
        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Mayara Cristina");
        usuario.setSobrenome("Ribeiro Bento");
        usuario.setIdade(21);

        usuarios.child("2").setValue(usuario);
        */
        Produto produto = new Produto();
        produto.setDescricao("Redmi Note 8");
        produto.setMarca("Xiaomi");
        produto.setPreco(1020.36);

        produtos.child("1").setValue(produto);

    }
}