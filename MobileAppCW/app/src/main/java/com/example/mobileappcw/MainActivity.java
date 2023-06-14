package com.example.mobileappcw;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/*
 * Main Activity class for the project and is responsible for opening all other activities in the project via the use of buttons.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button that opens the weight conversion activity
        Button weight = (Button) findViewById(R.id.weightbutton);
        weight.setOnClickListener(v -> openWeightActivity());

        // Button that opens the length conversion activity
        Button length = (Button) findViewById(R.id.lengthbutton);
        length.setOnClickListener(v -> openLengthActivity());

        // Button that opens the currency conversion activity
        Button currency = (Button) findViewById(R.id.currencybutton);
        currency.setOnClickListener(v -> openCurrencyActivity());

        // Button that opens the volume conversion activity
        Button volume = (Button) findViewById(R.id.volumebutton2);
        volume.setOnClickListener(v -> openVolumeActivity());

        // Button that opens the cooking conversion activity
        Button cooking = (Button) findViewById(R.id.cookingbutton2);
        cooking.setOnClickListener(v -> openCookingActivity());

        // Button that opens the area conversion activity
        Button area = (Button) findViewById(R.id.areabutton);
        area.setOnClickListener(v -> openAreaActivity());

        // Button that opens the temperature conversion activity
        Button temperature = (Button) findViewById(R.id.tempbutton);
        temperature.setOnClickListener(v -> openTemperatureActivity());

        // Button that opens the computing conversion activity
        Button bytebutton = (Button) findViewById(R.id.bytebutton);
        bytebutton.setOnClickListener(v -> openByteActivity());
        //
    }

    // Method called by a button that takes application to new activity.
    public void openWeightActivity() {
        Intent intent = new Intent(this, weightactivity.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openLengthActivity() {
        Intent intent = new Intent(this, lengthactivity.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openCurrencyActivity() {
        Intent intent = new Intent(this, currency.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openVolumeActivity() {
        Intent intent = new Intent(this, volume.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openCookingActivity() {
        Intent intent = new Intent(this, cooking.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openAreaActivity() {
        Intent intent = new Intent(this, area.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openTemperatureActivity() {
        Intent intent = new Intent(this, temperature.class);
        startActivity(intent);
    }

    // Method called by a button that takes application to new activity.
    public void openByteActivity() {
        Intent intent = new Intent(this, byteact.class);
        startActivity(intent);
    }
}