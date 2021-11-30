import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.adondeirnuevoleon.ClimaActivity
import com.example.adondeirnuevoleon.R
import data.Places

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class PlacesAdapter(
    private val context: Context,
    private val dataset: List<Places>
) : RecyclerView.Adapter<PlacesAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeHour: TextView = view.findViewById(R.id.placeHours)
        val placeLocation: TextView = view.findViewById(R.id.placeLocation)
        val placeImage: ImageView = view.findViewById(R.id.placeImage)
        val placeButton: Button = view.findViewById(R.id.placeInfoBtn)
        
    }


    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.places_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.placeName.text = context.resources.getString(item.placeName)
        holder.placeHour.text = context.resources.getString(item.placeHour)
        holder.placeLocation.text = context.resources.getString(item.placeLocation)
        holder.placeImage.setImageResource(item.placeImage)
    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
