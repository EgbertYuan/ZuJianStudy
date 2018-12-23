package cn.egbert.zujiandemo;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/12/17
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (true) {
            ARouter.openLog();
            ARouter.openDebug();
//        }
        ARouter.init(this);
    }
}
