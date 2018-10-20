package com.example.samuel.escolaideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class CepActivity extends AppCompatActivity {
    private final int REQUEST_PERMISSION_FINE_LOCATION=1;
    private String cep;
    double lat=0,lng=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);
        obtemPermissao();



        try {
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            lng = location.getLongitude();
            lat = location.getLatitude();

            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            // lat,lng, your current location
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            cep = addresses.get(0).getPostalCode();

            Log.e("TCL",lng+"    "+lat);

            EditText edt = (EditText) findViewById(R.id.entradaCep);
            edt.setText(cep);

            Toast.makeText(CepActivity.this, "Confirme o CEP acima ou insira qualquer CEP desejado.", Toast.LENGTH_LONG).show();

        } catch (SecurityException se){
            Log.e("Razer",se.getMessage());
        } catch (Exception e){
            Log.e("Razer",e.getMessage());
        }

    }
    private void obtemPermissao() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCheck1 = ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_COARSE_LOCATION);

        if ((permissionCheck != PackageManager.PERMISSION_GRANTED) || (permissionCheck1 != PackageManager.PERMISSION_GRANTED)) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                //showExplanation("Permission Needed", "Rationale", android.Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_FINE_LOCATION);
            } else {
                requestPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_FINE_LOCATION);
            }


           /* if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                showExplanation("Permission Needed", "Rationale", android.Manifest.permission.ACCESS_COARSE_LOCATION, REQUEST_PERMISSION_COARSE_LOCATION);
            } else {
                requestPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION, REQUEST_PERMISSION_COARSE_LOCATION);
            }*/


        } else {
            Toast.makeText(CepActivity.this, "Permission (already) Granted!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_FINE_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   // Toast.makeText(CepActivity.this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(CepActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void showExplanation(String title,
                                 String message,
                                 final String permission,
                                 final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(this,
                new String[]{permissionName}, permissionRequestCode);
    }



    public void proximo(View view){
        Bundle b = new Bundle();
        EditText e = findViewById(R.id.entradaCep);
        String x = e.getText().toString();
        b.putString( "cep", x  );



    }



}
