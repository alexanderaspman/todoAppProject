package nu.alexanderaspman.todoappproject

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_items.view.*

class TodoAdapter(
     private val todos:MutableList<Todo>
 ):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
     class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_items,parent,false))
    }
    fun addTodo(todo:Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }
    fun deleteTodos(){
        todos.removeAll { todo -> todo.isChecked }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tVTitle: TextView,isChecked:Boolean){
        if (isChecked){
            tVTitle.paintFlags=  tVTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tVTitle.paintFlags=tVTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val refTodo= todos[position]
       holder.itemView.apply {tVTitle.text=refTodo.title
           cBDone.isChecked = refTodo.isChecked
        toggleStrikeThrough(tVTitle, refTodo.isChecked)
        cBDone.setOnCheckedChangeListener { _, isChecked ->  toggleStrikeThrough(tVTitle,isChecked)
        refTodo.isChecked=!refTodo.isChecked}
       }
    }


    override fun getItemCount(): Int {
        return todos.size

    }
}
