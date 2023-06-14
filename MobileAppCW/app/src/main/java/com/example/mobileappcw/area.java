package com.example.mobileappcw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Class for weight activity, contains all code for use of button spinners etc.
 * Class also handle the conversions for area units.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class area extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        Spinner spinner = findViewById(R.id.area_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.area_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.area_spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.area_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        // Use a button to allow a user to call the return to main activity method and display a toasdt to confirm this action.
        Button menu = findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(v -> {
            Toast.makeText(area.this,"Returning to main menu...",Toast.LENGTH_SHORT).show();
            openMainActivity();
        });

        // Use a button to start the conversion process
        Button convert = findViewById(R.id.convertbutton);
        convert.setOnClickListener(v -> {

            // Get the values contained in the spinners
            String unit = spinner.getSelectedItem().toString();
            String unit2 = spinner2.getSelectedItem().toString();
            // Get the value contained in the Edit Text box.
            EditText numberinput = findViewById(R.id.editTextNumber);
            // Parse the input from the edit text to a double so it can be used in formulae.
            double userinput = Double.parseDouble(numberinput.getText().toString());
            double convertedinput = 0;

            // CONVERSION CODE FOR CONVERTING SQUARE METERS TO ALL OTHER area UNITS
            if (unit.equals("Square meter") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("Square meter") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2.59e+6;
            }else if (unit.equals("Square meter") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.196;
            }else if (unit.equals("Square meter") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 10.764;
            }else if (unit.equals("Square meter") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1550;
            }else if (unit.equals("Square meter") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 10000;
            }else if (unit.equals("Square meter") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 4047;

                // CONVERSION CODE FOR CONVERTING SQUARE MILES TO ALL OTHER area UNITS
            } else if (unit.equals("Square mile") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2.59e+6;
            }else if (unit.equals("Square mile") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("Square mile") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3.098e+6;
            }else if (unit.equals("Square mile") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2.788e+7;
            }else if (unit.equals("Square mile") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4.014e+9;
            }else if (unit.equals("Square mile") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 259;
            }else if (unit.equals("Square mile") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 640;

                // CONVERSION CODE FOR CONVERTING SQUARE YARDS TO ALL OTHER area UNITS
            }else if (unit.equals("Square yard") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1.196;
            }else if (unit.equals("Square yard") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 3.098e+6;
            }else if (unit.equals("Square yard") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("Square yard") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 9;
            }else if (unit.equals("Square yard") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1296;
            }else if (unit.equals("Square yard") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 11960;
            }else if (unit.equals("Square yard") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4840;

                // CONVERSION CODE FOR CONVERTING SQUARE FEET TO ALL OTHER area UNITS
            }else if (unit.equals("Square foot") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 10.764;
            }else if (unit.equals("Square foot") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2.788e+7;
            }else if (unit.equals("Square foot") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 9;
            }else if (unit.equals("Square foot") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("Square foot") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 144;
            }else if (unit.equals("Square foot") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 107639;
            }else if (unit.equals("Square foot") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 43560;

                // CONVERSION CODE FOR CONVERTING SQUARE INCHES TO ALL OTHER area UNITS
            }else if (unit.equals("Square inch") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1550;
            }else if (unit.equals("Square inch") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 4.014e+9;
            }else if (unit.equals("Square inch") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1296;
            }else if (unit.equals("Square inch") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 144;
            }else if (unit.equals("Square inch") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("Square inch") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1.55e+7;
            }else if (unit.equals("Square inch") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 6.273e+6;

                // CONVERSION CODE FOR CONVERTING HECTARES TO ALL OTHER area UNITS
            }else if (unit.equals("Hectare") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 10000;
            }else if (unit.equals("Hectare") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 259;
            }else if (unit.equals("Hectare") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 11960;
            }else if (unit.equals("Hectare") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 107639;
            }else if (unit.equals("Hectare") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.55e+7;
            }else if (unit.equals("Hectare") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("Hectare") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2.471;

                // CONVERSION CODE FOR CONVERTING ACRES TO ALL OTHER area UNITS
            }else if (unit.equals("Acre") && unit2.equals("Square meter")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4047;
            }else if (unit.equals("Acre") && unit2.equals("Square mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 640;
            }else if (unit.equals("Acre") && unit2.equals("Square yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4840;
            }else if (unit.equals("Acre") && unit2.equals("Square foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 43560;
            }else if (unit.equals("Acre") && unit2.equals("Square inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 6.273e+6;
            }else if (unit.equals("Acre") && unit2.equals("Hectare")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2.471;
            }else if (unit.equals("Acre") && unit2.equals("Acre")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }

            // SENDS ERROR MESSAGE TO USER IF NO UNIT IS SELECTED AS INPUT OR OUTPUT otherwise send conversion to user.
            if (unit.equals("Select") || unit2.equals("Select")) {
                final Snackbar snackBar = Snackbar.make(findViewById(android.R.id.content), "ERROR A UNIT MUST BE SELECTED TO DO A CONVERSION!", Snackbar.LENGTH_LONG);

                snackBar.setAction("Dismiss", v1 -> {
                    // Call your action method here
                    snackBar.dismiss();
                });
                snackBar.show();
            } else {

                // Toast that sends a message to user to allow confirmation that the right conversion is being completed.
                Toast.makeText(area.this, "Converting " + unit + " to " + unit2 + ".", Toast.LENGTH_SHORT).show();

                // Create an imageview to be used in an alert dialog pop-up this is used for the output of the conversion to the user.
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.area);

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this).
                                setMessage(userinput + " " + unit + " converts to " + round(convertedinput, 2) + " " + unit2).
                                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).
                                setView(image);
                builder.create().show();
            }
        });
    }

    //  Opens the main activity returning the user to the main menu.
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Method that rounds numbers up to a set number of decimal places.
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}