package cn.egbert.monitorinstall.presenter

import cn.egbert.monitorinstall.contract.MonitorMainContract
import cn.egbert.monitorinstall.model.IMonitorMainModel

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/21
 */
class IMonitorMainPresenter : MonitorMainContract.MonitorMainPresenter() {
    private val model: MonitorMainContract.MonitorMainModel

    init {
        model = IMonitorMainModel()
    }

    override fun getMonitor() {
        getView()?.also { it.getMonitorSuccess(arrayListOf("1", "2")) }
    }
}