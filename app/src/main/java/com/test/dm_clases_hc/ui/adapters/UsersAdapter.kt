package com.test.dm_clases_hc.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.data.local.entities.Users
import com.test.dm_clases_hc.data.network.endpoint.jikan.top.Data
import com.test.dm_clases_hc.databinding.UsersItemsBinding

//lista de users
class UsersAdapter(private val listTopAnime:List<Data>): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {


    class UsersViewHolder(view: View):RecyclerView.ViewHolder(view) {

        //se maneja los elementos(items)  uno por uno iterativamente. Esta se
        // manera de acuerdo a las necesidades de la aplicacion, es maneja la logica ligada a la UI, no a la logica de negocio
        private var binding: UsersItemsBinding = UsersItemsBinding.bind(view)

        fun render(item: Data){
            binding.imageView.load(item.images.jpg.large_image_url.toString()){
                crossfade(true)
                placeholder(R.drawable.image)
                transformations(CircleCropTransformation())
            }
            binding.txtId.text=item.mal_id.toString()
            binding.txtName.text=item.title_english.toString()
            binding.txtLastName.text=item.title_japanese.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        //se hace el binding para el  layout que tenemos
         val  inflater= LayoutInflater.from(parent.context) //

        return UsersViewHolder(inflater.inflate(R.layout.users_items,parent, false)) //



    }

     //cuantos elementos hay para poder pintar en pantalla
    override fun getItemCount(): Int = listTopAnime.size

     override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
     holder.render(listTopAnime[position])
    }


}