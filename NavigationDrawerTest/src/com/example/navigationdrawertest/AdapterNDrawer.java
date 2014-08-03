package com.example.navigationdrawertest;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterNDrawer extends BaseAdapter {

	private Activity activity;
	private List<ItemObjetListNDraw> list_items;
	private int LayoutResourseId;
	
	public AdapterNDrawer(Activity act, int resource, List<ItemObjetListNDraw> lis) {
		activity = act;
		LayoutResourseId = resource;
		list_items = lis;
	}

	@Override
	public int getCount() {
		return list_items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list_items.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		View view = convertview;
		LayoutInflater inflater = activity.getLayoutInflater();
		view = inflater.inflate(R.layout.item_ndrawer_row, parent, false);
		
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		tv.setText(list_items.get(position).getInfo());
	
		return view;
	}

}
