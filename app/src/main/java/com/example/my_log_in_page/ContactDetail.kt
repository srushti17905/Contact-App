package com.example.my_log_in_page

import java.io.Serializable

data class ContactDetail(

    var id: Int, var firstname: String, var number: String , var surname : String

) : Serializable