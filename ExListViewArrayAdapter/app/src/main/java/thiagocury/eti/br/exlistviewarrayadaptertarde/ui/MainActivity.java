package thiagocury.eti.br.exlistviewarrayadaptertarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import thiagocury.eti.br.exlistviewarrayadaptertarde.R;
import thiagocury.eti.br.exlistviewarrayadaptertarde.adapter.PessoaAdapter;
import thiagocury.eti.br.exlistviewarrayadaptertarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private EditText etSexo;
    private Button btOK;
    private RecyclerView rvPessoas;
    private ArrayList<Pessoa> pessoas;
    private PessoaAdapter adapter; //ADAPTER PRÓPRIO.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pessoa p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                p.setSexo(etSexo.getText().toString());

                pessoas.add(p);
                adapter.notifyDataSetChanged();
                toast("Pessoa cadastrada com sucesso!");

            }
        });

        adapter.setOnItemClickListener(new PessoaAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                toast("clicou no recycler");
            }

            @Override
            public void onItemLongClick(View v, int position) {
                toast("clicou e segurou no recycler");
            }
        });

    }//fecha oncreate

    private void init(){
        etNome = findViewById(R.id.ma_et_nome);
        etIdade = findViewById(R.id.ma_et_idade);
        etSexo = findViewById(R.id.ma_et_sexo);
        btOK = findViewById(R.id.ma_bt_ok);
        rvPessoas = findViewById(R.id.ma_rv_pessoas);

        pessoas = new ArrayList<>();//vazio
        adapter = new PessoaAdapter(MainActivity.this, pessoas);
        rvPessoas.setAdapter(adapter);

        rvPessoas.setHasFixedSize(true);
        rvPessoas.setLayoutManager(new LinearLayoutManager(this));

    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}//fecha classe
