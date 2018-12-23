package cn.egbert.monitorinstall.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import cn.egbert.corelibrary.ACTIVITY_MAIN_MONITOR
import cn.egbert.monitorinstall.R
import cn.egbert.monitorinstall.contract.MonitorMainContract
import cn.egbert.monitorinstall.presenter.IMonitorMainPresenter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.mmodel_activity_monitor_main.*
import kotlinx.android.synthetic.main.mmodel_app_bar_monitor_main.*
import kotlinx.android.synthetic.main.mmodel_content_monitor_main.*

@Route(path = ACTIVITY_MAIN_MONITOR)
open class MonitorMainActivity : BaseMonitorActivity<MonitorMainContract.MonitorMainView, IMonitorMainPresenter>(),
    NavigationView.OnNavigationItemSelectedListener,
    MonitorMainContract.MonitorMainView {

    @Autowired(name = "mobile")
    lateinit var mobile: String

    @Autowired(name = "name")
    lateinit var mName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mmodel_activity_monitor_main)
        setSupportActionBar(toolbar)
        ARouter.getInstance().inject(this)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.mmodel_navigation_drawer_open,
            R.string.mmodel_navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        if (::mobile.isInitialized) {
            mmodel_activity_main_mobile.text = mobile
        }
        if (::mName.isInitialized) {
            mmodel_activity_main_name.text = mName
        }
    }

    override fun createPresenter(): IMonitorMainPresenter {
        return IMonitorMainPresenter()
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mmodel_monitor_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                if (::mobile.isInitialized) {
                    mmodel_activity_main_mobile.text = mobile
                } else {
                    mmodel_activity_main_mobile.text = "123aaaaa"
                }
            }
            R.id.nav_gallery -> {
                if (::mName.isInitialized) {
                    mmodel_activity_main_name.text = mName
                } else {
                    mmodel_activity_main_name.text = "123aaaaa"
                }
            }
            R.id.nav_slideshow -> {
                getPresenter()?.also { it.getMonitor() }
            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun getMonitorSuccess(result: List<String>) {
        mmodel_activity_main_mobile.text = result[0]
    }

    override fun getMonitorFailure(errMsg: String) {
    }
}
