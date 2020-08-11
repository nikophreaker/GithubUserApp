package com.example.githubuserapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter (val context: Context,val list: List<User>) : RecyclerView.Adapter<UserAdapter.Holder>(), Filterable{
    inner class Holder(val view: View) : RecyclerView.ViewHolder(view)
    internal var filterListResult : List<User>

    init {
        this.filterListResult = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(p0.context).inflate(R.layout.item_user,p0,false))
    }

    override fun getItemCount(): Int {
        return filterListResult.size
    }

    override fun onBindViewHolder(p0: Holder, position: Int) {
        val user : User = filterListResult[position]
        p0.view.avatar.setBackgroundResource(user.avatar)
        p0.view.username.text = user.username
        p0.view.name.text = user.name
        p0.view.lokasi.text = user.lokasi
        p0.itemView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("user", user)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

    override fun getFilter(): android.widget.Filter {
        return object:android.widget.Filter(){
            override fun performFiltering(charString: CharSequence?): FilterResults {
                val charSearch = charString.toString()
                if(charSearch.isEmpty())
                    filterListResult = list
                else
                {
                    val resultList = ArrayList<User>()
                    for (row in list)
                    {
                        if (row.username!!.toLowerCase().contains(charSearch.toLowerCase())
                            || row.name!!.toLowerCase().contains(charSearch.toLowerCase())
                            || row.lokasi!!.toLowerCase().contains(charSearch.toLowerCase()))
                            resultList.add(row)
                    }
                    filterListResult = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterListResult
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                filterListResult = filterResults!!.values as List<User>
                notifyDataSetChanged()
            }

        }
    }

}

