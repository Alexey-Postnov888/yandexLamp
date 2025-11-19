package ru.alexeypostnov.yandexlamp.presenter.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alexeypostnov.yandexlamp.data.model.ColorInfo
import ru.alexeypostnov.yandexlamp.data.model.androidColor
import ru.alexeypostnov.yandexlamp.databinding.ItemColorBinding

class ColorsAdapter(
    private val onButtonListener: (String) -> Unit,
) : RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder>() {
    private var colorsList: List<ColorInfo> = listOf()

    class ColorsViewHolder(
        val binding: ItemColorBinding,
        private val onButtonListener: (String) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ColorInfo) {
            binding.colorBtn.backgroundTintList = ColorStateList.valueOf(item.androidColor)
            binding.colorBtn.setOnClickListener {
                onButtonListener(item.name)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ColorsViewHolder {
        val content = parent.context
        val layoutInflater = LayoutInflater.from(content)
        val binding = ItemColorBinding.inflate(
            layoutInflater,
            parent,
            false
        )

        return ColorsViewHolder(binding, onButtonListener)
    }

    override fun onBindViewHolder(
        holder: ColorsViewHolder,
        position: Int
    ) {
        val item = colorsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = colorsList.size

    fun submitColorsList(list: List<ColorInfo>) {
        colorsList = list
        notifyDataSetChanged()
    }
}