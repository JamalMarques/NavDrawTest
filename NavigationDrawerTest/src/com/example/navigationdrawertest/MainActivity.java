package com.example.navigationdrawertest;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.R.attr;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private List<ItemObjetListNDraw> list_items; // = new String[]{"Empezar","Configuracion","Salir"};
	private DrawerLayout draw_lay;
	private ListView list_draw_lay;
	private ActionBarDrawerToggle mdtoggle;
	private Activity activity = this;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        list_items = new ArrayList<ItemObjetListNDraw>();
        list_items.add(new ItemObjetListNDraw("hola"));
        list_items.add(new ItemObjetListNDraw("hola"));
        list_items.add(new ItemObjetListNDraw("hola"));
        list_items.add(new ItemObjetListNDraw("hola"));
        
        draw_lay = (DrawerLayout)findViewById(R.id.draw_lay);
        list_draw_lay = (ListView)findViewById(R.id.list_draw_lay);
        
        AdapterNDrawer adapter = new AdapterNDrawer(this, R.layout.item_ndrawer_row, list_items);
        list_draw_lay.setAdapter(adapter);
        list_draw_lay.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(activity, "Touching "+arg2, Toast.LENGTH_SHORT).show();
			}
        	
		});
        
        mdtoggle = new ActionBarDrawerToggle(this, draw_lay, R.drawable.ic_launcher, R.string.app_name, R.string.hello_world){
        	public void onDrawerOpened(View drawerView) {
        		Toast.makeText(activity, "Apertura completa", Toast.LENGTH_SHORT);
        	};
        	
        	public void onDrawerClosed(View drawerView) {
        		Toast.makeText(activity, "Cierre completo", Toast.LENGTH_SHORT);
        	};
        };
        
        draw_lay.setDrawerListener(mdtoggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mdtoggle.onOptionsItemSelected(item)) {
          return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}
