package fragments

import PlacesAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adondeirnuevoleon.R
import com.google.firebase.firestore.*
import data.Places
import android.widget.ImageView
import data.Datasource


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private val db = FirebaseFirestore.getInstance()
    private val dataset = Datasource().loadPlaces()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(com.example.adondeirnuevoleon.R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = rootView.findViewById<RecyclerView>(com.example.adondeirnuevoleon.R.id.placesRecyclerView)
        recyclerView.adapter = PlacesAdapter(recyclerView.context, dataset)
        recyclerView.setHasFixedSize(true)
        return rootView


        //return inflater.inflate(com.example.adondeirnuevoleon.R.layout.fragment_home, container, false)
    }


}