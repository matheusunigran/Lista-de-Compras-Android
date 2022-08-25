package br.unigran.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText marca;
    EditText qtd;
    ListView listagem;
    List<Produto> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nomeId);
        marca = findViewById(R.id.marcaId);
        qtd = findViewById(R.id.quantidadeID);
        listagem = findViewById(R.id.listaId);
        dados = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);

        listagem.setAdapter(adapter);
    }

    //verifica se o usuário colocou um item com as informações corretas
    public boolean verificar(){
        String nomeProduto = nome.getText().toString();
        String marcaProduto = marca.getText().toString();
        String qtdProduto = qtd.getText().toString();
        if ((nomeProduto.equals(null) || marcaProduto.equals(null) || qtdProduto.equals(null))
                || (nomeProduto.equals("") || marcaProduto.equals("") || (qtdProduto.equals("")))) {
            Toast.makeText(this, "Adicione um item", Toast.LENGTH_SHORT).show();
            return false;
        } else{
            return true;
        }
    }

    public void salvar(View view){
        if(verificar()){
            Produto produto =new Produto();
            produto.setNome(nome.getText().toString());
            produto.setMarca(marca.getText().toString());
            produto.setQuantidade(qtd.getText().toString());
            dados.add(produto);
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }

    }

}