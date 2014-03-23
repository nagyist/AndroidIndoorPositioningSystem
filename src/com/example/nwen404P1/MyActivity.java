package com.example.nwen404P1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import com.example.nwen404P1.R;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements AdapterView.OnItemSelectedListener {
    private CottonAP aps = new CottonAP();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpAllAps();
    }

    public void setUpAllAps() {
        List<String> availableFloors = new ArrayList<String>();
        availableFloors.add("All");
        availableFloors.add("1");
        availableFloors.add("2");
        availableFloors.add("3");
        availableFloors.add("4");
        availableFloors.add("5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, availableFloors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner levels = (Spinner) findViewById(R.id.spinner);
        levels.setOnItemSelectedListener(this);
        levels.setAdapter(adapter);

        ArrayList<AccessPoint> allAps = new ArrayList<AccessPoint>();
        AccessPoint ap1 = new AccessPoint("2c:3f:38:2a:d9:60", 3, 29, 40, "Outside CO338");
        AccessPoint ap2 = new AccessPoint("00:1e:7a:27:f2:60", 3, 11, 28, "Outside CO353");
        AccessPoint ap3 = new AccessPoint("08:17:35:9d:26:20", 3, 29, 27, "Outside CO329");
        AccessPoint ap4 = new AccessPoint("08:17:35:9d:10:c0", 2, 13, 43, "Inside CO246");
        AccessPoint ap5 = new AccessPoint("08:17:35:9c:8a:70", 2, 21, 36, "Outside CO250");
        AccessPoint ap6 = new AccessPoint("00:23:33:20:fb:70", 2, 6, 8, "Outside CO258");
        AccessPoint ap7 = new AccessPoint("08:17:35:9d:26:90", 2, 60, 31, "Outside CO216");
        AccessPoint ap8 = new AccessPoint("08:17:35:9d:30:20", 2, 47, 9, "Outside CO228");
        AccessPoint ap9 = new AccessPoint("08:17:35:9d:27:00", 2, 87, 10, "Outside CO201");
        AccessPoint ap10 = new AccessPoint("00:23:33:20:eb:20", 3, 31, 9, "Inside CO322");
        AccessPoint ap11 = new AccessPoint("08:17:35:9d:34:b0", 3, 75, 11, "Outside CO304");
        AccessPoint ap12 = new AccessPoint("08:17:35:9d:2a:c0", 1, 37, -8, "Wishbone");
        AccessPoint ap13 = new AccessPoint("08:17:35:82:6e:40", 1, 22, 41, "Outside Fuji Xerox");
        AccessPoint ap14 = new AccessPoint("c8:f9:f9:be:0d:20", 1, 69, 41, "Outside Tardis");
        AccessPoint ap15 = new AccessPoint("08:17:35:9d:32:d0", 1, 69, 27, "CO118");
        AccessPoint ap16 = new AccessPoint("08:17:35:62:ef:20", 1, 48, 9, "CO124");
        AccessPoint ap17 = new AccessPoint("08:17:35:9c:dd:50", 1, 8, 7, "Outside CO148");
        AccessPoint ap18 = new AccessPoint("08:17:35:9c:e9:a0", 1, 50, 5, "Outside CO126");
        AccessPoint ap19 = new AccessPoint("08:17:35:9c:e1:c0", 1, 79, 10, "Outside CO105");
        AccessPoint ap20 = new AccessPoint("00:1e:4a:55:73:20", 4, 11, 10, "Outside CO435");
        AccessPoint ap21 = new AccessPoint("08:17:35:82:72:60", 4, 28, 12, "Outside CO427");
        AccessPoint ap22 = new AccessPoint("00:1e:7a:28:0a:30", 4, 51, 10, "Outside CO419");
        AccessPoint ap23 = new AccessPoint("00:23:04:5c:9b:70", 4, 74, 7, "Outside CO406");
        AccessPoint ap24 = new AccessPoint("00:23:04:5c:b1:90", 5, 11, 10, "Outside CO533");
        AccessPoint ap25 = new AccessPoint("00:23:33:20:f2:a0", 5, 34, 7, "Outside CO525");
        AccessPoint ap26 = new AccessPoint("00:3a:98:04:af:90", 5, 48, 7, "Outside CO519");
        AccessPoint ap27 = new AccessPoint("08:17:35:9c:f7:50", 5, 57, 7, "Outside CO515");
        AccessPoint ap28 = new AccessPoint("00:23:33:20:fd:40", 5, 73, 10, "Inside CO508");
        allAps.add(ap1);
        allAps.add(ap2);
        allAps.add(ap3);
        allAps.add(ap4);
        allAps.add(ap5);
        allAps.add(ap6);
        allAps.add(ap7);
        allAps.add(ap8);
        allAps.add(ap9);
        allAps.add(ap10);
        allAps.add(ap11);
        allAps.add(ap12);
        allAps.add(ap13);
        allAps.add(ap14);
        allAps.add(ap15);
        allAps.add(ap16);
        allAps.add(ap17);
        allAps.add(ap18);
        allAps.add(ap19);
        allAps.add(ap20);
        allAps.add(ap21);
        allAps.add(ap22);
        allAps.add(ap23);
        allAps.add(ap24);
        allAps.add(ap25);
        allAps.add(ap26);
        allAps.add(ap27);
        allAps.add(ap28);
        aps.setAccessPoints(allAps);
    }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            String level = parent.getSelectedItem().toString();
            ArrayList<AccessPoint> apsToShow = new ArrayList<AccessPoint>();
            if(level == "All"){
                apsToShow = aps.getAll();
            }
            else {
                int floor = Integer.parseInt(level);
                apsToShow = aps.getAPByFloor(floor);

            }

            final ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < apsToShow.size(); ++i) {
                list.add(apsToShow.get(i).getDescription());
            }
            final ListView listview = (ListView) findViewById(R.id.listView);
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            listview.setAdapter(adapter);

        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

