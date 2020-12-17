package com.test.taxi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private static final double TARGET_LATITUBE=54;
    private static final double TARGET_LONGITUDE=35;

    GoogleMap googleMap;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        Marker marker;
        @Override
        public void onMapReady(GoogleMap googleMap) {

            double lat = TARGET_LATITUBE;
            double lng = TARGET_LONGITUDE;
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat,lng)).zoom(10).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            googleMap.animateCamera(cameraUpdate);

            LatLng sydney = new LatLng(lat, lng);
            marker =googleMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.drawable.carpurple)).title("Такси"));
            //googleMap.moveCamera(cameraUpdate);
            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                @Override
                public View getInfoWindow(Marker marker) {
                   // Intent intent = new Intent(getActivity(),MainActivity.class);
                   // startActivity(intent);
                    //getActivity().;
                    ((startmap)getActivity()).book();


                        return null;
                }

                @Override
                public View getInfoContents(Marker marker) {

                    return null;
                }
            });


        }
    };




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //addMarker();
        //googleMap.setMyLocationEnabled(true);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        return inflater.inflate(R.layout.fragment_maps, container, false);


    }

    private void addMarker(){
        double lat = TARGET_LATITUBE;
        double lng = TARGET_LONGITUDE;
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat,lng)).zoom(15).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        googleMap.animateCamera(cameraUpdate);


        if (null!=googleMap){
            googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("marker"));
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}