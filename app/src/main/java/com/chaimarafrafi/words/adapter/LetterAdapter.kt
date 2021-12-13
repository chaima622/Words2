package com.chaimarafrafi.words.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chaimarafrafi.words.LetterListFragmentDirections
import com.chaimarafrafi.words.MainActivity
import com.chaimarafrafi.words.R

/**
 * Adapter for the [RecyclerView] in [MainActivity].
 */
class LetterAdapter :
    RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
    private val list = ('A').rangeTo('Z').toList()

    /**
     * Provides a reference for the views needed to display items in your list.
     */
    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = WordAdapter
        return LetterViewHolder(layout)
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()
        /*holder.button.setOnClickListener {
            val context = holder.view.context
            // Create an intent with a destination of DetailActivity
            val intent = Intent(context, DetailActivity::class.java)
            // Add the selected letter to the intent as extra data
            // The text of Buttons are [CharSequence], a list of characters,
            // so it must be explicitly converted into a [String].
            intent.putExtra(WordListFragment.LETTER, holder.button.text.toString())
            // Start an activity using the data and destination from the Intent.
            context.startActivity(intent)*/

        val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
        holder.view.findNavController().navigate(action)
        }

    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service



