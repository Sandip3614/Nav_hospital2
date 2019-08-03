package sk.nav_hospital;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InformActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    RatingBar rb;
    Button button, b;
    Intent intent;
    Database myDb;
    LocationManager locationManager;
    private static final int REQUEST_LOCATION = 1;
    String longitude;
    String latitude;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);
        intent = this.getIntent();

        Toast.makeText(this, intent.getStringExtra("place_name"), Toast.LENGTH_LONG).show();
//        String place_name = getIntent().getStringExtra("place_name");
//        String place_name = intent.getStringExtra("place name");
        Bundle bundle = getIntent().getExtras();
        final String place_name = bundle.getString("place_name");

        myDb = new Database(this);

        myDb.insertData("KIST Medical College Teaching Hospital", "Patan", "500", "17", "Cash | Credit card | Debit card | Insurance", "3.5(f)", "");

        myDb.insertData("Red Cross Balkot Sub-branch", "Anantalingeshwor", "450", "14", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Patan Hospital", "Lagankhel Satdobato Road,Patan", "1100", "18", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("अल्का अस्पताल", "Patan", "900", "16", "Cash | Credit card | Debit card | Insurance", "3.5(f)", "");

        myDb.insertData("Vayodha Hospitals", "Balkhu,Kathmandu", "1500", "23", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Norvic International Hospital", "Kathmandu", "850", "13", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("Civil Service Hospital Of Nepal", "Minbhawan marg minbhawan,Kathmandu", "2200", "12", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("Kathmandu Medical College", "Sinamangal Road,Kathmandu", "900", "15", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("Teku Hospital(Shukraraaj Tropical & Infectious Disease Hospital)", "Teku", "1200", "14", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Tilganga Eye Hospital", "Ring Road,Kathmandu", "1000", "16", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Bir Hospital", "Kantipath,Kathmandu", "1800", "10", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Om Hospital & Research Center", "Chabahil Sadak,Kathmandu", "890", "12", "Cash | Credit card | Debit card | Insurance", "3.5(f)", "");

        myDb.insertData("Medicare National Hospital and Research Center", "Ring Road,Kathmandu", "560", "13", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("Nepal Orthopedic Hospital", "Boudha Road,Gokarneshwor,Kathmandu", "1500", "31", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("CIWEC Hospital Pvt.Ltd", "Kapurdhara marg,Kathmandu", "6650", "21", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("National Dental Hospital", "Kathmandu", "820", "3", "Cash | Credit card | Debit card | Insurance", "4.5(f)", "");

        myDb.insertData("International Friendship Children's Hospital", "Maharajgunj,Kathmandu", "920", "25", "Cash | Credit card | Debit card | Insurance", "3.5(f)", "");

        myDb.insertData("Ojus Ayurveda Hospital & Research Center Pvt.Ltd", "Samakhusi,Kathmandu", "1100", "19", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Kanti Children's Hospital", "Maharajgunj Sadak", "1600", "16", "Cash | Credit card | Debit card | Insurance", "3.5(f)", "");

        myDb.insertData("Kantipur Dental College Teaching Hospital and Research Center", "Bashundhara,Kathmandu", "1800", "15", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Advanced Poly Clinic", "Kathmandu", "700", "11", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("Himal Dental Hospital & Institute of Dental Science", "Rishi Bhawan chabahil,Kathmandu", "1800", "15", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");

        myDb.insertData("National Kidney Center", "Bhairab Bhawan chakrapath,Kathmandu", "1800", "15", "Cash | Credit card | Debit card | Insurance", "5.5(f)", "");


        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.text2);
        tv3 = (TextView) findViewById(R.id.text3);
        tv4 = (TextView) findViewById(R.id.text4);
        tv5 = (TextView) findViewById(R.id.text5);
        tv6 = (TextView) findViewById(R.id.text6);


        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                 final String[] listItems = {"By Vehicles ", "Walking"};

                AlertDialog.Builder builder = new AlertDialog.Builder(InformActivity.this);
                builder.setTitle("Select Direction Mode");

                int checkedItem = 0; //this will checked the item when user open the dialog
                builder.setSingleChoiceItems(listItems, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which)
                        {
                            case 0:
                                Uri gmmIntentUri = Uri.parse("google.navigation:q="+place_name+"&mode="+"d");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);
                                break;
                            case 1:
                                Uri gmmIntentUri2 = Uri.parse("google.navigation:q="+place_name+"&mode="+"w");
                                Intent mapIntent2 = new Intent(Intent.ACTION_VIEW, gmmIntentUri2);
                                mapIntent2.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent2);
                                break;

                        }

                        //Toast.makeText(InformActivity.this, "Position: " + which + " Value: " + listItems[which], Toast.LENGTH_LONG).show();
                    }
                });

//                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        dialog.dismiss();
//                    }
//                });

                AlertDialog dialog = builder.create();
                dialog.show();

//                Uri gmmIntentUri = Uri.parse("google.navigation:q="+place_name);
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);

            }
        });

        Cursor res = myDb.getSpecificCol(place_name);
//        System.out.println(res);

//        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        StringBuffer buffer4 = new StringBuffer();
        StringBuffer buffer5 = new StringBuffer();
        StringBuffer buffer6 = new StringBuffer();
//        StringBuffer buffer7 = new StringBuffer();
        while (res.moveToNext())
        {
//          //            buffer.append(  res.getString(0) + "\n");
            buffer1.append(res.getString(0) );
            buffer2.append(res.getString(1));
            buffer3.append(res.getString(2) );
            buffer4.append(res.getString(3) );
            buffer5.append(res.getString(4) );
            buffer6.append(res.getString(5) );
//            buffer7.append(res.getString(6));
//            Long numb=Long.valueOf(buffer7.toString());
        }

        String s = buffer1.toString();
        tv1.setText(s);
        s = buffer2.toString();
        tv2.setText(s);
        s = buffer3.toString();
        tv3.setText(s);
        s = buffer4.toString();
        tv4.setText(s);
        s = buffer5.toString();
        tv5.setText(s);
        s = buffer6.toString();
        tv6.setText(s);
    }
}
