package com.aakash.softuser1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aakash.softuser1.R
import com.aakash.softuser1.model.Database
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

private var database = Database()
private var listStudent = database.returnStudent()

class StudentAdapter (val context: Context): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name : TextView
        val age: TextView
        val gender: TextView
        val address: TextView
        val image: CircleImageView
        val deletebtn: ImageButton

        init {
            name = view.findViewById(R.id.tvName)
            age = view.findViewById(R.id.tvAge)
            gender = view.findViewById(R.id.tvGender)
            address = view.findViewById(R.id.tvAddress)
            image = view.findViewById(R.id.cvProfile)
            deletebtn = view.findViewById(R.id.ibDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.studentdetails_layout,parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val studentInfo = listStudent.asReversed()[position]
        holder.name.setText(studentInfo.name)
        holder.age.setText(studentInfo.age.toString())
        holder.gender.setText(studentInfo.gender)
        holder.address.setText(studentInfo.address)

        holder.deletebtn.setOnClickListener(View.OnClickListener{
            listStudent.remove(studentInfo)
            notifyItemRemoved(position)
            Toast.makeText(context, "Student Deleted", Toast.LENGTH_SHORT).show()
        })
        Glide.with(context)
            .load(studentInfo?.imageUrl)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }
}