package com.app.keepdog

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.keepdog.MainAdapter.MainHoldel
import com.app.keepdog.R.id
import com.app.keepdog.R.layout
import com.bumptech.glide.Glide

class MainAdapter(
    private val context: Context,
    private val list: List<DogItem>
) : Adapter<MainHoldel>() {
    private var listener: MyOnClickListener? = null
    fun setListener(listener: MyOnClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainHoldel {
        val view =
            View.inflate(parent.context, layout.item_main, null)
        return MainHoldel(view)
    }

    override fun onBindViewHolder(
        holder: MainHoldel,
        position: Int
    ) {
        val item = list[position]
        Glide.with(context).load(item.icon).into(holder.itemIcon)
        holder.tvName.text = item.name
        holder.tvContent.text = item.content
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MainHoldel(itemView: View) : ViewHolder(
            itemView
    ) {
        val itemIcon: ImageView
        val tvName: TextView
        val tvContent: TextView

        init {
            itemIcon = itemView.findViewById(id.item_iv)
            tvName = itemView.findViewById(id.tvName)
            tvContent = itemView.findViewById(id.tvContent)
        }
    }

    interface MyOnClickListener {
        fun onClick(position: Int)
    }

}