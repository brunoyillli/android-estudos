package io.github.brunoyillli.fisebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FIREBASE", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Mayara Cristina");
        usuario.setSobrenome("Ribeiro Bento");
        usuario.setIdade(21);

        usuarios.child("2").setValue(usuario);

        Produto produto = new Produto();
        produto.setDescricao("Redmi Note 8");
        produto.setMarca("Xiaomi");
        produto.setPreco(1020.36);

        produtos.child("1").setValue(produto);

         */


    }
}