package net.simplifiedcoding.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.simplifiedcoding.R
import net.simplifiedcoding.data.network.RemoteDataSource
import net.simplifiedcoding.data.network.Resource
import net.simplifiedcoding.databinding.FragmentLoginBinding
import net.simplifiedcoding.ui.enable
import net.simplifiedcoding.ui.handleApiError
import net.simplifiedcoding.ui.home.HomeActivity
import net.simplifiedcoding.ui.startNewActivity
import net.simplifiedcoding.ui.visible
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    if (it.value.token != null){
                        Navigation.findNavController(binding.root)
                            .navigate(R.id.action_loginFragment_to_homeFragment2)
                    }
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Failure -> {
                    binding.progressbar.visibility = View.GONE
                    Log.i("jjcdn",it.toString())
                    Toast.makeText(requireContext(), "Login failure", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        })

        binding.btnLogin.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE
            login()
        }
    }

    private fun login() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        viewModel.login(email, password)
    }
}