package com.example.myhouse.features.doors.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.myhouse.R
import com.example.myhouse.databinding.ItemDoorBinding
import com.example.myhouse.features.doors.domain.model.Door

class DoorsAdapter(
    private val doors: List<Door>
) : RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>() {

    class DoorsViewHolder(view: View) : ViewHolder(view) {
        private val viewBinding: ItemDoorBinding by viewBinding(ItemDoorBinding::bind)
        fun bind(door: Door) {
            viewBinding.tvDoorName.text = door.name
            if(door.snapshot?.isNotEmpty() == true){
                viewBinding.tvOnline.text = itemView.context.getText(R.string.online)
                Glide.with(viewBinding.ivDoor).load(door.snapshot).transform(CenterInside(),
                    RoundedCorners(24)
                ).into(viewBinding.ivDoor)
                viewBinding.ivPlay.isVisible = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val cellForDoor =
            LayoutInflater.from(parent.context).inflate(R.layout.item_door, parent, false)
        return DoorsViewHolder(cellForDoor)
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(doors[position])
    }

    override fun getItemCount(): Int {
        return doors.size
    }
}