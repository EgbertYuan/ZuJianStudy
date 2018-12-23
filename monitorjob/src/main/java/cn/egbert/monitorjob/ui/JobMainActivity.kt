package cn.egbert.monitorjob.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import cn.egbert.corelibrary.ACTIVITY_MAIN_JOB
import cn.egbert.monitorjob.R
import cn.woonton.utils.util.LogUtils
import cn.woonton.utils.util.NetworkUtils
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.jmodel_activity_job_main.*
import kotlinx.android.synthetic.main.jmodel_app_bar_job_main.*

@Route(path =ACTIVITY_MAIN_JOB)
class JobMainActivity :AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jmodel_activity_job_main)
        setSupportActionBar(jmodel_activity_job_main_toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            jmodel_activity_job_main_toolbar,
            R.string.jmodel_navigation_drawer_open,
            R.string.jmodel_navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.jmodel_job_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
            R.id.nav_gallery -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
            R.id.nav_slideshow -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
            R.id.nav_manage -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
            R.id.nav_share -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
            R.id.nav_send -> {
                LogUtils.d(NetworkUtils.getNetworkType().name)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
