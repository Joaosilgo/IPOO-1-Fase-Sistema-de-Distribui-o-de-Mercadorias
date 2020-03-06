import java.util.*;
/**
 * Write a description of class EstacoesAbastecedoras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstacoesAbastecedoras
{
    // instance variables - replace the example below with your own
    private String nome;
    private CoordenadasGeograficas posicao;//(longitude, latitude)
    //private ArrayList<PacksDeBens> armazem; VISTO QUE NAO PODE HAVER ARRAYlIST
    //private PacksDeBens[] armazem;
    private Armazem armazem;
    private Contentor[] contentores;
    private Camioes camiao;
private int contador;
    //private int quantidadeContentores;

    /**
     * Constructor for objects of class EstacoesAbastecedoras
     */
    public EstacoesAbastecedoras(int quantidadeContentores, double longitude, double latitude, int dimensao)
    {
        posicao= new CoordenadasGeograficas(longitude,latitude);
        contentores= new Contentor[quantidadeContentores];
        //armazem= new ArrayList<>();
        //armazem = new PacksDeBens[dimensao];
         armazem= new Armazem(dimensao);
    }
    // perguntar ao prof se quer boolean ou msg de erro
    public void carregarCamiao(int numeroContentor, Camioes camiao)
    {
       if(camiao.getPosicao().getLongitude()==posicao.getLongitude() && camiao.getPosicao().getLatitude()==posicao.getLatitude() )// isto ta mal
        {
            //  if(contentores[numeroContentor].isEmpty()== true)

            //if(contentores[numeroContentor].isPodeCarregar()==true)//validaçao ja feita em contentores
            // {
            camiao.carregarCamiao(contentores[numeroContentor]);
            System.out.println("check");
            
            //else
            // {
            // System.out.println("erro Variavel podeCarregar esta a false");
            //}
        }
        else
        {
            System.out.println("erro camiao nao esta na posiçao da estaçao");
        }
    }
    public void receberContentor(int indice, Contentor contentor)
    {
        contentores[indice]=contentor;
    }

    private int indexAdust(int i)
    {
        return i-1;
    }
    // falta o argumento quantidade
    public void carregarContentores(int numeroArmazem, int contentorNumero)
    {
        //contentorNumero=indexAdust(contentorNumero);
        int indexAdustContentor=contentorNumero-1;
        int indexAdustArmazem=numeroArmazem-1;
        if(armazem.getArmazem()[indexAdustArmazem]!=null)
        {
            if(indexAdustContentor<=contentores.length)
            {
                contentores[indexAdustContentor].receberBem(armazem.getArmazem()[indexAdustArmazem]);

            }
            else
            {
                System.out.println("indice superior ao numero de contentores");   
            }
        }
        else
        {
            System.out.println("indice do armazem invalido ou estante vazia");
        }
    }

    public void carregarCamiaoComContentoresNomeProduto(String nome,int contentorNumero, int quantidade )
    {
        int indexAdustContentor=contentorNumero-1;
        nome=validarString(nome);
        for(PacksDeBens item : armazem.getArmazem())
        {
            if(nome.equalsIgnoreCase(item.getName()))
            {
                if(item.getQuantity()>= quantidade)
                {
                    contentores[indexAdustContentor].receberBem(item);

                    item.removeQuantity( quantidade);
                }
                else
                {
                    System.out.println("Quantidade Insuficiente");
                }
            }
            else
            {
                System.out.println("Nome não encontrado");
            }
        }
    }

    private String validarString( String s)
    {
        if(s!= null)
        {
            return s;
        }
        else
        {
            throw new IllegalArgumentException("String invalido ");
        }
    }

    private int validarIndice(int i)
    {
        if(i!=-1)
        {
            return i;
        }
        else
        {
            throw new IllegalArgumentException("indice invalido ");
        }
    }

    // e quando nao exister o produto com esse id criamos um novo e juntamos : e os outos atributos da class
    public void AbstecerArmazemComProduto(int idProduto,int quantidade)
    {
        for(PacksDeBens item : armazem.getArmazem())
        {
            if(item.getCodigoDoProduto()==idProduto)
            {
                item.addQuantity( quantidade);// metodo nao deve funcionar porque tinhamos usado antes Array List
            }
            else
            {
                System.out.println("Não Existe esse produto no inventario");
            }
        }

    }
  
    public void adicionarBensAoArmazem(PacksDeBens bens)
    {
        if(bens!=null)
        {
            armazem.getArmazem()[contador]=bens;
        }

    }
}
