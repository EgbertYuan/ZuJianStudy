package cn.egbert.monitorjob.ui

import android.os.Bundle
import android.os.PersistableBundle
import cn.egbert.corelibrary.presenter.BasePresenter
import cn.egbert.corelibrary.ui.BaseActivity
import cn.egbert.corelibrary.ui.BaseView

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/19
 */
abstract class BaseJobActivity : BaseActivity<BaseView, BasePresenter<BaseView>>() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}