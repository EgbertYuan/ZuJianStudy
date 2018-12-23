package cn.egbert.monitorinstall

import android.app.Application
import cn.woonton.utils.util.Utils
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/17
 */
class InstallApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //        if (debug) {
        ARouter.openLog()
        ARouter.openDebug()
        //        }
        ARouter.init(this)
        Utils.init(this.applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}
