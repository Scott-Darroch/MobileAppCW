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
 * Class also handle the conversions for computing units.
 * @author Scott Darroch
 * Date Last modified 30/3/2021
 */

public class byteact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byteact);

        Spinner spinner = findViewById(R.id.byte_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.byte_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.byte_spinner2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.byte_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        // Use a button to allow a user to call the return to main activity method and display a toast to confirm this action.
        Button menu = findViewById(R.id.mainmenubutton);
        menu.setOnClickListener(v -> {
            Toast.makeText(byteact.this, "Returning to main menu...", Toast.LENGTH_SHORT).show();
            openMainActivity();
        });

        // Use a button to start the conversion process
        Button convert = findViewById(R.id.convertbutton);
        convert.setOnClickListener(v ->
        {
            // Get the values contained in the spinners
            String unit = spinner.getSelectedItem().toString();
            String unit2 = spinner2.getSelectedItem().toString();
            // Get the value contained in the Edit Text box.
            EditText numberinput = findViewById(R.id.editTextNumber);
            // Parse the input from the edit text to a double so it can be used in formulae.
            double userinput = Double.parseDouble(numberinput.getText().toString());
            double convertedinput = 0;

            // CONVERSION CODE FOR CONVERTING BIT TO ALL OTHER computing UNITS
            if (unit.equals("b") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("b") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8;
            } else if (unit.equals("b") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8192;
            } else if (unit.equals("b") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8e+6;
            } else if (unit.equals("b") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8e+9;
            } else if (unit.equals("b") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            } else if (unit.equals("b") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+6;
            } else if (unit.equals("b") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+9;
            }
            // CONVERSION CODE FOR CONVERTING BYTE TO ALL OTHER computing UNITS
            else if (unit.equals("B") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            } else if (unit.equals("B") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("B") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1024;
            } else if (unit.equals("B") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+6;
            } else if (unit.equals("B") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+9;
            } else if (unit.equals("B") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125;
            } else if (unit.equals("B") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125000;
            } else if (unit.equals("B") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125000000;
            }
            // CONVERSION CODE FOR CONVERTING KILOBYTE TO ALL OTHER computing UNITS
            else if (unit.equals("KB") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8000;
            } else if (unit.equals("KB") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1024;
            } else if (unit.equals("KB") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("KB") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1024;
            } else if (unit.equals("KB") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1e+6;
            } else if (unit.equals("KB") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            } else if (unit.equals("KB") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125;
            } else if (unit.equals("KB") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125000;
            }
            // CONVERSION CODE FOR CONVERTING MEGABYTE TO ALL OTHER computing UNITS
            else if (unit.equals("MB") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8000000;
            } else if (unit.equals("MB") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000000;
            } else if (unit.equals("MB") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1024;
            } else if (unit.equals("MB") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("MB") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1024;
            } else if (unit.equals("MB") && unit2.equals("TB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000000;
            } else if (unit.equals("MB") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8000;
            } else if (unit.equals("MB") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            } else if (unit.equals("MB") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 125;
            }
            // CONVERSION CODE FOR CONVERTING GIGABYTE TO ALL OTHER computing UNITS
            else if (unit.equals("GB") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8e+9;
            } else if (unit.equals("GB") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1e+9;
            } else if (unit.equals("GB") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000000;
            } else if (unit.equals("GB") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1024;
            } else if (unit.equals("GB") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("GB") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8000000;
            } else if (unit.equals("GB") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8000;
            } else if (unit.equals("GB") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 8;
            }
            // CONVERSION CODE FOR CONVERTING KILOBIT TO ALL OTHER computing UNITS
            else if (unit.equals("Kb") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("Kb") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 125;
            } else if (unit.equals("Kb") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8;
            } else if (unit.equals("Kb") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8000;
            } else if (unit.equals("Kb") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8000000;
            } else if (unit.equals("Kb") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("Kb") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            } else if (unit.equals("Kb") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000000;
            }
            // CONVERSION CODE FOR CONVERTING MEGABIT TO ALL OTHER computing UNITS
            else if (unit.equals("Mb") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000000;
            } else if (unit.equals("Mb") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 125000;
            } else if (unit.equals("Mb") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 125;
            } else if (unit.equals("Mb") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8;
            } else if (unit.equals("Mb") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8000;
            } else if (unit.equals("Mb") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("Mb") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput;
            } else if (unit.equals("Mb") && unit2.equals("Gb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 1000;
            }
            // CONVERSION CODE FOR CONVERTING GIGABIT to all other computing units
            else if (unit.equals("Gb") && unit2.equals("b")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1e+9;
            } else if (unit.equals("Gb") && unit2.equals("B")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1.25e+8;
            } else if (unit.equals("Gb") && unit2.equals("KB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 125000;
            } else if (unit.equals("Gb") && unit2.equals("MB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 125;
            } else if (unit.equals("Gb") && unit2.equals("GB")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput / 8;
            } else if (unit.equals("Gb") && unit2.equals("Kb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000000;
            } else if (unit.equals("Gb") && unit2.equals("Mb")) {
                // Below is the formula for converting the starting unit to the output unit.
                convertedinput = userinput * 1000;
            } else if (unit.equals("Gb") && unit2.equals("Gb")) {
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
                Toast.makeText(byteact.this, "Converting " + unit + " to " + unit2 + ".", Toast.LENGTH_SHORT).show();

                // Create an imageview to be used in an alert dialog pop-up this is used for the output of the conversion to the user.
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.computing);

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