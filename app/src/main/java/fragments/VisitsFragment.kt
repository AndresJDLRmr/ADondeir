package fragments

import PlacesAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adondeirnuevoleon.R
import com.google.firebase.firestore.*
import data.Comments
import data.CommentsAdapter
import data.Datasource

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VisitsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VisitsFragment : Fragment() {
    private val db = FirebaseFirestore.getInstance()
    private var dataset = arrayListOf<Comments>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(com.example.adondeirnuevoleon.R.layout.fragment_visits, container, false)
        val recyclerView: RecyclerView =rootView.findViewById<RecyclerView>(com.example.adondeirnuevoleon.R.id.commentsRecyclerView)
        recyclerView.adapter = CommentsAdapter(recyclerView.context, dataset)
        recyclerView.setHasFixedSize(true)
        dataset = arrayListOf()

        eventChangeListener()
        return rootView


        //return inflater.inflate(com.example.adondeirnuevoleon.R.layout.fragment_home, container, false)
    }

    private fun eventChangeListener() {
        db.collection("comments").
                addSnapshotListener(object : EventListener<QuerySnapshot> {
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error != null) {
                            Log.e("Firestore Error", error.message.toString())
                            return
                        }
                        else {
                            for (dc: DocumentChange in value?.documentChanges!!) {
                                if (dc.type == DocumentChange.Type.ADDED){
                                    dataset.add(dc.document.toObject(Comments::class.java))
                                }

                            }
                        }

                    }


                })
    }


}