package com.test.dm_clases_hc.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.coyago.testapp.ui.core.Constants
import com.google.android.material.snackbar.Snackbar
import com.test.dm_clases_hc.R
import com.test.dm_clases_hc.ui.fragments.FavoritesFragment
import com.test.dm_clases_hc.data.core.My_Applycation
import com.test.dm_clases_hc.data.local.entities.Users
import com.test.dm_clases_hc.databinding.ActivityMainBinding
import com.test.dm_clases_hc.logic.usercases.jikan.JikanAnimeUserCase
import com.test.dm_clases_hc.logic.usercases.jikan.JikanGetTopAnimesUserCase
import com.test.dm_clases_hc.logic.usercases.local.login.LoginUserCase
import com.test.dm_clases_hc.ui.adapters.UsersAdapter
import com.test.dm_clases_hc.ui.fragments.ListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {




    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FRAGMENTS

            val listFragment = ListFragment()
            val favoritesFragment = FavoritesFragment()

            val transaction = supportFragmentManager.beginTransaction()


        binding.bottomNavigation.setOnItemSelectedListener(){ item ->
            when(item.itemId) {
                R.id.item_home -> {
                    // Respond to navigation item 1 click
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, listFragment)
                    transaction.commit()
                    true
                }
                R.id.item_fav -> {
                    // Respond to navigation item 2 click
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, favoritesFragment)
                    transaction.commit()
                    true
                }
                else -> {
                    initlisteners()///prpgramasion sincrona
                    false

                }
            }
        }





      //  Ipfy.init(this) // this is a context of application
        //or you can also pass IpfyClass type to get either IPv4 address only or universal address IPv4/v6 as
       // Ipfy.init(this, IpfyClass.IPv4) //to get only IPv4 address
        //and
       // Ipfy.init(this,IpfyClass.UniversalIP) //to get Universal address in IPv4/v6

        //getIpAddres()
        //getGreeting()
        //showMessage()
        //intControl()


        checkDataBase()
        initRecycleview()

        val a=  JikanAnimeUserCase()

        getAllTopAnimes()





    }

    private fun getAllTopAnimes(){
        lifecycleScope.launch(Dispatchers.IO) {
            var x= JikanGetTopAnimesUserCase().getResponse()

            Log.d(Constants.TAG, x.pagination.toString())

            Log.d(Constants.TAG1,  x.data.get(1).images.jpg.image_url.toString())



        }
    }


    private fun intControl(){
        binding.bntAtras.setOnClickListener {
            val intent= Intent(this, LoginFActivity::class.java)
            startActivity(intent)
        }
    }


    private fun getGreeting(){
        binding.txtWelcome.text="Bienvenido "
    }


    /*
    private fun showMessage(){
       intent.extras.let {


           My_Applycation.
           getConnectionDB()!!.
           getUserDAO().
           getOneUser(1)    ///  <----------  CONSULTAR QUE HACE EXACTAMENTE ESTA PARTE

          val userId =  it?.getInt(Constants.USER_ID)  ///  <----------  CONSULTAR QUE HACE EXACTAMENTE ESTA PARTE

            if(userId != null){
                val user= LoginUserCase(My_Applycation.getConnectionDB()!!).getUserName(userId)

                binding.txtShowId.text="User: "+user.firstName.toString()+" "+user.lastName.toString()

            }else{
               Snackbar.make(binding.txtShowId,"Ocurrio un error",Snackbar.LENGTH_LONG).show()
            }


        }
    }

    */









    ///en las corruninas no importa  nadie espera a nadie, la corrunita padre se libro de sus hijo, no es como el la programasion clasica, se ejecutan todas a la vez




    private fun checkDataBase() {
        lifecycleScope.launch(Dispatchers.Main){  //hilo principal
            val usrs= withContext(Dispatchers.IO){ //hilo secundario
                LoginUserCase(My_Applycation.getConnectionDB()!!).getAllUsers()

            }
            Log.d(Constants.TAG, usrs.toString())
        }

        ///en las corruninas no importa  nadie espera a nadie, la corrunita padre se libro de sus hijo, no es como el la programasion clasica, se ejecutan todas a la vez

    }





    fun initlisteners(){
        //EN ALGUN MOMENTO VA MODIFICAR LA PANTALLA, CUANDO TERMINA LA EJECUION LO MODIFICA, EN ALMOMENTO LO VA A MODIFICAR, NO LO ESPERA EN SI

        //lascorrutinas tiene que estar dentro de main para que se muestren en pantralla

//para acceso a datos SIEMPRE CORRUTINAS
        //ambiente atado al ciclo de vida del activity, muere el activity muere el proceso
        //necesito de esta consas para lanzar corrutinas: Ambiente dipahcer  y launch
        lifecycleScope.launch(Dispatchers.Main) {


            val s1= async {
                val a= ""
            }

            val listC= listOf(s1)
            //awaitAll(listC)// sive para que no se ejecute la siguiente linea hasta que se terminen de ejecutar las que estan definidas en la lista



            val w = withContext(Dispatchers.IO){
                val listC= listOf(
                    async { getName() },
                    async { getName() },

                    )
            }





            val name= withContext(Dispatchers.IO){
                getName()
            }
            val w1= listC.awaitAll()
            binding.txtWelcome.text=name



                }

    }



        suspend fun getName():String{
            val a ="Henry"

            val b = a +"Coyago"

            return a//esto es lo que se va a devolver
        }













/*
    private fun getIpAddres(){
      /*  Ipfy.getInstance().getPublicIpObserver().observe(this, { ipData ->
            binding.txtIp.text="Su IP es: "+
                ipData.currentIpAddress // this is a value which is your current public IP address, null if no/lost internet connection

        })*/
    }


*/




    private fun initRecycleview(){
        lifecycleScope.launch(Dispatchers.Main) {
            val usrs= withContext(Dispatchers.IO){ getUserList()}
            val adapter: UsersAdapter= UsersAdapter(usrs)
            binding.rvUsers.adapter= adapter
            binding.rvUsers.layoutManager=
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.animationView.visibility= View.GONE
        }

    }


    suspend fun  getUserList():List<Users>{

        delay(7000)
    return LoginUserCase(My_Applycation.getConnectionDB()!!).getAllUsers()
    }



}