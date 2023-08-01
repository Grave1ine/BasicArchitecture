package ru.otus.basicarchitecture

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.otus.basicarchitecture.databinding.Fragment3Binding
import ru.otus.basicarchitecture.viewModel.viewModelFR3

class Fragment3 : Fragment() {

    private var binding: Fragment3Binding? = null


    private inline fun withBinding(block: Fragment3Binding.() -> Unit) {
        binding?.block()
    }

    private val dataModel: viewModelFR3 by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = Fragment3Binding.inflate(layoutInflater, container, false)
        return binding!!.root
    }


    override fun onDestroyView() {

        super.onDestroyView()
        binding = null
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        withBinding {

            dataModel.viewState.observe(viewLifecycleOwner) { state ->
                interesting1.isEnabled = state.teg1
                interesting2.isEnabled = state.teg2
                interesting3.isEnabled = state.teg3
                interesting4.isEnabled = state.teg4
                interesting5.isEnabled = state.teg5
                interesting6.isEnabled = state.teg6
                interesting7.isEnabled = state.teg7
                interesting8.isEnabled = state.teg8
            }

            goToFR4.setOnClickListener{
                // ОЧЕНЬ не рекомендуется прокидывать контекст активити в модель
                // Помним, что модель живет ДОЛЬШЕ активити.
                findNavController().navigate(R.id.action_fragment3_to_fragment4)
            }

            dataModel.setTeg1(interesting1.isChecked)
            dataModel.setTeg2(interesting2.isChecked)
            dataModel.setTeg3(interesting3.isChecked)
            dataModel.setTeg4(interesting4.isChecked)
            dataModel.setTeg5(interesting5.isChecked)
            dataModel.setTeg6(interesting6.isChecked)
            dataModel.setTeg7(interesting7.isChecked)
            dataModel.setTeg8(interesting8.isChecked)
        }

    }

}