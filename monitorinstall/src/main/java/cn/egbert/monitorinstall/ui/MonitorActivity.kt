package cn.egbert.monitorinstall.ui

import android.os.Bundle
import cn.egbert.corelibrary.presenter.BasePresenter
import cn.egbert.corelibrary.ui.BaseView
import cn.egbert.monitorinstall.R
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/install/monitor_activity")
class MonitorActivity : BaseMonitorActivity<BaseView, BasePresenter<BaseView>>() {
    override fun createPresenter(): BasePresenter<BaseView> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mmodel_activity_monitor)
        ARouter.getInstance().inject(this)
    }
}
