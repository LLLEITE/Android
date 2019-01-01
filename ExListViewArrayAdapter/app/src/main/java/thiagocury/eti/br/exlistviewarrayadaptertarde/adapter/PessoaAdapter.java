package thiagocury.eti.br.exlistviewarrayadaptertarde.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import thiagocury.eti.br.exlistviewarrayadaptertarde.R;
import thiagocury.eti.br.exlistviewarrayadaptertarde.model.Pessoa;

public class PessoaAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Pessoa> pessoas;

    //2 - criar o atributo clickListener
    private static ClickListener clickListener;

    public PessoaAdapter(Context context, ArrayList<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.linha_pessoa,viewGroup,false);

        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ViewHolder h = (ViewHolder) viewHolder;

        Pessoa p = pessoas.get(i);

        h.tvNome.setText("Nome: "+p.getNome());
        h.tvIdade.setText("Idade: "+p.getIdade());
        h.tvIdadeMeses.setText("Meses: "+p.calcularIdadeMeses());

        Picasso.get()
                .load(p.verificarSexo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(h.ivSexo);
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }
                                                            //3 - implementar OnClickListener e OnLongClickListener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private final TextView tvNome;
        private final TextView tvIdade;
        private final TextView tvIdadeMeses;
        private final ImageView ivSexo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //4 - setar os listeners
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvNome = itemView.findViewById(R.id.lp_tv_nome);
            tvIdade= itemView.findViewById(R.id.lp_tv_idade);
            tvIdadeMeses = itemView.findViewById(R.id.lp_tv_idade_meses);
            ivSexo = itemView.findViewById(R.id.lp_iv_sexo);
        }

        @Override
        public void onClick(View v) {
            //5 - enviar parametros
            clickListener.onItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            //6 - enviar parametros
            clickListener.onItemLongClick(v, getAdapterPosition());
            return true;
        }
    }//fecha classe ViewHolder

    //7 - método para acessar externamente de MainActivity
    public void setOnItemClickListener(ClickListener clickListener){
        PessoaAdapter.clickListener = clickListener;
    }

    //1 - criar a interface
    public interface ClickListener{
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }
}//fecha classe