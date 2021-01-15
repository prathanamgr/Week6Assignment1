package com.aakash.softuser1.fragment.Student

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aakash.softuser1.R
import com.aakash.softuser1.model.Database
import com.aakash.softuser1.model.Student

class StudentFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var etImage: EditText
    private lateinit var btnSave: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_student, container, false)
        etName = root.findViewById(R.id.etName)
        etAge = root.findViewById(R.id.etAge)
        rgGender = root.findViewById(R.id.rgGender)
        rbMale = root.findViewById(R.id.rbMale)
        rbFemale = root.findViewById(R.id.rbFemale)
        rbOthers = root.findViewById(R.id.rbOthers)
        etAddress = root.findViewById(R.id.etAddress)
        etImage =root.findViewById(R.id.etImage)
        btnSave = root.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            if (isValid()){
                val database = Database()

                val CheckID = rgGender.checkedRadioButtonId
                val checkedrb: RadioButton = root.findViewById(CheckID)
                val gender = checkedrb.text.toString();
                database.appendStudent(
                    Student(etName.text.toString(),
                            etAge.text.toString().toInt(),
                        gender,
                        etAddress.text.toString(),
                        etImage.text.toString())
                )
                Toast.makeText(activity?.applicationContext, "Student Added", Toast.LENGTH_SHORT).show()
                clearFields()
        }

        }
        return root
    }

    private fun clearFields(){
        etName.setText("")
        etAge.setText("")
        rgGender.clearCheck()
        etAddress.setText("")
        etImage.setText("")
    }

private fun isValid(): Boolean {
    var flag = true
   if (TextUtils.isEmpty(etName.text)){
       etName.error = "Please enter Username!"
       etName.requestFocus()
       flag = false
   }else if (TextUtils.isEmpty(etAge.text)){
       etAge.error = "Please enter age!"
       etAge.requestFocus()
       flag = false
   }
    return flag
}
}