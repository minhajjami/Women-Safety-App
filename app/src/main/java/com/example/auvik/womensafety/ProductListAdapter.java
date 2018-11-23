package com.example.auvik.womensafety;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telecom.Call;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Auvik on 07-Jan-17.
 */

public class ProductListAdapter extends BaseAdapter{

    private Context mContext;
    private List<Product> mProductList;


    public ProductListAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_product_list, null);
        TextView adabor = (TextView) v.findViewById(R.id.AdaborText);
        TextView adaboradd = (TextView) v.findViewById(R.id.AdaborAdd);

        adabor.setText(mProductList.get(position).getThana());
        adaboradd.setText(mProductList.get(position).getThanaloc());
        return v;
    }
}
