package com.naftalimurgor.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naftalimurgor.recyclerview.R
import com.naftalimurgor.recyclerview.model.Affirmation

// the Adapter needs ifnormation about how to resolve the string resources, this and other info
// is stored inside Context object instance, that can be pased
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // the Recycler does not directly interact with view sbut deals with ViewHolders
    // A ViewHolder represents an individual Item in list in view in RecyclerView
    // ViewHolder instance holds refferences to individual views within a list
    // NB: defining a class inside another class is called nested class
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }


    // onCreateViewHolder method is called by layout manager to create new view olders for the RecyclerView
    // Returns a ViewHolder object
    // Takes parent context which is the view gorup which item will be attached as a child
    // The parent is the Recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // obtain an instance of LayoutInflater from the provided context(context of parent)
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    // returns the size of the items to display
    override fun getItemCount() = dataset.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Affirmation = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}