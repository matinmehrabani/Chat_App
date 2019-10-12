package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity(), BaseInterface {

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button


    override fun setToolbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun initUi() {
        loginButton = findViewById(R.id.loginLoginButton)
        registerButton = findViewById(R.id.loginCreateUserButton)
    }

    override fun initListen() {
        loginButton.setOnClickListener { }
        registerButton.setOnClickListener { }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUi()
        initListen()
    }
}
