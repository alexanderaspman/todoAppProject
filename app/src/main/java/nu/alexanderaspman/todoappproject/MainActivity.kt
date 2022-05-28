package nu.alexanderaspman.todoappproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_items.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       todoAdapter=   TodoAdapter(mutableListOf())

        rVTodos.adapter =  todoAdapter
        rVTodos.layoutManager=LinearLayoutManager(this)
        bAdd.setOnClickListener {
            if (title.isNotEmpty()) {
                val todoTitle = eTTitel.text.toString()
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                eTTitel.text.clear()
            }
        }
            bDelet.setOnClickListener { todoAdapter.deleteTodos() }
    }
}