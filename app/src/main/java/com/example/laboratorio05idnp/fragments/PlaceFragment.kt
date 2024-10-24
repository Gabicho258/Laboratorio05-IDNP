package com.example.laboratorio05idnp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.laboratorio05idnp.R

private const val ARG_TITLE = "title"
private const val ARG_DESCRIPCION = "descripcion"
private const val ARG_IMAGEN = "imagen"

class PlaceFragment : Fragment() {

    private var title: String? = null
    private var descripcion: String? = null
    private var imagen: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            descripcion = it.getString(ARG_DESCRIPCION)
            imagen = it.getInt(ARG_IMAGEN)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_place, container, false)

        val textNombre = view.findViewById<TextView>(R.id.place_title)
        val textDescripcion = view.findViewById<TextView>(R.id.place_description)
        val imageView = view.findViewById<ImageView>(R.id.place_fragment_image)

        textNombre.text = title
        textDescripcion.text = descripcion
        imagen?.let { imageView.setImageResource(it) }

        val buttonBack = view.findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, descripcion: String, imagen: Int) =
            PlaceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESCRIPCION, descripcion)
                    putInt(ARG_IMAGEN, imagen)
                }
            }
    }
}
