package com.example.auvik.womensafety;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.ContextMenu;
import android.view.Display;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PoliceActivity extends AppCompatActivity {

    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        DatabaseHelperPolice policedb = new DatabaseHelperPolice(this);

        lvProduct=(ListView)findViewById(R.id.policeListView);

        mProductList=new ArrayList<>();

        mProductList.add(new Product(policedb.searchpolicename("1"),policedb.searchpolicecall("1"),policedb.searchpoliceloc("1"),policedb.searchpolicegeo("1")));
        mProductList.add(new Product(policedb.searchpolicename("2"),policedb.searchpolicecall("2"),policedb.searchpoliceloc("2"),policedb.searchpolicegeo("2")));
        mProductList.add(new Product(policedb.searchpolicename("3"),policedb.searchpolicecall("3"),policedb.searchpoliceloc("3"),policedb.searchpolicegeo("3")));
        mProductList.add(new Product(policedb.searchpolicename("4"),policedb.searchpolicecall("4"),policedb.searchpoliceloc("4"),policedb.searchpolicegeo("4")));
        mProductList.add(new Product(policedb.searchpolicename("5"),policedb.searchpolicecall("5"),policedb.searchpoliceloc("5"),policedb.searchpolicegeo("5")));
        mProductList.add(new Product(policedb.searchpolicename("6"),policedb.searchpolicecall("6"),policedb.searchpoliceloc("6"),policedb.searchpolicegeo("6")));
        mProductList.add(new Product(policedb.searchpolicename("7"),policedb.searchpolicecall("7"),policedb.searchpoliceloc("7"),policedb.searchpolicegeo("7")));
        mProductList.add(new Product(policedb.searchpolicename("8"),policedb.searchpolicecall("8"),policedb.searchpoliceloc("8"),policedb.searchpolicegeo("8")));
        mProductList.add(new Product(policedb.searchpolicename("9"),policedb.searchpolicecall("9"),policedb.searchpoliceloc("9"),policedb.searchpolicegeo("9")));
        mProductList.add(new Product(policedb.searchpolicename("10"),policedb.searchpolicecall("10"),policedb.searchpoliceloc("10"),policedb.searchpolicegeo("10")));
        mProductList.add(new Product(policedb.searchpolicename("11"),policedb.searchpolicecall("11"),policedb.searchpoliceloc("11"),policedb.searchpolicegeo("11")));
        mProductList.add(new Product(policedb.searchpolicename("12"),policedb.searchpolicecall("12"),policedb.searchpoliceloc("12"),policedb.searchpolicegeo("12")));
        mProductList.add(new Product(policedb.searchpolicename("13"),policedb.searchpolicecall("13"),policedb.searchpoliceloc("13"),policedb.searchpolicegeo("13")));
        mProductList.add(new Product(policedb.searchpolicename("14"),policedb.searchpolicecall("14"),policedb.searchpoliceloc("14"),policedb.searchpolicegeo("14")));
        mProductList.add(new Product(policedb.searchpolicename("15"),policedb.searchpolicecall("15"),policedb.searchpoliceloc("15"),policedb.searchpolicegeo("15")));


        adapter =new ProductListAdapter(getApplicationContext(),mProductList);
        lvProduct.setAdapter(adapter);

        registerForContextMenu(lvProduct);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.policeListView) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_list, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch (item.getItemId()) {
            case R.id.Call:
                String number = mProductList.get(info.position).getPhoneno();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));

                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    return true;
                }
                startActivity(callIntent);
                return true;
            case R.id.Map:
                String policegeo = mProductList.get(info.position).getThanageo();
                Intent geoIntent = new Intent(Intent.ACTION_VIEW);
                geoIntent.setData(Uri.parse("geo:" + policegeo));
                Intent chooser = Intent.createChooser(geoIntent, "Launch Maps");
                startActivity(chooser);
                return true;
            default:
                return super.onContextItemSelected(item);

        }

    }

}