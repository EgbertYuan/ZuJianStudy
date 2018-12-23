package cn.egbert.corelibrary.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.egbert.corelibrary.presenter.BasePresenter

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/18
 */
abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        if (mPresenter == null) {
            throw NullPointerException("presenter 不能为空!")
        }
        mPresenter?.let { it.attachView(this as V,this) }
    }

    /**
     * 创建Presenter
     * @return 子类自己需要的Presenter
     */
    abstract fun createPresenter(): P

    /**
     * 获取Presenter
     * @return 返回子类创建的Presenter
     */

    fun getPresenter(): P? {
        return mPresenter
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.let { it.detachView() }
    }
}