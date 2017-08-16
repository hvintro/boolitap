package com.nica.bolitaap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Borja on 29/6/16.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    protected final int RESULT_ERROR = -15;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

/*    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

    protected void toast(String msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    protected void toast(String msg, int length) {
        Toast.makeText(this, msg, length).show();
    }


    protected void loading() {
        loading(getString(R.string.pd_cargando));
    }

    protected void loading(String msg) {
        loading(null, msg, false);
    }

    protected void loading(String msg, boolean cancelable) {
        loading(null, msg, cancelable);
    }

    protected void loading(String title, String msg, boolean cancelable) {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            loaded();
        msg = msg == null ? "" : msg;
        title = title == null ? getResources().getString(R.string.info_name) : title;
        mProgressDialog = ProgressDialog.show(this, title, msg, true, cancelable);
    }

    protected void loaded() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        loaded();
        super.onDestroy();
    }

    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected void initToolbar(Toolbar toolbar, String title) {
        initToolbar(toolbar);
        toolbar.setTitle(title);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected void initToolbar(Toolbar toolbar, String title, int drawableId) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationIcon(drawableId);
        toolbar.setTitle(title);
    }

}
