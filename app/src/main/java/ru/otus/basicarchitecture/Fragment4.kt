package ru.otus.basicarchitecture

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import ru.otus.WizardCache
import ru.otus.basicarchitecture.databinding.Fragment4Binding



class Fragment4 : Fragment() {

    private var  cache: WizardCache = WizardCache.Impl

    private var binding: Fragment4Binding? = null

    private inline fun withBinding(block: Fragment4Binding.() -> Unit) {
        binding?.block()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = Fragment4Binding.inflate(layoutInflater, container, false)
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

            textView2.setTextKeepState(cache.data.name)
            textView4.setTextKeepState(cache.data.surName)
            textView6.setTextKeepState(cache.data.bd.toString())
            textView8.setTextKeepState("${cache.data.country} ${cache.data.city} ${cache.data.address}")

            interesting1.isVisible = cache.data.teg1
            interesting2.isVisible = cache.data.teg2
            interesting3.isVisible = cache.data.teg3
            interesting4.isVisible = cache.data.teg4
            interesting5.isVisible = cache.data.teg5
            interesting6.isVisible = cache.data.teg6
            interesting7.isVisible = cache.data.teg7
            interesting8.isVisible = cache.data.teg8

        }



    }

}