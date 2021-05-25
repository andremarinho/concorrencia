package concorrencia;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExemplo {

	private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);
	
	
}


class Casa{
	private List<Comodo> comodos;
	
	Casa(Comodo... comodos ){this.comodos = Arrays.asList(comodos);}
	
	List<Atividade> obterFazerDaCasa(){
		return this.comodos.stream().map(Comodo::obterAtividadesDoComodo)
				.reduce(new ArrayList(), (pivo, atividades) -> {
					pivo.addAll(atividades);
					return pivo;
				});
	}
}

interface Atividade{
	void realizar();
}

abstract class Comodo{
	abstract List<Atividade> obterAtividadesDoComodo();
}

class Quarto extends Comodo{

	@Override
	List<Atividade> obterAtividadesDoComodo() {
		
		return Arrays.asList(
				this::arrumarCama,
				this::varreQuarto,
				this::arrumarGuardaRoupa);
		}
	
	
	public void arrumarCama(){ System.out.println("Arrumando cama.");}
	public void varreQuarto(){System.out.println("Varrendo quarto.");}
	public void arrumarGuardaRoupa(){System.out.println("Arrumando o guarda roupas");}
		
	
}


