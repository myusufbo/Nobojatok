package com.example.yusufboss.manobojatok;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;


public class HealthCalculator extends ActionBarActivity {
    Toolbar healthToolbar;
    Drawer.Result result;
    AccountHeader.Result headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_calculator);

        initDrawer(savedInstanceState);


    }

    private void initDrawer(Bundle savedInstanceState) {
        healthToolbar=(Toolbar)findViewById(R.id.healthToolbar);
        setSupportActionBar(healthToolbar);
        healthToolbar.setTitleTextColor(getResources().getColor(R.color.black_semi_transparent));

        headerResult = new AccountHeader()
                .withActivity(HealthCalculator.this)
                .withHeaderBackground(R.drawable.babyheader)
                /*.addProfiles(
                        new ProfileDrawerItem().withName("Yusuf").withEmail("yusufboss420@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile)),
                        new ProfileDrawerItem().withName("Srabon").withEmail("kazisrabon@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile2))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })*/
                .build();

        // Handle Toolbar
        result = new Drawer()
                .withActivity(HealthCalculator.this)
                .withHeader(R.layout.header)
                .withAccountHeader(headerResult)
                .withToolbar(healthToolbar)
                        //.withTranslucentStatusBar(false)
                        //.withActionBarDrawerToggle(false)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withIdentifier(0),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_health_calculator).withIcon(FontAwesome.Icon.faw_calculator).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_mother_health_info).withIcon(FontAwesome.Icon.faw_eye).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_child_info).withIcon(FontAwesome.Icon.faw_eye).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_hospital).withIcon(FontAwesome.Icon.faw_hospital_o).withIdentifier(4),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_Emergency_contact).withIcon(FontAwesome.Icon.faw_ambulance).withIdentifier(5),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_vaccenation).withIcon(FontAwesome.Icon.faw_venus).withIdentifier(6)


                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {
                            getSupportActionBar().setTitle(((Nameable) drawerItem).getNameRes());
                            //toolbar.setTitle("Home");
                            Fragment fragment = null;
                            if (drawerItem.getIdentifier() == 0) {
                                //fragment = new Info1();
                                startActivity(new Intent(HealthCalculator.this,MainActivity.class));
                                //Toast.makeText(getBaseContext(),"On Drawer Created",Toast.LENGTH_LONG).show();

                            } else if (drawerItem.getIdentifier() == 1) {

                                //Toast.makeText(getBaseContext(), "On Drawer Created", Toast.LENGTH_LONG).show();
                                //startActivity(new Intent(MainActivity.this, HealthCalculator.class));
                            } else if (drawerItem.getIdentifier() == 2) {
                                Toast.makeText(getBaseContext(), "On Drawer Created", Toast.LENGTH_LONG).show();
                                //  startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                            }
                            if (fragment != null) {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.fragment_container, fragment)
                                        .commit();
                            }
                        }
                    }
                })
                .withFireOnInitialOnClick(true)

                .withSelectedItem(1)
                .build();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

    }

    /*private void init() {

        //healthToolbar=(Toolbar)findViewById(R.id.healthToolbar);
        //healthToolbar.setTitle("Health Calculator");
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_health_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
