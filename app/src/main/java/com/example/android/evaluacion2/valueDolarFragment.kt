package com.example.android.evaluacion2


import android.content.Context
import android.os.Bundle

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class valueDolarFragment : Fragment() {
    var miContexto: Context? = null

  /*  override fun OnTaskCompleted(response: String) {
        if (!response.equals("error")) {
            try {

                var json = JSONObject(response)
                var jsonDataUSD = json.getJSONObject("dolar").getString("valor").toInt()

            } catch (e:Exception) {
                Log.e("JSon Error", "${e.message},,${e.cause}")

            }
        } else {
            var alerta = AlertDialog.Builder(miContexto?)
            alerta.setTitle("Error fatal")
            alerta.setMessage("ha ocurrido un error")
            alerta.setNegativeButton("ok", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            alerta.show()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            // Inflate the layout for this fragment
            var view = inflater.inflate(R.layout.fragment_value_dolar, container, false)

        var json = JSONObject()
        var jsonDataUSD = json.getJSONObject("dolar").getString("valor").toInt()


        Toast.makeText(miContexto, "valueDolarFragment", Toast.LENGTH_SHORT).show()

        return view
    }
*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_value_dolar,container, false)
        return view

        // Inflate the layout for this fragment
        //     return inflater.inflate(R.layout.fragment_content, container, false)
    }

}
