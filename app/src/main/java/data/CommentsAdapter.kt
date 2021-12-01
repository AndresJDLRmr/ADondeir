package data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.adondeirnuevoleon.Formulario
import com.example.adondeirnuevoleon.R

class CommentsAdapter(
    private val context: Context,
    private val dataset: ArrayList<Comments>
) : RecyclerView.Adapter<CommentsAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val commentAuthor: TextView = view.findViewById(R.id.autorComentario)
        val commentPlace: TextView = view.findViewById(R.id.lugarComentario)
        val commentContent: TextView = view.findViewById(R.id.comentario)
        val commentDate: TextView = view.findViewById(R.id.fechaComentario)
    }


    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_item, parent, false)

        return CommentsAdapter.ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.commentAuthor.text = item.postedBy.toString()
        holder.commentContent.text = item.comment.toString()
        holder.commentPlace.text = item.place.toString()
        holder.commentDate.text = item.date.toString()

    }

    private fun openFormularioOpinion() {
        val formularioIntent = Intent(this.context, Formulario::class.java)
        ContextCompat.startActivity(this.context, formularioIntent, null)
    }




    override fun getItemCount() = dataset.size
}

