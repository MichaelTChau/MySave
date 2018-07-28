package com.levelup.td.tdlevelupquest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class LaunchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        final Intent i = new Intent(this,MainScreenActivity.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                startActivity(i);
            }
        }, 3000);
    }

    public static void initDrawer (final Activity activity, Context context) {

         Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(new Toolbar(context))
                .withActionBarDrawerToggle(false)
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("      Galen's Account").withSelectable(false),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Back Home").withIcon(GoogleMaterial.Icon.gmd_home),
                        new SecondaryDrawerItem().withIdentifier(2).withName("Create List").withIcon(GoogleMaterial.Icon.gmd_folder_open),
                        new SecondaryDrawerItem().withName("Smart Recommendations").withIcon(GoogleMaterial.Icon.gmd_fiber_smart_record),
                        new SecondaryDrawerItem().withName("Analyze Spending").withIcon(GoogleMaterial.Icon.gmd_multiline_chart)
                )
                .withDrawerWidthPx(850)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch(position){
                            case(2):
                                Intent intent = new Intent(view.getContext(), MainScreenActivity.class);
                                view.getContext().startActivity(intent);
                                break;
                            case(3):
                                Intent intent2 = new Intent(view.getContext(), CreateGoalsActivity.class);
                                view.getContext().startActivity(intent2);
                                break;
                            case(4):
                                Intent intent3 = new Intent(view.getContext(), Recommendation.class);
                                view.getContext().startActivity(intent3);
                                break;
                            case(5):
                                Intent intent4 = new Intent(view.getContext(), AnalyzeSpendingActivity.class);
                                view.getContext().startActivity(intent4);
                                break;
                        }
                        return true;
                    }
                })
                .build();
    }

}







