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
 * Class also handle the conversions for cooking units.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class cooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);

        Spinner spinner = findViewById(R.id.cooking_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cooking_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.cooking_spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.cooking_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        //
        // Use a button to allow a user to call the return to main activity method and display a toasdt to confirm this action.
        Button menu = findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(v -> {
            Toast.makeText(cooking.this, "Returning to main menu...", Toast.LENGTH_SHORT).show();
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

            // CONVERSION CODE FOR CONVERTING KILOMETRES TO ALL OTHER cooking UNITS
            if (unit.equals("ounce") && unit2.equals("ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("ounce") && unit2.equals("gram")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 28.35;
            } else if (unit.equals("ounce") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.125;
            } else if (unit.equals("ounce") && unit2.equals("tablespoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 2;
            } else if (unit.equals("ounce") && unit2.equals("teaspoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 6;
            }
            // CONVERSION CODE FOR CONVERTING METRES TO ALL OTHER cooking UNITS
            else if (unit.equals("gram") && unit2.equals("ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 28.35;
            }else if (unit.equals("gram") && unit2.equals("gram")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("gram") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 220;
            }else if (unit.equals("gram") && unit2.equals("tablespoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 17.07;
            }else if (unit.equals("gram") && unit2.equals("teaspoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 0.24;
            }
            // CONVERSION CODE FOR CONVERTING CENTIMETRES TO ALL OTHER cooking UNITS
            else if (unit.equals("cup") && unit2.equals("ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            }else if (unit.equals("cup") && unit2.equals("gram")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 220;
            }else if (unit.equals("cup") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("cup") && unit2.equals("tablespoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 16;
            }else if (unit.equals("cup") && unit2.equals("teaspoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 48;
            }
            // CONVERSION CODE FOR CONVERTING MILLIMETRES TO ALL OTHER cooking UNITS
            else if (unit.equals("tablespoon") && unit2.equals("ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 2;
            }else if (unit.equals("tablespoon") && unit2.equals("gram")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 17.07;
            }else if (unit.equals("tablespoon") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 16.231;
            }else if (unit.equals("tablespoon") && unit2.equals("tablespoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            }else if (unit.equals("tablespoon") && unit2.equals("teaspoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 3;
            }
            // CONVERSION CODE FOR CONVERTING teaspoonS TO ALL OTHER cooking UNITS
            else if (unit.equals("teaspoon") && unit2.equals("ounce")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 6;
            }else if (unit.equals("teaspoon") && unit2.equals("gram")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 0.24;
            }else if (unit.equals("teaspoon") && unit2.equals("cup")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 48;
            }else if (unit.equals("teaspoon") && unit2.equals("tablespoon")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 3;
            }else if (unit.equals("teaspoon") && unit2.equals("teaspoon")) {
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
                Toast.makeText(cooking.this, "Converting " + unit + " to " + unit2 + ".", Toast.LENGTH_SHORT).show();

                // Create an imageview to be used in an alert dialog pop-up this is used for the output of the conversion to the user.
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.cooking);

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
    public void openMainActivity () {
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