package cn.egbert.monitorinstall.contract

import cn.egbert.corelibrary.presenter.BasePresenter
import cn.egbert.corelibrary.ui.BaseView

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/21
 */
interface MonitorMainContract {
    interface MonitorMainModel {
        fun getMonitor()
    }

    interface MonitorMainView : BaseView {
        fun getMonitorSuccess(result: List<String>)
        fun getMonitorFailure(errMsg: String)
    }

    abstract class MonitorMainPresenter : BasePresenter<MonitorMainView>() {
        abstract fun getMonitor()
    }
}
