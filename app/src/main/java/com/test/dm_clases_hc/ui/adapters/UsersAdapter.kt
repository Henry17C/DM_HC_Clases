package com.test.dm_clases_hc.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.data.local.entities.Users
import com.test.dm_clases_hc.databinding.UsersItemsBinding

//lista de users
class UsersAdapter(private val listUsers:List<Users>): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {


    class UsersViewHolder(view: View):RecyclerView.ViewHolder(view) {

        //se maneja los elementos(items)  uno por uno iterativamente. Esta se
        // manera de acuerdo a las necesidades de la aplicacion, es maneja la logica ligada a la UI, no a la logica de negocio
        private var binding: UsersItemsBinding = UsersItemsBinding.bind(view)

        fun render(item: Users){
            binding.imageView.load("https://previews.123rf.com/images/bahtiarmaulana/bahtiarmaulana2204/bahtiarmaulana220400040/185159316-rebanada-de-dibujos-animados-de-pizza-ilustraci%C3%B3n-de-dibujos-animados-vectoriales-im%C3%A1genes.jpg"){
                crossfade(true)
                placeholder(R.drawable.image)
                transformations(CircleCropTransformation())
            }
            binding.txtId.text=item.id.toString()
            binding.txtName.text=item.firstName.toString()
            binding.txtLastName.text=item.lastName.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        //se hace el binding para el  layout que tenemos
         val  inflater= LayoutInflater.from(parent.context) //

        return UsersViewHolder(inflater.inflate(R.layout.users_items,parent, false)) //



    }

     //cuantos elementos hay para poder pintar en pantalla
    override fun getItemCount(): Int = listUsers.size

     override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
     holder.render(listUsers[position])
    }


}