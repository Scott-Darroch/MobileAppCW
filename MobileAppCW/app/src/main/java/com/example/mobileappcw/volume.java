package com.example.mobileappcw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Class for weight activity, contains all code for use of button spinners etc.
 * Class also handle the conversions for volume units.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class volume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        Spinner spinner = findViewById(R.id.volume_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.volume_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.volume_spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.volume_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        // Use a button to allow a user to call the return to main activity method and display a toasdt to confirm this action.
        Button menu = findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(v -> {
            Toast.makeText(volume.this, "Returning to main menu...", Toast.LENGTH_SHORT).show();
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

            // CONVERSION CODE FOR CONVERTING LITRES TO ALL OTHER VOLUME UNITS
            if (unit.equals("L") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("L") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("L") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.22;
            } else if (unit.equals("L") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.76;
            } else if (unit.equals("L") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3.52;
            } else if (unit.equals("L") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.879877;
            } else if (unit.equals("L") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 35.195;

                // CONVERSION CODE FOR CONVERTING MILLILITRES TO ALL OTHER VOLUME UNITS
            } else if (unit.equals("ml") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            } else if (unit.equals("ml") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("ml") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.00022;
            } else if (unit.equals("ml") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.00176;
            } else if (unit.equals("ml") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.00352;
            } else if (unit.equals("ml") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.00088;
            } else if (unit.equals("ml") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.0352;

                // CONVERSION CODE FOR CONVERTING GALLONS TO ALL OTHER VOLUME UNITS
            } else if (unit.equals("gallon") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4.546;
            } else if (unit.equals("gallon") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4546;
            } else if (unit.equals("gallon") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("gallon") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            } else if (unit.equals("gallon") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 16;
            } else if (unit.equals("gallon") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4;
            } else if (unit.equals("gallon") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 160;

                // CONVERSION CODE FOR CONVERTING PINTS TO ALL OTHER VOLUME UNITS
            } else if (unit.equals("pint") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.57;
            } else if (unit.equals("pint") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 568.261;
            } else if (unit.equals("pint") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8;
            } else if (unit.equals("pint") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("pint") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2;
            } else if (unit.equals("pint") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2;
            } else if (unit.equals("pint") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 20;

                // CONVERSION CODE FOR CONVERTING CUPS TO ALL OTHER VOLUME UNITS
            } else if (unit.equals("cup") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.284;
            } else if (unit.equals("cup") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 284;
            } else if (unit.equals("cup") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 16;
            } else if (unit.equals("cup") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2;
            } else if (unit.equals("cup") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("cup") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 4;
            } else if (unit.equals("cup") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 10;
                // CONVERSION CODE FOR CONVERTING QUARTS TO ALL OTHER VOLUME UNITS

            } else if (unit.equals("quart") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.137;
            } else if (unit.equals("quart") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1137;
            } else if (unit.equals("quart") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 4;
            } else if (unit.equals("quart") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2;
            } else if (unit.equals("quart") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 4;
            } else if (unit.equals("quart") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("quart") && unit2.equals("fluid ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 40;

                // CONVERSION CODE FOR CONVERTING FLUID OUNCES TO ALL OTHER VOLUME UNITS
            } else if (unit.equals("fluid ounce") && unit2.equals("L")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.0284;
            } else if (unit.equals("fluid ounce") && unit2.equals("ml")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 28.4;
            } else if (unit.equals("fluid ounce") && unit2.equals("gallon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.00625;
            } else if (unit.equals("fluid ounce") && unit2.equals("pint")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 20;
            } else if (unit.equals("fluid ounce") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 10;
            } else if (unit.equals("fluid ounce") && unit2.equals("quart")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 40;
            } else if (unit.equals("fluid ounce") && unit2.equals("fluid ounce")) {
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
                Toast.makeText(volume.this, "Converting " + unit + " to " + unit2 + ".", Toast.LENGTH_SHORT).show();

                // Create an imageview to be used in an alert dialog pop-up this is used for the output of the conversion to the user.
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.volume);

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