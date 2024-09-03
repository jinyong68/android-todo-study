package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBlogBinding


class BlogAdapter(private val blogs: List<Blog>,val t : () ->Unit) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position:Int)
    }

    var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            ItemBlogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }




    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blogs[position])
    }

    override fun getItemCount(): Int = blogs.size

    inner class BlogViewHolder(private val binding: ItemBlogBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(blog: Blog) {
            binding.blogTitleText.text = blog.title
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
                Log.d("안녕하세요", "안녕하세요")

                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                    Log.d("안녕하세요", "안녕하세요")


                    t()
                }
            }
        }

//        init {
//            itemView.setOnClickListener {
//                itemClickListener?.onItemClick(adapterPosition)
//                Log.d("안녕하세요", "안녕하세요")
//
//                val position = adapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    itemClickListener?.onItemClick(position)
//                    Log.d("안녕하세요", "안녕하세요")
//
//
//                    val fragment = WriteFragment()
//
//                    // FragmentTransaction 시작
//                    val transaction = fragmentManager.beginTransaction()
//                    transaction.replace(R.id.write_fragment, fragment)
//                    transaction.addToBackStack(null) // 뒤로가기 시 이전 프래그먼트로 돌아가기 위해
//                    transaction.commit()
//                }
//            }
//        }
    }
}

