package com.example.myapplication.ui


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.adapter.ItemImageAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.ItemImageResponse
import com.example.myapplication.ui.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding, ImageItemVM>(),ImageItemNavigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageItemVM: ImageItemVM
    private lateinit var itemImageAdapter: ItemImageAdapter
    private lateinit var itemList:ArrayList<ItemImageResponse.Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDefaultValues()
        setHeader()
        imageItemVM.GetItemsImageList(0,10)
    }

    private fun setPartnerRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)

        itemImageAdapter = ItemImageAdapter(
            this,
            itemList)
        binding.recyclerViewItem.apply {
            this.layoutManager = layoutManager
            this.adapter = itemImageAdapter

        }
    }
    private fun setDefaultValues() {
        binding = getViewDataBinding()
        binding.let {
            it.lifecycleOwner = this
            it.imageItemVM = imageItemVM
        }

        imageItemVM.attachContext(this)
        imageItemVM.setNavigator(this)

    }

    override val bindingVariable: Int
        get() = BR.ImageItemVM
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: ImageItemVM
        get() {
            imageItemVM = ViewModelProvider(this).get(ImageItemVM::class.java)
            return imageItemVM
        }

    override fun setHeader() {
        TODO("Not yet implemented")
    }

    override fun setObservers() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun goBack() {
        TODO("Not yet implemented")
    }

}