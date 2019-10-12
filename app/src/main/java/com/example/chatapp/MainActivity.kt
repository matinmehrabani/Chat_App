package com.example.chatapp

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), BaseInterface {
    private lateinit var loginButton: Button
    private lateinit var toolbar: Toolbar
    private lateinit var fab: ImageButton
    private lateinit var addChannel: ImageButton
    private lateinit var textInputCustomEndIcon: TextInputLayout
    private lateinit var textInputMassage: TextInputEditText
    private lateinit var image: ImageButton
    override fun setToolbar() {

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }


    override fun initUi() {
        loginButton = findViewById(R.id.loginButton)
        toolbar = findViewById(R.id.toolbar)
        fab = findViewById(R.id.sendmassage)
        addChannel = findViewById(R.id.addChannel)
        textInputCustomEndIcon = findViewById(R.id.textInputLayout_passwordLogin_password)
        textInputMassage = findViewById(R.id.massagetextfield)
        image = findViewById(R.id.sendmassage)
    }

    override fun initListen() {
        loginButton.setOnClickListener {

            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

        fab.setOnClickListener {


        }

        addChannel.setOnClickListener {


        }

        textInputCustomEndIcon.setEndIconOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottomsheet, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        textInputMassage.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.isNotEmpty()) {
                    image.setImageResource(R.drawable.ic_menu_send)
                } else {
                    image.setImageResource(R.drawable.ic_mic_black_24dp)
                }
            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        initListen()
        setToolbar()


    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}



