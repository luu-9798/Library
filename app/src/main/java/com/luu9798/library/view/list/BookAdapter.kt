package com.luu9798.library.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luu9798.library.R
import com.luu9798.library.model.Book

class BookAdapter(private val books: List<Book>, private val callback: (book: Book) -> Unit)
    : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_view_title)
        val authorTextView: TextView = itemView.findViewById(R.id.text_view_author)
        val statusTextView: TextView = itemView.findViewById(R.id.text_view_status)
        val feeTextView: TextView = itemView.findViewById(R.id.text_view_fee)
        val lastEditedTextView: TextView = itemView.findViewById(R.id.text_view_last_edited)

        fun getDisplayStringResources(id: Int, text: String): String {
            return itemView.resources.getString(id, text)
        }

        fun setOnClickListener(clickListener: View.OnClickListener?) {
            itemView.setOnClickListener(clickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text =
            holder.getDisplayStringResources(R.string.title_display, books[position].title)
        holder.authorTextView.text =
            holder.getDisplayStringResources(R.string.author_display, books[position].author)
        holder.statusTextView.text =
            holder.getDisplayStringResources(R.string.status_display, books[position].status)
        holder.feeTextView.text =
            holder.getDisplayStringResources(R.string.fee_display, books[position].fee.toString())
        holder.lastEditedTextView.text =
            holder.getDisplayStringResources(R.string.last_edited_display, books[position].lastEdited)
        holder.setOnClickListener {
            callback.invoke(books[position])
        }
    }
}
