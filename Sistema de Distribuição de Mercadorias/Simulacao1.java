
/**
 * Write a description of class Simulacao1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simulacao1
{
    public static void main(String[] args)
   {
        PacksDeBens pack1= new PacksDeBens("feijoes",5,001,10,10);
       PacksDeBens pack2= new PacksDeBens("batatas",5,002,10,10);
       PacksDeBens pack3= new PacksDeBens("bananas",5,003,5,5);
       
       //Estaçao 
       EstacoesAbastecedoras estacao1 =new EstacoesAbastecedoras(10,1,1,10);//10 contentores
       //localizada na posicao(1,1)
       
       //Loja localizada em p(-1,1)
       Lojas loja1= new Lojas(-1,1,"Jumbo", 10);
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
       camiao1.moverCamiao(-1,1);
       loja1.descarregarContentorDosCamioes( camiao1);
       //loja1.descarregarContentorDosCamioes(Camioes camiao)
       loja1.retirarPacksDosContentores(0);
       camiao1.carregarCamiao(contentor2);
       camiao1.moverCamiao(1,1);
       estacao1.carregarCamiao(1, camiao1);
    }
}
