package com.matteopasotti.github_app_koin.view.viewholder

import android.content.Context
import android.view.View

abstract class BaseViewHolder(private val view : View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    @Throws(Exception::class)
    abstract fun bindData(data: Any?)

    protected fun view(): View {
        return view
    }

    protected fun context(): Context {
        return view.context
    }
}