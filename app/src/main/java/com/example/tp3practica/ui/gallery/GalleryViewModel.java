package com.example.tp3practica.ui.gallery;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Closeable;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mapa;
    private Context context;
    private LatLng mercado1= new LatLng(-33.294760,-66.303415);
    private LatLng mercado2= new LatLng(-33.267350,-66.304006);

    public GalleryViewModel (@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<MapaActual> getMapa(){
        if(mapa==null){
            mapa=new MutableLiveData<>();
        }
        return mapa;
    }

    public void construirMapa(){

        mapa.setValue(new MapaActual());

    }

    public class MapaActual implements OnMapReadyCallback {


        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.addMarker(new MarkerOptions().position(mercado1).title("Mercado 1"));
            googleMap.addMarker(new MarkerOptions().position(mercado2).title("Mercado 2"));
            CameraPosition camPos=new CameraPosition.Builder()
                    .target(mercado1)
                    .zoom(19)
                    .bearing(45)
                    .tilt(70)
                    .build();
            CameraUpdate update= CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.animateCamera(update);

        }
    }

}