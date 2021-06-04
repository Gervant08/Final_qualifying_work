package com.gervant08.finalqualifyingwork.ui.main.basket.order

import android.app.*
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.tools.OrderNotification
import java.text.SimpleDateFormat
import java.util.*

class OrderFragment : Fragment(R.layout.fragment_basket_order) {
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
    private lateinit var orderDialogFragment: OrderDialogFragment
    private lateinit var orderNotification: OrderNotification
    private var orderTime: String = ""
    private val calendar = Calendar.getInstance()


    companion object {
        const val POPUP_TABLE: Int = R.menu.popup_table_menu
        const val POPUP_HUMAN: Int = R.menu.popup_human_count_menu
        const val TIME_PATTERN = "HH:mm"
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

    private fun setUpClickListeners() {
        basketOrderHumanCountMenu.setOnClickListener { showPopupMenu(POPUP_HUMAN, it) }
        basketOrderTableMenu.setOnClickListener { showPopupMenu(POPUP_TABLE, it) }
        basketOrderClock.setOnClickListener { showTimePickerDialog() }
        orderButton.setOnClickListener { makeOrder() }
    }

    private fun showPopupMenu(menuId: Int, view: View) {
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


    private fun showTimePickerDialog() {
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            orderTime = SimpleDateFormat(TIME_PATTERN, Locale.US).format(calendar.time)
            if (isOrderTimeCorrect(calendar.time.hours)) {
                basketOrderClockNum.text = orderTime
            } else {
                createDialog("Время выбрано неверно" to
                            "Заказ может быть сделан с 10:00 до 22:00. Заказ нужно сделать минимум за час до прибытия в ресторан"
                )
            }

        }
        TimePickerDialog(
            context,
            timeSetListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()

        createDialog("Выбор времени заказа" to
                "Заказ может быть сделан с 10:00 до 22:00. Заказ нужно сделать минимум за час до прибытия в ресторан"
        )

    }

    private fun isOrderTimeCorrect(orderTime: Int): Boolean {
        val restaurantOpeningTime = 10
        val restaurantEndingTime = 24
        val systemTime = Calendar.getInstance().time.hours
        if (orderTime >= systemTime + 1 &&
            orderTime > restaurantOpeningTime &&
            orderTime < restaurantEndingTime - 2
        ) {
            return true
        }
        return false
    }

    private fun makeOrder() {
        createDialog(viewModel.createTextForDialogFragment(isOrderReadyToCreated()))
        createOrderNotification()
    }

    private fun createDialog(titleAndText: Pair<String, String>) {
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        orderDialogFragment = OrderDialogFragment(titleAndText.first, titleAndText.second)
        orderDialogFragment.show(transaction, "Order")
    }

    private fun isOrderReadyToCreated(): Boolean =
        (basketOrderHumanCount.text.isNotEmpty()
                && basketOrderTable.text.isNotEmpty()
                && basketOrderClockNum.text.isNotEmpty())


    private fun createOrderNotification() {
        orderNotification = OrderNotification(requireContext())
        orderNotification.createNotification(orderTime)
    }

}