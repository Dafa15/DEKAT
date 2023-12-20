package com.capstone.dekat.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.dekat.adapter.ListTapisAdapter
import com.capstone.dekat.data.remote.response.ListTapisResponse
import com.capstone.dekat.databinding.FragmentHomeBinding
import com.capstone.dekat.ui.detail.DetailActivity
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false) // Inisialisasi binding di sini

        setupAction()

        lifecycleScope.launch {
            viewModel.isLoading.observe(viewLifecycleOwner){showLoading(it)}
            setUserList(viewModel.getList())
        }

        return binding.root
    }

    private fun setupAction() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvTapis.layoutManager =layoutManager
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.rvTapis.addItemDecoration(itemDecoration)
    }

    private fun setUserList(user: List<ListTapisResponse>) {
        val tapisAdapter = ListTapisAdapter()
        tapisAdapter.submitList(user)
        binding.rvTapis.adapter = tapisAdapter

        tapisAdapter.setOnItemClickCallback(object : ListTapisAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ListTapisResponse) {
                val intent = Intent(requireActivity(), DetailActivity::class.java)
                intent.putExtra(DetailActivity.TAPIS_ID, data.id)
                startActivity(intent)
            }
        })
    }

    private fun showLoading(state: Boolean) { binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }

}