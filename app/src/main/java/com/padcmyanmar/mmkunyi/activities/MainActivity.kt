package com.padcmyanmar.mmkunyi.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.adapters.JobsListAdapter
import com.padcmyanmar.mmkunyi.data.models.JobsModel
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.BeforeLoginDelegate
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import com.padcmyanmar.mmkunyi.events.ErrorEvent
import com.padcmyanmar.mmkunyi.events.SuccessEvent
import com.padcmyanmar.mmkunyi.view.pods.BeforeLoginViewPod
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), JobsDelegate ,BeforeLoginDelegate{
    override fun onTapLogin() {
        Toast.makeText(applicationContext,"Navigate to Login", Toast.LENGTH_LONG).show()

        val intent = Intent(applicationContext,AccountControlActivity::class.java)
        intent.putExtra("action_type", 1234)
        startActivity(intent)
    }

    override fun onTapRegister() {
        Toast.makeText(applicationContext,"Navigate to Register", Toast.LENGTH_LONG).show()

        val intent = Intent(applicationContext,AccountControlActivity::class.java)
        intent.putExtra("action_type", 4321)
        startActivity(intent)
    }

    override fun onTapViewedList(jobList: JobsVO?) {
        val intent = Intent(applicationContext, InterestedActivity::class.java)
        intent.putExtra("jobPostId", jobList!!.jobPostId)
        startActivity(intent)
    }

    private var jobsAdapter: JobsListAdapter? = null

    override fun onTapJobList(jobList: JobsVO?) {
        val intent = Intent(applicationContext, JobDetailActivity::class.java)
        intent.putExtra("jobPostId", jobList!!.jobPostId)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)

        rvJobsList.layoutManager = LinearLayoutManager(applicationContext)
        jobsAdapter = JobsListAdapter(applicationContext, this)
        rvJobsList.adapter = jobsAdapter

        JobsModel.getInstance().loadJobs()
        swipeRefreshLayout.isRefreshing = true

        swipeRefreshLayout.setOnRefreshListener {
            JobsModel.getInstance().loadJobs()
        }

        navigationView.setNavigationItemSelectedListener {
            for(menuItemIndex in 0 until navigationView.menu.size())
            {
                navigationView.menu.getItem(menuItemIndex).isChecked = false
            }
            it.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
        val vpBeforeLogin = navigationView.getHeaderView(0) as BeforeLoginViewPod
        vpBeforeLogin.setDelegate(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_news_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSuccessGetJobs(jobsLoadedEvent: SuccessEvent.JobsListLoadedEvent) {
        jobsAdapter!!.appendNewData(jobsLoadedEvent.loadedJobNews as MutableList<JobsVO>)
        swipeRefreshLayout.isRefreshing = false
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvJobsList, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show()


    }

}
