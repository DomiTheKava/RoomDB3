package com.example.databaseapp3.User.fragments.list

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseapp3.R
import com.example.databaseapp3.model.User

class RvListAdapter: RecyclerView.Adapter<RvListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.id_tv).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.fname_tv).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.lname_tv).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.age_tv).text = currentItem.age.toString()

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {

            val bundle = Bundle().apply {
                putParcelable("currentItem", currentItem)
                putInt("id", currentItem.id)
                putString("firstName", currentItem.firstName)
                putString("lastName", currentItem.lastName)
                putInt("age", currentItem.age)

//                val message = "ID: ${currentItem.id}, First Name: ${currentItem.firstName}, Last Name: ${currentItem.lastName}, Age: ${currentItem.age}"
//                Toast.makeText(holder.itemView.context, message, Toast.LENGTH_SHORT).show()

            }
            // issues with code from video
//            val action = R.layout.fragment_update.
//            findNavController().navigate(R.id.action_listFragment_to_addFragment)

            // this opens update fragment and passes bundle
            holder.itemView.findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
        }
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

}