package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repoItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nome.text = repositories[position].name;
        holder.item.setOnClickListener{
            repoItemLister(repositories[position])
        }
        holder.share.setOnClickListener {
            btnShareLister(repositories[position]);
        }

    }

    // Pega a quantidade de repositorios da lista
    override fun getItemCount(): Int = repositories.size;

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nome: TextView;
        val share: ImageView;
        val item: ConstraintLayout;
        init {
            view.apply {
                nome = findViewById(R.id.tv_preco);
                share = findViewById(R.id.iv_favorite);
                item = findViewById(R.id.cl_card_content);
            }
        }

    }
}


