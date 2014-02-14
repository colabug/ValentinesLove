package com.colabug.love;

import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.widget.DrawerLayout;

import java.util.ArrayList;

public class LoveActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    // Fragment that manages navigation drawer and interactions
    private NavigationDrawerFragment mNavigationDrawerFragment;

    // Stores the last screen title for restoration
    private CharSequence title;

    // Stores items to display (title and image ids)
    private ArrayList<ViewDataItem> viewDataItems;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );

        // Configure view data, should be called before configuring the navigation drawer
        setUpLoveItems();

        // Configure view
        setContentView( R.layout.activity_love );
        title = getTitle();
        configureNavigationDrawer();
    }

    private void configureNavigationDrawer ()
    {
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById( R.id.navigation_drawer );
        mNavigationDrawerFragment.setUp( R.id.navigation_drawer,
                                         (DrawerLayout) findViewById( R.id.drawer_layout ) );
    }

    /**
     * Maps the titles and images for display.
     *
     * TODO: Swap these strings and drawable ids for your own pictures and titles.
     *          - Replace the strings in res/values/strings.xml
     *          - Replace the drawables in the res/drawable/ folder
     */
    private void setUpLoveItems ()
    {
        viewDataItems = new ArrayList<ViewDataItem>();
        viewDataItems.add( new ViewDataItem( getString( R.string.ENGAGEMENT_TITLE ), R.drawable.engagement ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.ENGAGEMENT_TITLE_2 ), R.drawable.engagement2 ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.WEDDING_TITLE_1 ), R.drawable.wedding_magnolia ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.WEDDING_TITLE_2 ), R.drawable.wedding_kiss ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.WEDDING_TITLE_3 ), R.drawable.wedding_outdoor ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.DAY_AFTER_TITLE ), R.drawable.trash_the_dress ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.TRASH_THE_DRESS_TITLE ), R.drawable.trash_the_dress2 ) );
        viewDataItems.add( new ViewDataItem( getString( R.string.HONEYMOON_TITLE ), R.drawable.honeymoon ) );
    }

    /**
     * Gets navigation drawer titles.
     *
     * @return a list of titles to display
     */
    public ArrayList<String> getDisplayItems() {
        ArrayList<String> titles = new ArrayList<String>();

        for (ViewDataItem item : viewDataItems) {
            titles.add( item.getTitle() );
        }

        return titles;
    }

    /**
     * When navigation item selected, update main content by replacing fragments.
     *
     * @param position - array list position
     */
    @Override
    public void onNavigationDrawerItemSelected (int position)
    {
        //
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                       .replace( R.id.container, LoveFragment.newInstance( viewDataItems.get( position ) ) )
                       .commit();
    }

    /**
     * When the navigation item is attached, updates the title.
     */
    public void onSectionAttached (String title)
    {
        this.title = title;
    }

    /**
     * Restores the action bar title.
     */
    public void restoreActionBar ()
    {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_STANDARD );
        actionBar.setDisplayShowTitleEnabled( true );
        actionBar.setTitle( title );
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        if (!mNavigationDrawerFragment.isDrawerOpen())
        {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu( menu );
    }
}
