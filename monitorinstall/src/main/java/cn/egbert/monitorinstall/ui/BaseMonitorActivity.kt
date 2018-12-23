package cn.egbert.monitorinstall.ui

import android.os.Bundle
import cn.egbert.corelibrary.presenter.BasePresenter
import cn.egbert.corelibrary.ui.BaseActivity
import cn.egbert.corelibrary.ui.BaseView

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/19
 */
abstract class BaseMonitorActivity<V : BaseView, P : BasePresenter<V>> : BaseActivity<V,P>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}