package com.example.volleydatafromapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.volleydatafromapi.Models.Article
import com.example.volleydatafromapi.R
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class AdapterNews(var context:Context, var list: ArrayList<Article>): RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.row_news_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = list[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(lst: ArrayList<Article>) {
        list = lst
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.text_view_title.text = article.title+"\n"
        }
    }
}