package nu.alexanderaspman.todoappproject

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.loggin_items.view.*


 class UserViewModal(
        private val users:MutableList<User>
    ): RecyclerView.Adapter<UserViewModal.UserViewHolder>(){
        class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.loggin_items,parent,false))
        }
        fun addInfo(user:User){
            users.add(user)
            notifyItemInserted(users.size-1)
        }


        private fun toggleStrikeThrough(tvEmail: TextView, tvPassword:TextView){

                tvEmail.paintFlags=  tvEmail.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        }


        override fun onBindViewHolder(   holder: UserViewHolder, position: Int) {
            val refTodo= users[position]
            holder.itemView.apply {tvEmail.text=refTodo.email
               tvPassword.text = refTodo.password.toString()

                toggleStrikeThrough(tvEmail, tvPassword)

            }
        }


        override fun getItemCount(): Int {
            return users.size

        }


}