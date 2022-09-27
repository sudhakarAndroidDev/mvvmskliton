package net.simplifiedcoding.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import net.simplifiedcoding.R
import net.simplifiedcoding.data.network.Resource
import net.simplifiedcoding.data.responses.BookModel
import net.simplifiedcoding.databinding.FragmentHomeBinding
import org.json.JSONObject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var bookAdapter: BookAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val bookModel = ArrayList<BookModel>()

        viewModel.getBook()
        viewModel.book.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    for (i in 0 until it.value.size) {
                        val bookId: Int = it.value.get(i).bookingid
                        bookModel.add(BookModel(bookId))
                    }
                    bookAdapter = BookAdapter(bookModel)
                    binding.rvBook.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = bookAdapter
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        })
    }

}