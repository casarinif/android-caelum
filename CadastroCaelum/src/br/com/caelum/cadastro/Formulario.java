package br.com.caelum.cadastro;

import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Formulario extends Activity {
	
	private FormularioHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		helper = new FormularioHelper(this);
		
		Button botao = (Button) findViewById(R.id.botao);
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Aluno aluno = helper.pegaAlunoDoFormulario();
				
				AlunoDAO dao = new AlunoDAO(Formulario.this);
				dao.salva(aluno);
				dao.close();
				
				finish();
			}
		});
	}

}

