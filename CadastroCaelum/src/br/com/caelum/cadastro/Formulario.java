package br.com.caelum.cadastro;

import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Formulario extends Activity {
	
	private FormularioHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		Intent intent = getIntent();
		final Aluno alunoParaSerAlterado = (Aluno) intent.getSerializableExtra("alunoSelecionado");
		
		Toast.makeText(this, "Aluno: " + alunoParaSerAlterado, Toast.LENGTH_LONG).show();
		
		helper = new FormularioHelper(this);
		
		Button botao = (Button) findViewById(R.id.botao);
		
		if (alunoParaSerAlterado != null) {
			botao.setText("Alterar: ");
			helper.colocaAlunoNoFormulario(alunoParaSerAlterado);
		}
		
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Aluno aluno = helper.pegaAlunoDoFormulario();
				
				AlunoDAO dao = new AlunoDAO(Formulario.this);
				
				if (alunoParaSerAlterado == null) {
					dao.salva(aluno);
				} else {
					/*aluno.setId(alunoParaSerAlterado.getId());*/
					dao.altera(aluno);
				}
				
				dao.close();
				
				finish();
			}
		});
	}

}

