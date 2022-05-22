package com.example.wsrfood.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wsrfood.R
import com.example.wsrfood.server.Food
import com.example.wsrfood.server.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rec: RecyclerView = root.findViewById(R.id.rec)

        val call = MyRetrofit.getRetrofit().getDishes()
        call.enqueue(object : Callback<ArrayList<Food>>{
            override fun onResponse(
                call: Call<ArrayList<Food>>,
                response: Response<ArrayList<Food>>
            ) {
                response.body()?.let { rec.adapter = FoodAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<ArrayList<Food>>, t: Throwable) {
                AlertDialog.Builder(context).setTitle("Error").setMessage(t.message).show()
            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}