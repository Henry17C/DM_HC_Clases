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
import com.test.dm_clases_hc.databinding.AnimeItemsBinding
import com.test.dm_clases_hc.databinding.UsersItemsBinding

//lista de users
class AnimeAdapter(private val listTopAnime:List<Data>): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {


    class AnimeViewHolder(view: View):RecyclerView.ViewHolder(view) {

        //se maneja los elementos(items)  uno por uno iterativamente. Esta se
        // manera de acuerdo a las necesidades de la aplicacion, es maneja la logica ligada a la UI, no a la logica de negocio
        private var binding: AnimeItemsBinding = AnimeItemsBinding.bind(view)


        fun render(item: Data){
            binding.imageView.load(item.images.jpg.small_image_url)
            binding.txtId.text= item.title_japanese
            binding.txtName.text=item.synopsis

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        //se hace el binding para el  layout que tenemos
         val  inflater= LayoutInflater.from(parent.context) //
        return AnimeViewHolder(inflater.inflate(R.layout.anime_items,parent, false)) //



    }

     //cuantos elementos hay para poder pintar en pantalla
    override fun getItemCount(): Int = listTopAnime.size
     override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
     holder.render(listTopAnime[position])
    }


}