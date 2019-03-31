package com.latihananko1

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)

        var btn: Button = findViewById(R.id.btn)
        var uname: EditText = findViewById(R.id.et_username)
        var passwd: EditText = findViewById(R.id.et_password)
        btn.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            HandleLogin(username, password)
        }
    }
    //membuat function atau methode untuk HandleLogin
    private fun HandleLogin(username: String, password: String) {
        if (username.equals("Master") && password.equals("Rizky")) {
            info { "Data username : $username, Data password : $password,status login: Berhasil" } // Log.i jika ditulis di java
            startActivity(intentFor<Login>("username" to username))
            finish()
        } else {
            error {  "Data username : $username, Data password : $password,status login: Gagal"  }//log.e error
            alert(title = "Warning", message = "Username atau password salah") {
                positiveButton(buttonText = "pencet") {

                }
                isCancelable = false
            }.show()
        }
    }


    //membuat class yang akan mendesign layout
    class LoginView : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    backgroundColor = Color.rgb(11, 120, 155)
                    margin = 15
                }
                imageView {
                    setImageResource(R.mipmap.ic_launcher)
                }.lparams(width = matchParent, height = dip(250)) {
                    margin = 15
                }
                textView {
                    id=R.id.tv_username
                    text = "Username"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_username
                    hint = "Username"
                    inputType = InputType.TYPE_CLASS_TEXT
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                textView {
                    id = R.id.tv_password
                    text = "Password"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_password
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                button("LOGIN") {
                    id = R.id.btn
                    backgroundColor = Color.rgb(216, 176, 40)
                    textColor = Color.BLACK
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    gravity = Gravity.CENTER
                }

            }
        }
    }
}
