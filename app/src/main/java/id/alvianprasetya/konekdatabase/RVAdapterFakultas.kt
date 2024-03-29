package id.alvianprasetya.konekdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fakultas_list.view.*

class RVAdapterFakultas(private val context: Context, private val arrayList: ArrayList<Fakultas>):RecyclerView.Adapter<RVAdapterFakultas.Holder>() {
    override fun onBindViewHolder(holder: Holder, position: Int) {
     holder.view.label_kodefakultas.text = arrayList?.get(position)?.kode_fakultas
     holder.view.label_namafakultas.text = "Nama Fakultas: "+arrayList?.get(position)?.nama_fakultas
    }

    override fun getItemCount(): Int = arrayList!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.fakultas_list,parent,false))
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)
}