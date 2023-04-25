package com.example.myhouse.features.cameras.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.myhouse.R
import com.example.myhouse.databinding.ItemCameraBinding
import com.example.myhouse.features.cameras.domain.model.Camera

class CamerasAdapter(
    private val cameras: List<Camera>
) : RecyclerView.Adapter<CamerasAdapter.CamerasViewHolder>() {

    class CamerasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val viewBinding: ItemCameraBinding by viewBinding(ItemCameraBinding::bind)
        fun bind(camera: Camera) {
            viewBinding.tvCameraName.text = camera.name
            Glide.with(viewBinding.ivCamera).load(camera.snapshot).transform(
                CenterInside(),
                RoundedCorners(24)
            ).into(viewBinding.ivCamera)
            viewBinding.ivPlay.isVisible = true
            viewBinding.ivFavorite.isVisible = camera.favorites
            viewBinding.ivRec.isVisible = camera.rec

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        val cellForDoor =
            LayoutInflater.from(parent.context).inflate(R.layout.item_camera, parent, false)
        return CamerasViewHolder(cellForDoor)
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount(): Int {
        return cameras.size
    }
}