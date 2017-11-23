package com.example.abc.scrabblepoints;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.abc.scrabblepoints.fragments.HomeFragment;
import com.example.abc.scrabblepoints.fragments.RulesFragment;
import com.example.abc.scrabblepoints.fragments.SettingsFragment;
import com.example.abc.scrabblepoints.fragments.ShareScoreFragment;
import com.example.abc.scrabblepoints.fragments.TileListFragment;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private Toolbar toolbar;
    boolean doubleBackPressToExit = false;
    //private FloatingActionButton fab;

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_TILE_LIST = "tile_list";
    private static final String TAG_RULES = "rules";
    private static final String TAG_SHARE_SCORE = "share_score";
    private static final String TAG_SETTINGS = "settings";

    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // fab = (FloatingActionButton) findViewById(R.id.fab);

        //Navigation view header
        navHeader = navigationView.getHeaderView(0);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        navigationView.getMenu().getItem(0).getActionView();


        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }

    }


    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {

        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            //   toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        //   toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }


    private Fragment getHomeFragment() {
        switch (navItemIndex) {

            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:
                // tile list
                TileListFragment tileListFragment = new TileListFragment();
                return tileListFragment;

            case 2:
                // rules
                RulesFragment rulesFragment = new RulesFragment();
                return rulesFragment;

            case 3:
                // share score
                ShareScoreFragment shareScoreFragment = new ShareScoreFragment();
                return shareScoreFragment;

            case 4:
                // settings
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;

            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_tile_list:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_TILE_LIST;
                        break;

                    case R.id.nav_rules:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_RULES;
                        break;

//                    case R.id.nav_share:
//                        //show toast for now
//                        navItemIndex = 3;
//                        CURRENT_TAG = TAG_SHARE_SCORE;
//                        Toast.makeText(getApplicationContext(), "Feature not available in this version", Toast.LENGTH_SHORT).show();
//                        break;

//                    case R.id.nav_settings:
//                        navItemIndex = 4;
//                        CURRENT_TAG = TAG_SETTINGS;
//                        break;

                    case R.id.nav_about:
                        // show Toast for now abeg

                        Toast.makeText(getApplicationContext(), "Scrabble Points \n Version 1.0 \n Contact Developer for more info", Toast.LENGTH_LONG).show();

//                        AlertDialog builder = new Builder(getApplicationContext()).create();
//                        builder.setMessage("Scrabble Points \n Version 1.0 \n Contact Developer for more info");
//                        builder.setTitle(R.string.alert_title);
//
//                        builder.setButton(BUTTON_NEUTRAL,"Okay", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.dismiss();
//                            }
//                        });
//                        builder.show();
//                        return true;
                        break;

                    case R.id.nav_report_problem:
                        // launch mail intent instead of loading fragment
                        String email = "ibkxyz@gmail.com";

                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:"));
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Scrabble Points Feedback");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        drawer.closeDrawers();
                        return true;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                return;
            }

        }

        if (doubleBackPressToExit) {
            super.onBackPressed();
            return;
        }

        this.doubleBackPressToExit = true;
        Toast.makeText(this, R.string.back_exit, Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackPressToExit = false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_close) {
            Toast.makeText(getApplicationContext(), R.string.text_menu_close, Toast.LENGTH_LONG).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // show or hide the fab
//    private void toggleFab() {
//        if (navItemIndex == 0)
//            fab.show();
//        else
//            fab.hide();
//    }
}
