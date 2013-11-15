package br.com.caelum.cadastro;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_alunos);
		
		String[] nomes = {"Rodrigo", "Alberto", "Maria", "Ana"};
		int layout = android.R.layout.simple_list_item_1;
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, nomes);
		
		ListView lista = (ListView) findViewById(R.id.lista);
		lista.setAdapter(adapter);
		
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {

				Toast.makeText(ListaAlunos.this, "Clique na posição "
						+ posicao, Toast.LENGTH_SHORT).show();
			}
			
		});
		
		lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {

				Toast.makeText(ListaAlunos.this, "Clique longo em " 
						+ adapter.getItemAtPosition(posicao), Toast.LENGTH_LONG).show();
				return true;
			}
			
		});
	}

}
