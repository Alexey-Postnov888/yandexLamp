package ru.alexeypostnov.yandexlamp.presenter

import android.content.Context
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.androidbroadcast.vbpd.viewBinding
import ru.alexeypostnov.yandexlamp.R
import ru.alexeypostnov.yandexlamp.appComponent
import ru.alexeypostnov.yandexlamp.databinding.FragmentMainBinding
import ru.alexeypostnov.yandexlamp.di.viewModel.ViewModelFactory
import ru.alexeypostnov.yandexlamp.presenter.adapters.ColorsAdapter
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private var adapter: ColorsAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels{viewModelFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.colorsList.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        adapter = ColorsAdapter(
            ::onButtonListener
        )
        binding.colorsList.adapter = this.adapter

        viewModel.colors.observe(viewLifecycleOwner) {
            adapter?.submitColorsList(it)
        }

        binding.on.setOnClickListener {
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            viewModel.setStateOn()
        }

        binding.off.setOnClickListener {
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            viewModel.setStateOff()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        val component = context.appComponent
        component.inject(this)
        super.onAttach(context)
    }

    fun onButtonListener(name: String): Unit {
        viewModel.applyColor(name)
    }
}