package cn.egbert.zujiandemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import cn.egbert.corelibrary.ACTIVITY_MAIN_MONITOR
import cn.egbert.corelibrary.ACTIVITY_MAIN_JOB
import cn.egbert.zujiandemo.R
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_app_login.*

@Route(path = "/app/login_activity")
class AppLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_login)
        app_login_password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })
        ARouter.getInstance().inject(this)
        app_login_button.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {

        app_login_mobile.error = null
        app_login_password.error = null

        val mobileStr = app_login_mobile.text.toString()
        val passwordStr = app_login_password.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(passwordStr) && !isPasswordValid(passwordStr)) {
            app_login_password.error = "密码格式不正确"
            focusView = app_login_password
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(mobileStr)) {
            app_login_mobile.error = "请输入手机号码"
            focusView = app_login_mobile
            cancel = true
        } else if (!isMobileValid(mobileStr)) {
            app_login_mobile.error = "手机格式不正确"
            focusView = app_login_mobile
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {
            loginSuccess()
        }
    }

    private fun isMobileValid(mobile: String): Boolean {
        return mobile.length == 11
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }

    private fun loginSuccess() {
        if (app_login_ck.isChecked) {
            ARouter.getInstance().build(ACTIVITY_MAIN_JOB).navigation()
        } else {
            ARouter.getInstance().build(ACTIVITY_MAIN_MONITOR)
                .withString("mobile", app_login_mobile.text.toString())
                .withString("name", "张三")
                .navigation()
        }
    }

}
