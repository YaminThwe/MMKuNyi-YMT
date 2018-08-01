package com.padcmyanmar.mmkunyi.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.adapters.JobsListAdapter
import com.padcmyanmar.mmkunyi.data.models.JobsModel
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import com.padcmyanmar.mmkunyi.events.ErrorEvent
import com.padcmyanmar.mmkunyi.events.SuccessEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), JobsDelegate {

    private var jobsAdapter: JobsListAdapter? = null

    override fun onTapJobList(jobList: JobsVO?) {
        val intent = Intent (applicationContext,JobDetailActivity::class.java)
        intent.putExtra("jobPostId", jobList!!.jobPostId)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJobsList.layoutManager = LinearLayoutManager(applicationContext)
        jobsAdapter = JobsListAdapter(applicationContext,this)
        rvJobsList.adapter= jobsAdapter

        JobsModel.getInstance().loadJobs()
        swipeRefreshLayout.isRefreshing=true

       swipeRefreshLayout.setOnRefreshListener {
            JobsModel.getInstance().loadJobs()
        }
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
