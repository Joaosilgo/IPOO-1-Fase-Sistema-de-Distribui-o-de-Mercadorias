

public class Main{
    // instance variables - replace the example below with your own
   public static void main(String[] args) {    //packs
  
       
       PacksDeBens pack1= new PacksDeBens("feijoes",5,001,10,10);
       PacksDeBens pack2= new PacksDeBens("batatas",5,002,10,10);
       PacksDeBens pack3= new PacksDeBens("bananas",5,003,5,5);
       
       //Estaçao 
       EstacoesAbastecedoras estacao1 =new EstacoesAbastecedoras(10,1,1,10);//10 contentores
       //localizada na posicao(1,1)
       
       //Loja localizada em p(-1,1)
       Lojas loja1= new Lojas(-1,1,"Jumbo",10);
       loja1.adicionarBensAoArmazem(pack1);
       
       
       
       
       //Contentor
       //capacidade para 10 packs
       Contentor contentor1= new Contentor(1);
       Contentor contentor2= new Contentor(2);
       
       
       //Camiao
       //inicia-se sem contentor
       //p(0,0)
       Camioes camiao1 = new Camioes(1,"IVECO");
        
       
       
       
       camiao1.carregarCamiao(contentor1);
       contentor1.receberBem(pack1);  
       camiao1.moverCamiao(1, 1);
       
       System.out.println(camiao1.getQuilometrosPercorridos());
       //Class c = camiao1.getClass();
       //System.out.println("Looks like you have a "+c.getCanonicalName());
       
       Garagens garagem1 = new Garagens("Filhos & Filhos",1,-1,9 );
       
       camiao1.moverCamiao(1,-1);
       garagem1.estacionarCamiao(camiao1, 2);
       
       
       garagem1.conferirEstacionamentoGaragem();
       //garagem1.inspecionarCamiaoId( 2);
       garagem1.inspecionarCamiaoId( 1);
       
       //garagem1.inspecionarCamiaoLugar(3);
        garagem1.inspecionarCamiaoLugar(2);

  Contentor cont = new Contentor(5);
     garagem1.TrocarContentorCamiao( cont ,2);
       
       
       
       
    }
}
