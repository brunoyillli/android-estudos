package io.github.brunoyillli.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.brunoyillli.atmconsultoria.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SobreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "Sed commodo ac mauris nec iaculis. Sed eu consequat nunc. Phasellus " +
                "ullamcorper leo in scelerisque tempor. Quisque non massa id purus euismod blandit. " +
                "Donec tempus neque ante, sagittis convallis mauris vulputate a.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsuloria.com.br", "Envie um e-mail")
                .addWebsite("https://github.com/brunoyillli","Acesse nosso site")
                .addGroup("Redes sociais")
                .addFacebook("AndroidOfficial", "Facebook")
                .addInstagram("Android", "Instagram")
                .addTwitter("elonmusk", "Twitter")
                .addYoutube("AlesiSupimpa", "Youtube")
                .addGitHub("brunoyillli", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")
                .addItem( versao )

                .create();

        return view;
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}