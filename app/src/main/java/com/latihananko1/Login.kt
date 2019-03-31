package com.latihananko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.toast

class Login :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        var username=intent.getStringExtra("username")
        var uname:TextView=findViewById(R.id.tv_log)
        toast("yeay berhasil login")
        uname.text=username
    }

}