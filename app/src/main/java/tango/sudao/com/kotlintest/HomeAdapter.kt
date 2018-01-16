package tango.sudao.com.kotlintest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by pcdalao on 2018/1/6.
 */
class HomeAdapter(var data:ArrayList<String>,var context:Context): RecyclerView.Adapter<ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.setText(R.id.item_text,data.get(position))
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

}