 import java.util.*;
/**
 * Write a description of class Garagens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garagens
{

    private String nome;
    private CoordenadasGeograficas posicao;//(longitude, latitude)
    private int numeroLugar;
    //private  int index = numeroLugar -1;
    private int maximoLugares;
    private Camioes[] estacionamento;
    private boolean [] estacionamentoBolean;
    private Contentor[] c;
  //  private boolean []temContentor;
    private ArrayList<Camioes> estacionamentoForaDaGaragem;
    //private Camioes camiao;

    // private ArrayList<Camioes,Contentor> lugares;
    //private Camiao camiao;

    /**
     * Constructor for objects of class Garagens
     * @argum: nome -hjhjghjgh
     *               longitude -
     */
    public Garagens(  String nome,double longitude, double latitude,int maximoLugares )
    {
        this.maximoLugares=maximoLugares;
        this.nome=nome;
        this.posicao= new CoordenadasGeograficas(longitude,latitude);
        estacionamento= new Camioes[maximoLugares];
        estacionamentoBolean= new boolean[maximoLugares];
        c= new Contentor[maximoLugares];
        //temContentor = new boolean[maximoLugares];
        for(int i=0 ; i<estacionamentoBolean.length ;i++)
        {
            estacionamentoBolean[i]=true;
        }
        estacionamentoForaDaGaragem = new ArrayList<>();

    }

    public void estacionarCamiao(Camioes camiao, int lugar)
    {
        // numeroLugar=lugar;
        if(camiao.getPosicao().getLongitude()==posicao.getLongitude() && camiao.getPosicao().getLatitude()==posicao.getLatitude() )
        {
            if(lugar-1<=estacionamento.length && lugar>=1)
            {
                if(estacionamento[lugar-1]==null)
                {
                    if(camiao!=null)
                    {
                        estacionamento[lugar-1]=camiao;
                        estacionamentoBolean[lugar-1]=false;
                    }
                    else
                    {
                        System.out.println("Camiao a null");
                    }
                }
                else
                {
                    System.out.println("Estacionamento ja esta ocupado");
                }
            }
            else
            {
                System.out.println(" lugar de Estacionamento inadvertido ");
            }
        }
        else
        {
            System.out.println("Camiao não esta em posicao");
        }
    }

    public void inspecionarCamiaoLugar(int lugar)
    {
        numeroLugar=lugar;
        if(estacionamento.length>=lugar-1 && lugar>=1)
        {
            if(estacionamento[lugar-1]!=null)
            {
                estacionamento[lugar-1].Inspecao();
                System.out.println("check");
            }
            else
            {
                System.out.println("Estacionamento nao tem camiao");
            }
        }
        else
        {
            System.out.println("Estacionamento inadvertido");
        }
    }

    public void inspecionarCamiaoId(int idcamiao)
    {
        if(idcamiao>=0){
            for(int i=0 ; i<estacionamento.length; i++)
            {
                if(estacionamento[i]!=null)
                {
                    if(estacionamento[i].getIdCamiao()==idcamiao)
                    {
                        estacionamento[i].Inspecao();
                        System.out.println("check");
                    }
                    else
                    {
                        System.out.println("Camiao Nao se encontra dentro do estacionamento da garagem");
                    }
                }

            }
        }
        else
        {
            System.out.println("Id de camiao inadvertifo");
        }
    }
    //Conferir estacionamentos, percorrendo a lista de camiões estacionados
    //a verificar se estes se encontram mesmo na garagem (posição igual à da garagem).
    public void conferirEstacionamento()
    {
        String inf=toString();
        for(Camioes item :estacionamento )
        {
            inf+=item.getDesignacao()+" iD:"+item.getIdCamiao();
        }
        System.out.println(inf);
    }

    public void conferirEstacionamentoGaragem()
    {
        String inf=toString();
        for(Camioes item :estacionamento )
        {
            if(item==null)
            {
                inf+="Vazio\n";
            }
            else
            {
                if(item.getPosicao().getLongitude()==posicao.getLongitude() && item.getPosicao().getLatitude()==posicao.getLatitude())
                {
                    inf+=item.getDesignacao()+" iD:"+item.getIdCamiao() + "  Esta na Garagem\n";
                }
                else
                {
                    inf+=item.getDesignacao()+" iD:"+item.getIdCamiao()+"  Não está na garagem \n";
                }
            }
        }
        System.out.println(inf);
    }

    @Override 
    public String toString()
    {
        String inf="\n  Garagem  ";
        inf+=nome + "\n "+
        "Localizado "+posicao.toString()+"\n"+
        "Com :"+ getMaximoLugares() + "Lugares"+"\n"+
        "Lugares Usados:"+ lugaresOcupados()+"\n"+
        "Restantes: "+ restantes()+"\n"+
        "Camioes:\n";

        return inf;
    }

    private int restantes()
    {
        int i=0;
        i+=getMaximoLugares() - lugaresOcupados();
        return i;
    }

    public int getMaximoLugares()
    {
        return maximoLugares;
    }

    public int lugaresOcupados()
    {
        int i=0;
        for(Camioes item :estacionamento )
        {
            if(item!=null)
            {
                i++;   
            }

        }
        return i;
    }

    public CoordenadasGeograficas getPosicao()
    {
        return posicao;
    }

    public void DescarregarContentorCamiao( int lugar)
    {
        if(lugar-1<=estacionamento.length && lugar>=1)
        {
            if(estacionamento[lugar-1]!=null)
            {
                if(estacionamentoBolean[lugar-1]==false)
                {
                    if(c[lugar-1]==null)
                    {
                            estacionamento[lugar-1].descarregar();
                            System.out.println("Contentor decarregado no lugar "+ lugar);

                     }

                    else
                    {
                        System.out.println("lugar ja possui um contentor");
                    }
                }
                else
                {
                    System.out.println("estacionamento vazio");
                }
            }
            else
            {
                System.out.println("estacionamento ocupado por " +estacionamento[lugar-1].getDesignacao());
            }
        }
        else
        {
            System.out.println("numero de lugar invalido");
        }
    }
public void TrocarContentorCamiao(Contentor cont, int lugar)
    {
        if(lugar-1<=estacionamento.length && lugar>=1)
        {
            if(estacionamento[lugar-1]!=null)
            {
                if(estacionamentoBolean[lugar-1]==false)
                {
                    if(c[lugar-1]==null)
                    {
                        if(cont!=null)
                        {
                            estacionamento[lugar-1].descarregar();
                            estacionamento[lugar-1].carregarCamiao(cont);
                            System.out.println("Contentor descarregado e careegado com contentor id: "+ cont.getIdContentor() );
                        }
                        else
                        {
                            estacionamento[lugar-1].descarregar();
                            System.out.println("Contentor decarregado no lugar "+ lugar);

                        }
                    }
                    else
                    {
                        System.out.println("lugar ja possui um contentor");
                    }
                }
                else
                {
                    System.out.println("estacionamento vazio");
                }
            }
            else
            {
                System.out.println("estacionamento ocupado por " +estacionamento[lugar-1].getDesignacao());
            }
        }
        else
        {
            System.out.println("numero de lugar invalido");
        }
    }

}
