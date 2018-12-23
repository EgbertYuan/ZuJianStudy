package cn.egbert.monitorjob.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.egbert.monitorjob.R
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/job/job_activity")
class JobActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jmodel_activity_job)
        ARouter.getInstance().inject(this)
    }
}
