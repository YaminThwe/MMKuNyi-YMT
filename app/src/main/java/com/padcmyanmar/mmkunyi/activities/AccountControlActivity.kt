package com.padcmyanmar.mmkunyi.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.fragments.LoginFragment
import com.padcmyanmar.mmkunyi.fragments.RegisterFragment


class AccountControlActivity:AppCompatActivity() {

    companion object {
        const val ACTION_TYPE= "action_type"
        const val ACTION_LOGIN=1234
        const val ACTION_REGISTER=4321
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control)

       val actionType= intent.extras.getInt(ACTION_TYPE)

        if(actionType== ACTION_LOGIN)
        {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, LoginFragment())
                    .commit()
        }else if(actionType== ACTION_REGISTER)
        {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, RegisterFragment())
                    .commit()
        }



    }
}