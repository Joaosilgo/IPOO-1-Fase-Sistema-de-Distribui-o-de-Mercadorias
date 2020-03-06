import java.util.*;

public class Lojas
{
    // instance variables - replace the example below with your own
    //private ArrayList<PacksDeBens> armazemLoja;
    private String nomeLoja;
    private CoordenadasGeograficas posicao;
    private final int maximoContentoresEmLoja=2;
    private Camioes camiao;
    private Armazem armazem;
    private Contentor[] contentoresEmLoja;

    public Lojas(double longitude, double latitude, String nomeLoja, int dimensao)
    {
        posicao= new CoordenadasGeograficas(longitude,latitude);
        this.nomeLoja=validarString( nomeLoja);
        //armazemLoja= new ArrayList<>();
        armazem= new Armazem(dimensao);
        contentoresEmLoja= new Contentor[maximoContentoresEmLoja];

    }

    private boolean estaPreenchido()
    {
        boolean t =true;
        for (int i = 0 ;   i< contentoresEmLoja.length ; i++)
        {
            if(contentoresEmLoja[i]==null)
            {
                t= false;

            }

        }
        return t;
    }

    private boolean checkStateContentor()
    {
        if(contentoresEmLoja[0]!=null && contentoresEmLoja[1]!=null)
        {
            return true;
        }
        else
        {
            return false;
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
            return "";
        }
    }
    // esto tira todos os produtos falta com a quantidade
    /**
     * 

    public void venderItemFullStock(int codigoBem)
    {
    for(PacksDeBens item : armazem.getArmazem())
    {
    if(item.getCodigoDoProduto()==codigoBem)
    {
    armazem.get(item);
    }
    else
    {
    System.out.println("Codigo incorreto ou sem ligaçao");
    }
    }
    }
     */
    // duvida o objecto packdebens nunca ira ser igual pois a quantidae é um dos argumentos do contrutor
    // por isso incrementar quantidade é estupido

    public void venderItemFullStock(int codigoBem)
    {
        for (int i = 0 ;   i< armazem.getArmazem().length ; i++)
        {
            if(armazem.getArmazem()[i].getCodigoDoProduto()==codigoBem)
            {
                armazem.getArmazem()[i]=null;
            }
            else
            {
                System.out.println("Codigo incorreto ou sem ligaçao");
            }
        }
    }

    public void receberCamiao(Camioes camiao)
    {
        if(camiao.getPosicao().getLongitude()==posicao.getLongitude() && camiao.getPosicao().getLatitude()==posicao.getLatitude())//isto ta mal
        {
            for(PacksDeBens t : camiao.getContentor().getPacks())
            {
                for (int i = 0 ;   i< armazem.getArmazem().length ; i++)
                {
                    if(armazem.getArmazem()[i].equals(t))
                    {
                        armazem.getArmazem()[i].incrementQuantity();// falta saber quantidade peso espacp
                    }
                    else
                    {
                        armazem.getArmazem()[i]=t;
                    }
                }
            }
        }
        else
        {
            System.out.println("Camiao não esta na posicao");
        }
    }

    public void venderItemFullStock(int codigoBem,int quantidade)
    {
        for(PacksDeBens item : armazem.getArmazem())
        {
            if(item.getCodigoDoProduto()==codigoBem)
            {
                if(item.getQuantity()>=quantidade)// ou posso deixar sempre um de stock
                {
                    item.removeQuantity( quantidade);// problema resolvido
                }
                else
                {
                    System.out.println("quantidade Insuficiente");
                }
            }
            else
            {
                System.out.println("Codigo incorreto sem ligaçao");
            }
        }
    }

    public void adicionarBensAoArmazem(PacksDeBens bens)
    {

        if(bens!=null)
        {

            for(int i=0 ;  i< armazem.getArmazem().length ; i++)
            {
                if(armazem.getArmazem()[i]!=bens)
                {
                    armazem.getArmazem()[i]=bens;
                }

            }
        }
    }

    public boolean descarregarContentorDosCamioes(Camioes camiao)
    {
        if(camiao.getPosicao().getLongitude()==posicao.getLongitude() && camiao.getPosicao().getLatitude()==posicao.getLatitude() )
        {
            if(camiao!=null)
            {
                if(camiao.getContentor()!= null)
                {
                    if(checkStateContentor()==false)
                    {
                        for(int i=0 ; i<contentoresEmLoja.length; i++)
                        {
                            if(contentoresEmLoja[i]==null)
                            {
                                contentoresEmLoja[i]=camiao.getContentor(); 
                                camiao.descarregar();
                                System.out.println("check");
                                return true;
                            }
                        }
                    }
                    else
                    {

                        System.out.println("Contentores em loja atingiram valor maximo");
                        return false;
                    }
                }
                else
                {
                    System.out.println("camiao esta sem contentor");
                    return false;
                }
            }
            else
            {
                System.out.println("Nao esxite camiao para descarregar contentor");
                return false;
            }
        }
        else
        {
            System.out.println("Camiao ñao esta em posicao");
            return false;
        }
        return false;
    }

    public void retirarPacksDosContentores(int espacoContentor)
    {
        // for (int i = 0 ;   i< contentoresEmLoja.length ; i++)
        // {
        // if(contentoresEmLoja[i].getIdContentor()==idContentor && contentoresEmLoja[i]!=null )
        // {
        if(espacoContentor==0 || espacoContentor==1)
        {
            if(contentoresEmLoja[espacoContentor]!=null)
            {

               // if(armazem.isFull()==false)
               // {
                    if(contentoresEmLoja[espacoContentor].countProducts()<=armazem.getArmazem().length)
                    {

                        for(PacksDeBens item : contentoresEmLoja[espacoContentor].getPacks())
                        {
                            if(item!=null)
                            {
                            armazem.receiveProducts(item );
                            System.out.println("check :"+ item.getName());
                        }
                        }
                  //  }
               // }
               // else
               // {
               //     System.out.println("Armazem ta cheio");
               // }
            }
            else
            {
                System.out.println("Espaço vazio");
            }
        }
            else
            {
                 System.out.println("Espaço tem de ser 0 ou 1");
            }
            // else
            //  {
            //     System.out.println("O id nao é correspondido");
            // }
            //}

        //}
    }
}
        public String toString()
        {
            String inf="";
            inf+="\n Loja : "+nomeLoja+"\n"+
            "Posicão : "+posicao.toString()+"\n"+
            "Contentores na Loja:";
            return inf;
        }
        /**
         * 
        public void receberBens(int idProduto,int quantidade)
        {
        for(PacksDeBens item : armazemLoja)
        {
        if(item.getCodigoDoProduto()==idProduto)
        {
        item.acrescentarQuantidade( quantidade);
        }
        else
        {
        System.out.println("Não Existe esse produto no inventario");
        }
        }

        }
         */
    }
