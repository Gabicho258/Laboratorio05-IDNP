package com.example.laboratorio05idnp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.laboratorio05idnp.R


class Actividad2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actividad2, container, false)
        val itemCatedral = view.findViewById<FrameLayout>(R.id.item_catedral)
        val itemClaustro = view.findViewById<FrameLayout>(R.id.item_claustro)

        itemCatedral.setOnClickListener {
            val nuevoFragment = PlaceFragment.newInstance(
                "Catedral de Arequipa",
                "Fue construida con ignimbrita (piedra de origen volcánico), y bóvedas de ladrillo; es el santuario principal de la ciudad ocupando todo el lado norte de la Plaza de Armas. Contruida totalmente en sillar, exhibe un estilo neorrenacentista con cierta influencia gótica. Su fachada está constituida por setenta columnas con capiteles corintios, tres portadas y dos grandes arcos laterales. Está rematada por dos altas torres renacentistas y estilizadas.",
                R.drawable.catedral
            )
            openFragment(nuevoFragment)
        }

        itemClaustro.setOnClickListener {
            val nuevoFragment = PlaceFragment.newInstance(
                "Claustro de la Compañía",
                "Este conjunto arquitectónico, construido enteramente de sillar (piedra blanca, volcánica, de Arequipa), es una pequeña joya para los ojos: en el centro de la patio, una fuente, rodeada de arcadas grabadas con motivos florales. Hoy en día, este patio es el hogar de tiendas de artesanía de alta gama. En el primer piso, un elegante bar que vale la pena desviarse.",
                R.drawable.claustro
            )
            openFragment(nuevoFragment)
        }
        return view

    }
    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}