package com.onurerdem.learnkotlinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.onurerdem.learnkotlinproject.R
import com.onurerdem.learnkotlinproject.model.MessageItem

class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>() {

    private var messageList: ArrayList<MessageItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
    )

    override fun onBindViewHolder(holder: MessageListAdapter.MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount() = messageList.size

    inner class MessageViewHolder(view: View) :  RecyclerView.ViewHolder(view){
        fun bind(messageItem: MessageItem) {
            itemView.findViewById<TextView>(R.id.tv_name).text = messageItem.name
            itemView.findViewById<TextView>(R.id.tv_message).text = messageItem.message
            itemView.findViewById<TextView>(R.id.tv_message_time).text = messageItem.id
        }
    }
    fun listeyiDoldur(messageListesi: ArrayList<MessageItem>){
        messageList.clear()
        messageList.addAll(messageListesi)
        notifyDataSetChanged()
    }
}