package com.example.parse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.parse.databinding.FragmentSecondBinding
import kotlinx.coroutines.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment() : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var model: ParseViewModel? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ListComposable(model?.countriesList)
            }
        }
        //return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity())[ParseViewModel::class.java]
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
    fun displayAndParseJson(): List<CountryInfo>?{
        val viewModel = ParseViewModel()
        var mutableCountryList = mutableListOf<CountryInfo>()
        GlobalScope.async(Dispatchers.Main) {
            delay(100000)
            viewModel.parseJson()?.let { mutableCountryList.addAll(it) }
        }

        return mutableCountryList
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}