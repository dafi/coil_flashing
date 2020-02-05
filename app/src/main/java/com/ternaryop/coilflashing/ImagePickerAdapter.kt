package com.ternaryop.coilflashing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.request.Request
import com.squareup.picasso.Picasso

class ImagePickerAdapter(private val myDataset: List<Int>) :
    RecyclerView.Adapter<ImagePickerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val thumbImage = itemView.findViewById<View>(R.id.thumbnail_image) as ImageView

        fun bindModelCoil(thumbnailUrl: Int) {
            thumbImage.load(thumbnailUrl) {
                placeholder(R.drawable.stub)
//                crossfade(2000)
            }
        }
        fun bindModelPicasso(thumbnailUrl: Int) {
            Picasso
                .get()
                .load(thumbnailUrl)
                .placeholder(R.drawable.stub)
                .noFade()
                .fit()
                .centerCrop()
                .into(thumbImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ImagePickerAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.gridview_photo_picker_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindModelCoil(myDataset[position])
//        holder.bindModelPicasso(myDataset[position])
    }

    override fun getItemCount() = myDataset.size
}
