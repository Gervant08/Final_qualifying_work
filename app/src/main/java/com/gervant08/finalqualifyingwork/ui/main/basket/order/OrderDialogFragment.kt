package com.gervant08.finalqualifyingwork.ui.main.basket.order

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gervant08.finalqualifyingwork.R

class OrderDialogFragment(private val dialogTitle: String, private val dialogText: String): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(dialogTitle)
                .setMessage(dialogText)
                .setIcon(R.drawable.ic_basket)
                .setPositiveButton("Понятно") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}