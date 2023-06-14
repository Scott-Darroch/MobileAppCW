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
 * Class also handle the conversions for length units.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class lengthactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengthactivity);

        Spinner spinner = findViewById(R.id.length_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.length_spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        //
        // Use a button to allow a user to call the return to main activity method and display a toasdt to confirm this action.
        Button menu = findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(v -> {
            Toast.makeText(lengthactivity.this, "Returning to main menu...", Toast.LENGTH_SHORT).show();
            opeyardsainActivity();
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

            // CONVERSION CODE FOR CONVERTING KILOMETRES TO ALL OTHER length UNITS
            if (unit.equals("km") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("km") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("km") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 100000;
            } else if (unit.equals("km") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1e+6;
            } else if (unit.equals("km") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1094;
            } else if (unit.equals("km") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1.609;
            } else if (unit.equals("km") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3280.84;
            } else if (unit.equals("km") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 39370;
            }
            // CONVERSION CODE FOR CONVERTING METRES TO ALL OTHER length UNITS
            else if (unit.equals("m") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            } else if (unit.equals("m") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("m") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 100;
            } else if (unit.equals("m") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("m") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.094;
            } else if (unit.equals("m") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1609;
            } else if (unit.equals("m") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3.281;
            } else if (unit.equals("m") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 39.37;
            }
            // CONVERSION CODE FOR CONVERTING CENTIMETRES TO ALL OTHER length UNITS
            else if (unit.equals("cm") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 100000;
            } else if (unit.equals("cm") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 100;
            } else if (unit.equals("cm") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("cm") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 10;
            } else if (unit.equals("cm") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 91.44;
            } else if (unit.equals("cm") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 160934;
            } else if (unit.equals("cm") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 30.48;
            } else if (unit.equals("cm") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2.54;
            }
            // CONVERSION CODE FOR CONVERTING MILLIMETRES TO ALL OTHER length UNITS
            else if (unit.equals("mm") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+6;
            } else if (unit.equals("mm") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            } else if (unit.equals("mm") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 10;
            } else if (unit.equals("mm") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("mm") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 914;
            } else if (unit.equals("mm") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1.609e+6;
            } else if (unit.equals("mm") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 305;
            } else if (unit.equals("mm") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 25.4;
            }
            // CONVERSION CODE FOR CONVERTING YARDS TO ALL OTHER length UNITS
            else if (unit.equals("yard") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1094;
            } else if (unit.equals("yard") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.094;
            } else if (unit.equals("yard") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 91.44;
            } else if (unit.equals("yard") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 914.4;
            } else if (unit.equals("yard") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("yard") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1760;
            } else if (unit.equals("yard") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3;
            } else if (unit.equals("yard") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 36;
            }
            // CONVERSION CODE FOR CONVERTING MILES TO ALL OTHER length UNITS
            else if (unit.equals("mile") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.609;
            } else if (unit.equals("mile") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1609;
            } else if (unit.equals("mile") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 160934;
            } else if (unit.equals("mile") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.609e+6;
            } else if (unit.equals("mile") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1760;
            } else if (unit.equals("mile") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("mile") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 5280;
            } else if (unit.equals("mile") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 63360;
            }
            // CONVERSION CODE FOR CONVERTING FEET TO ALL OTHER length UNITS
            else if (unit.equals("foot") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 3281;
            } else if (unit.equals("foot") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 3.281;
            } else if (unit.equals("foot") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 30.48;
            } else if (unit.equals("foot") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 304.8;
            } else if (unit.equals("foot") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 3;
            } else if (unit.equals("foot") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 5280;
            } else if (unit.equals("foot") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("foot") && unit2.equals("inch")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 12;
            }
            // CONVERSION CODE FOR CONVERTING INCHES TO ALL OTHER length UNITS
            else if (unit.equals("inch") && unit2.equals("km")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 39370;
            } else if (unit.equals("inch") && unit2.equals("m")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 39.37;
            } else if (unit.equals("inch") && unit2.equals("cm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2.54;
            } else if (unit.equals("inch") && unit2.equals("mm")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 25.4;
            } else if (unit.equals("inch") && unit2.equals("yard")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 36;
            } else if (unit.equals("inch") && unit2.equals("mile")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 63360;
            } else if (unit.equals("inch") && unit2.equals("foot")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 12;
            } else if (unit.equals("inch") && unit2.equals("inch")) {
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
                Toast.makeText(lengthactivity.this, "Converting " + unit + " to " + unit2 + ".", Toast.LENGTH_SHORT).show();

                // Create an imageview to be used in an alert dialog pop-up this is used for the output of the conversion to the user.
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.length);

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
    public void opeyardsainActivity() {
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