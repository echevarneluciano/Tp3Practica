package com.example.tp3practica.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

private MutableLiveData<String> numero;

    public HomeViewModel() {

    }
public MutableLiveData<String> getNumero(){
        if(numero==null){
            numero=new MutableLiveData<>();
        }
        return numero;
}

public void recibeNumero(String num){
        numero.setValue(num);
}

public void llamar(String num, Context context){
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
    context.startActivity(intent);
}

}