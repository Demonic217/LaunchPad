package com.example.damonpelser.launchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by damon on 2017/10/24.
 */

public class CompanyDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    String compLogo, compName, closeDate, compDesc, compLat, compLong, compOpp, compCriteria, compTC;
    ImageView clogo;
    TextView cName, cOppo, cDesc, cCrit, cCDate, cTnC;
    GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_details);

        //Get Company Info
        Intent intent= getIntent();
//        Bundle bundle = this.getIntent().getExtras();
        AssignInfo(intent);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void AssignInfo(Intent intent){

        compLogo = intent.getStringExtra("compLogo");
        compName = intent.getStringExtra("compName");
        compOpp = intent.getStringExtra("compOpp");
        compDesc = intent.getStringExtra("compDesc");
        compCriteria = intent.getStringExtra("compCrit");
        compTC = intent.getStringExtra("compTnC");
        closeDate = intent.getStringExtra("compCDate");
        compLat = intent.getStringExtra("compLat");
        compLong = intent.getStringExtra("compLong");

        clogo = (ImageView) findViewById(R.id.companyLogo);
        cName = (TextView) findViewById(R.id.companyName);
        cOppo = (TextView) findViewById(R.id.opportunity);
        cDesc = (TextView) findViewById(R.id.description);
        cCrit = (TextView) findViewById(R.id.selectionCriteria);
        cCDate = (TextView) findViewById(R.id.closeDate);
        cTnC = (TextView) findViewById(R.id.terms);

        Glide.with(this).load(compLogo).into(clogo);
        cName.setText(compName);
        cOppo.setText(compOpp);
        cDesc.setText(compDesc);
        cCrit.setText(compCriteria);
        cCDate.setText(closeDate);
        cTnC.setText(compTC);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //TODO Add buttons to Zoom on map
        LatLng compPos = new LatLng(Double.parseDouble(compLat),Double.parseDouble(compLong));
        mMap.addMarker(new MarkerOptions().position(compPos).title(compName));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.parseDouble(compLat),Double.parseDouble(compLong)),12f));
    }
}
