package com.gervant08.finalqualifyingwork.ui.main.basket.order

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.tools.OrderNotification
import java.text.SimpleDateFormat
import java.util.*

class OrderFragment: Fragment(R.layout.fragment_basket_order) {
    private val viewModel: OrderViewModel by viewModels()

    private lateinit var basketOrderHumanCount: TextView
    private lateinit var basketOrderTitle: TextView
    private lateinit var basketOrderTable: TextView
    private lateinit var basketOrderSum: TextView
    private lateinit var basketOrderClockNum: TextView
    private lateinit var basketOrderHumanCountMenu: Button
    private lateinit var basketOrderTableMenu: Button
    private lateinit var basketOrderClock: Button
    private lateinit var orderButton: Button
    private val orderNotification = OrderNotification()
    private lateinit var orderDialogFragment: OrderDialogFragment
    private var orderTime: String = ""

    companion object{
        const val POPUP_TABLE: Int = R.menu.popup_table_menu
        const val POPUP_HUMAN: Int = R.menu.popup_human_count_menu
        const val NOTIFICATION_TITLE = "Ваш заказ скоро будет готов"
        const val NOTIFICATION_TEXT = "Через 20 минут ваш заказ будет готов. Приходите, мы вас ждем"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basketOrderHumanCount = view.findViewById(R.id.basketOrderHumanCount)
        basketOrderTitle = view.findViewById(R.id.basketOrderTitle)
        basketOrderTable = view.findViewById(R.id.basketOrderTable)
        basketOrderSum = view.findViewById(R.id.basketOrderSum)
        basketOrderClockNum = view.findViewById(R.id.basketOrderClockNum)
        basketOrderHumanCountMenu = view.findViewById(R.id.basketOrderHumanCountMenu)
        basketOrderTableMenu = view.findViewById(R.id.basketOrderTableMenu)
        basketOrderClock = view.findViewById(R.id.basketOrderClock)
        orderButton = view.findViewById(R.id.orderButton)
        basketOrderSum.text = viewModel.calculateOrderAmount()
        setUpClickListeners()
    }

    private fun setUpClickListeners(){
        basketOrderHumanCountMenu.setOnClickListener { showPopupMenu(POPUP_HUMAN, it) }
        basketOrderTableMenu.setOnClickListener { showPopupMenu(POPUP_TABLE, it) }
        basketOrderClock.setOnClickListener { showTimePickerDialog() }
        orderButton.setOnClickListener { makeOrder() }
    }

    private fun showPopupMenu(menuId: Int, view: View){
        val popupMenu = PopupMenu(context, view)
        popupMenu.inflate(menuId)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->

            if (menuId == POPUP_TABLE)
                basketOrderTable.text = viewModel.chooseTable(item.itemId)

            if (menuId == POPUP_HUMAN)
                basketOrderHumanCount.text = viewModel.chooseHumanCount(item.itemId)

            true
        }

        popupMenu.show()
    }


    private fun showTimePickerDialog(){

        val calendar = Calendar.getInstance()

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            orderTime = SimpleDateFormat("HH:mm").format(calendar.time)
            basketOrderClockNum.text = orderTime
        }

        TimePickerDialog(context, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        val name = "Name"
        val descriptionText = "Description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(OrderNotification.CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager = activity!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun isOrderReadyToCreated(): Boolean =
         (basketOrderHumanCount.text.length != 0
            && basketOrderTable.text.length != 0
            && basketOrderClockNum.text.length != 0)



    private fun makeOrder(){
        var orderDescription = viewModel.createTextForDialogFragment(isOrderReadyToCreated())
        val manager = childFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        orderDialogFragment = OrderDialogFragment(orderDescription.first, orderDescription.second)
        orderDialogFragment.show(transaction, "Order")
        createNotificationChannel()
        orderNotification.createNotification(requireContext(), NOTIFICATION_TITLE, NOTIFICATION_TEXT)
    }
}