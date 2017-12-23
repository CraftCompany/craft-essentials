package com.craft.essentials.ui;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.craft.essentials.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A helper class that initializes and manages a simple navigation drawer.
 *
 * @author willie
 * @version 1.0.0
 * @since 1.0.0
 */
public class DrawerManager {

    private final Context mContext;

    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigationView;

    /**
     * Creates a new {@code DrawerManager} and initializes the given {@link Toolbar} with a
     * navigation button.
     */
    public DrawerManager(Activity activity, OnNavigationItemSelectedListener navigationListener,
                         Toolbar toolbar, DrawerLayout drawerLayout) {
        mContext = activity;
        mDrawerLayout = drawerLayout;
        mNavigationView = mDrawerLayout.findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(navigationListener);
        initializeDrawer(activity, toolbar);
    }

    /**
     * Sets an {@link OnClickListener} to monitor header selection events.
     * <p>
     * This should be used to switch accounts or log out when the listener is triggered
     */
    public void setAccountButtonListener(OnClickListener listener) {
        getHeaderView().findViewById(R.id.navigation_header_expand)
                .setOnClickListener(listener);
    }

    /**
     * Updates the information displayed in the navigation drawer header.
     */
    public void updateNavigationHeader(String userName, String userEmail, String userPhotoUrl) {
        View headerView = mNavigationView.getHeaderView(0);
        CircleImageView profileImage = headerView.findViewById(R.id.navigation_header_image);
        ((TextView) headerView.findViewById(R.id.navigation_header_name))
                .setText(userName);
        ((TextView) headerView.findViewById(R.id.navigation_header_email))
                .setText(userEmail);
        //noinspection StatementWithEmptyBody
        if (userPhotoUrl != null) {
            Glide.with(mContext)
                    .load(userPhotoUrl)
                    .into(profileImage);
        } else {
            // TODO: 7/2/17 Inject placeholder
        }
    }

    private void initializeDrawer(Activity activity, Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, mDrawerLayout, toolbar,
                R.string.essentials_label_drawer_open, R.string.essentials_label_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Closes the navigation drawer controlled by this DrawerManager.
     */
    public void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private View getHeaderView() {
        return mNavigationView.getHeaderView(0);
    }
}
