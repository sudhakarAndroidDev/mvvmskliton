package net.simplifiedcoding.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import net.simplifiedcoding.data.network.Resource
import net.simplifiedcoding.data.responses.BookModel
import net.simplifiedcoding.data.responses.HomeResponse
import net.simplifiedcoding.databinding.BookItemBinding

class BookAdapter(private var postList: List<BookModel>)
    : RecyclerView.Adapter<BookAdapter.PostViewHolder>() {
    private lateinit var binding: BookItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = BookItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tvBooking.text = postList[position].bookigId.toString()
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}