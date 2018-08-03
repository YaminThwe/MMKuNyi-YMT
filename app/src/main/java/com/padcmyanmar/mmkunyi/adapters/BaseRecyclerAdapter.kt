package com.padcmyanmar.mmkunyi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.padcmyanmar.mmkunyi.view.holders.BaseViewHolder
import java.util.ArrayList

abstract class BaseRecyclerAdapter<T, W>(context: Context) : RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var jobsData: MutableList<W>? = null
    protected var jobsLayoutInflater: LayoutInflater

    val items: List<W>
        get() {
            val data = jobsData
            return data ?: ArrayList()
        }

    init {
        jobsData = ArrayList()
        jobsLayoutInflater = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
        holder.setData(jobsData!![position])

    }

    override fun getItemCount(): Int {
        return jobsData!!.size

    }

    fun setNewData(newData: MutableList<W>) {
        jobsData = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        jobsData!!.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < jobsData!!.size - 1) jobsData!![position] else null

    }



}