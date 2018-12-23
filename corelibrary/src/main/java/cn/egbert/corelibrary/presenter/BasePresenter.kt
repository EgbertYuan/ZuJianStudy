package cn.egbert.corelibrary.presenter

import android.content.Context
import cn.egbert.corelibrary.ui.BaseView

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/20
 */
abstract class BasePresenter<V : BaseView> {

    private var mView: V? = null
    private var mContext: Context? = null
    /**
     * 绑定V层
     * @param view
     */
    fun attachView(view: V, context: Context) {
        this.mView = view
        this.mContext = context
    }

    /**
     * 解除绑定V层
     */

    fun detachView() {
        mView = null
        mContext = null
    }

    /**
     * 获取V层
     * @return
     */

    fun getView(): V? {
        return mView
    }

    fun getContext(): Context? {
        return mContext
    }
}