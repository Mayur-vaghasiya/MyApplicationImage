package com.example.myapplication.ui

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.ItemImageResponse
import com.example.myapplication.network.ApiInterface
import com.example.myapplication.network.RetrofitInstance
import com.example.myapplication.ui.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ImageItemVM (application: Application) : BaseViewModel<ImageItemNavigator>(application)  {

    var itemImageList: MutableLiveData<ArrayList<ItemImageResponse.Data.User>> = MutableLiveData()
    var service: ApiInterface? = null



   fun GetItemsImageList(offset:Int,limit:Int){
       service = RetrofitInstance.getRetrofitInstance()!!.create(ApiInterface::class.java)
       val call: Call<ItemImageResponse.Data>? = service?.getItemImage(offset,limit)

       call?.enqueue(object : Callback<ItemImageResponse.Data> {
           override fun onResponse(call: Call<ItemImageResponse.Data>, response: Response<ItemImageResponse.Data>) {

               itemImageList.value=response.body()?.users
           }

           override fun onFailure(call: Call<ItemImageResponse.Data>, t: Throwable) {

               Toast.makeText(context, "Sync Fail!", Toast.LENGTH_SHORT).show()
           }
       })
   }
}