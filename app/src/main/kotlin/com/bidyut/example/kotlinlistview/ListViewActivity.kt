package com.bidyut.example.kotlinlistview

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

public class ListViewActivity() : Activity() {

    override fun onCreate(savedState: Bundle?) {
        super<Activity>.onCreate(savedState)
        setContentView(R.layout.activity_list_view)

        val lv = findViewById(R.id.list) as ListView
        lv.setAdapter(ListExampleAdapter(this))
    }

    private class ListExampleAdapter(context: Context) : BaseAdapter() {
        private val mInflater: LayoutInflater?

        {
            mInflater = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return sList.size
        }

        override fun getItem(position: Int): Any {
            return sList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val vh: ListRowHolder
            if (convertView == null) {
                view = mInflater?.inflate(R.layout.list_row, parent, false)
                vh = ListRowHolder(view)
                view?.setTag(vh)
            } else {
                view = convertView
                vh = view?.getTag() as ListRowHolder
            }

            vh.label.setText(sList[position])
            return view
        }

        class object {
            private val sList = array("One", "Two", "Three", "Four", "Five", "Six", "Seven",
                    "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen")
        }
    }

    private class ListRowHolder(row: View?) {
        public val label: TextView

        {
            this.label = row?.findViewById(R.id.label) as TextView
        }
    }
}
