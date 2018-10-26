package com.mykotlinapp.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.employee.R

class EmpListAdapter(context:Context) : RecyclerView.Adapter<EmpListAdapter.EmpViewHolder>() {

    class EmpViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
      var empItemName : TextView;
        var empItemAge : TextView;

        init {
            empItemName = itemView.findViewById(R.id.name);
            empItemAge = itemView.findViewById(R.id.age);

        }

    }

    private  var mInflater : LayoutInflater
    private var memployees : List<Employee>? = null  // Cached copy of words
    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): EmpViewHolder {
        val itemView : View = mInflater.inflate(R.layout.recyclerview_item,holder,false)
        return EmpViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmpViewHolder, position: Int) {
        if(memployees != null){
             val current:Employee = memployees!![position]
            holder.empItemName.setText(current.name)
            holder.empItemAge.setText(current.mAge)

        }else{
            holder.empItemName.setText("No Employee")
        }
    }

    fun setWords(employees: List<Employee>){
        memployees = employees
        notifyDataSetChanged()
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    override fun  getItemCount() :Int{
        if (memployees != null)
            return memployees!!.size
        else return 0
    }
}