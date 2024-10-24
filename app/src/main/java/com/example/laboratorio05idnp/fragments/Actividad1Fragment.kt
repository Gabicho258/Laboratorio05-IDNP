package com.example.laboratorio05idnp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.laboratorio05idnp.R


class Actividad1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actividad1, container, false)
        val myItem = view.findViewById<ConstraintLayout>(R.id.elementActivity1)
        myItem.setOnClickListener {
            val nuevoFragment = PlaceFragment.newInstance(
                "Catedral de Arequipa",
                "Fue construida con ignimbrita (piedra de origen volcánico), y bóvedas de ladrillo; es el santuario principal de la ciudad ocupando todo el lado norte de la Plaza de Armas. Contruida totalmente en sillar, exhibe un estilo neorrenacentista con cierta influencia gótica. Su fachada está constituida por setenta columnas con capiteles corintios, tres portadas y dos grandes arcos laterales. Está rematada por dos altas torres renacentistas y estilizadas.",
                R.drawable.catedral
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