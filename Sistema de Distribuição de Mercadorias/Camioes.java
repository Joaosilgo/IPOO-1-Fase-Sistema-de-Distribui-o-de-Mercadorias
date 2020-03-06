import java.util.*;

/**
 * 
 *The transport of the products is made by trucks which are characterized 
 *by an ID, a brand, a container,
 *a position and have information about the kilometers traveled, 
 *kilometers traveled after the last inspection, 
 *number of inspections and if the container is placed or not.

 * 
 * @author (João Gomes, Gonçalo Marques) 
 * @version (09-01-2017)
 */
public class Camioes
{

    private int idCamiao;
    private String designacao;
    private Contentor contentor;// espaco onde devia tar o contentor no cammiao
    private CoordenadasGeograficas posicao;//(longitude, latitude)
    private double quilometrosPercorridos;
    private double quilometrosPecorridosInspecao;
    private int numeroInspecoes;
    private boolean temContentor;

    /**
     * Contructor, which creates a new trucks with 0 kilometers traveled,
     * 0 kilometers after inspection,
     * 0 inspections made and whitout a container.
     */
    public Camioes( int idCamiao,  String designacao)
    {
        this.designacao=validarString( designacao);
        this.idCamiao=validarInteger(idCamiao);
        //contentor= new Contentor(idContentor);
        posicao= new CoordenadasGeograficas(0,0);
        quilometrosPercorridos=0;
        numeroInspecoes=0;
        quilometrosPecorridosInspecao=0;
        temContentor=false;
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

    private int validarInteger(int i)
    {
        if(i>=1)
        {
            return i;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Distância bidimensional
     * p=(px,py)  e q=(qx,qy)
     * sqr((px-qx)^2 + (py-qy)^2)
     * *Method to move the truck to a certain position using the Euclidean distance,
     * *it increase the kilometers traveled and the kilometers traveled after the inspection.
     *@param : longitude – longitude of the area where the truck will be placed
    Latitude – latitude od the area where the truck will be placed.
     */
    public void moverCamiao(double longitude, double latitude)
    {
        CoordenadasGeograficas p= new CoordenadasGeograficas(longitude,latitude);
        // desneçessario podia logo ter colocado a latitude e longitude na posicao
        double p1=posicao.getLongitude()-p.getLongitude();
        double p2=posicao.getLatitude()-p.getLatitude();
        double i=Math.sqrt(Math.pow(p1,2)+Math.pow(p2,2));
        double milhas = i * 60;
        double t = (milhas * 1.852);
        quilometrosPercorridos+=t;
        quilometrosPecorridosInspecao+=t;
        this.posicao=p;
    }
    // isPodeCarregar nao tem haver
    /**
     * 

    public void carregarCamiao(Contentor contentor)
    {
    if(contentor.isPodeCarregar()==true)
    {
    this.contentor=contentor;
    contentor.switchPodeCarregar();
    }
    else
    {
    System.out.println("Não Pode Carregar Contentor");
    }
    }
     */

    /**
     * Method to load the truck, 
     * to make this happen the container to receive can´t be null and 
     * the container cant be on the truck.
     *@param conteinerToReceive: container that will be placed on the truck.
     */
    public void carregarCamiao(Contentor contentorAreceber)
    {
        if(contentorAreceber!=null)
        {
            if(temContentor==false)
            {
                if(this.contentor==null)
                {
                    this.contentor=contentorAreceber;
                    temContentor=true;

                }

                else
                {
                    System.out.println("Camiao ja possui um contentor");
                }
            }
            else
            {
                System.out.println("cariavm ttem contentor a false");
            }
        }
        else
        {
            System.out.println("contentorAreceber não foi criado");
        }
    }
    //usa se em garagem
    // public void carregarCamiaoTroca(Contentor contentorAreceber)
    //  {
    //    if(contentorAreceber!=null)
    //  {
    //    
    //     

    //        this.contentor=contentorAreceber;
    //      temContentor=true;

    // }
    //else
    //{
    //  System.out.println("cariavm ttem contentor a false");
    //}
    //}
    /**
     * Method to unload the truck, it puts the container to 
     * receive = false and the container=null

     */
    public void descarregar()

    {
        temContentor=false;
        this.contentor=null;
    }

    //  public Contentor descarregarCamiao()
    //  {
    //   return this.contentor;

    //  }
    /**
     * 
     *Method to inspect the truck, 
     *it increases the number of inspections and the kilometers traveled 
     *after the inspection are turned to 0.
     */
    public void Inspecao()
    {
        numeroInspecoes++;
        quilometrosPecorridosInspecao=0;
    }

    public CoordenadasGeograficas getPosicao()
    {
        return posicao;
    }

    public double getQuilometrosPercorridos()
    {
        return quilometrosPercorridos;
    }

    public int getIdCamiao()
    {
        return idCamiao;
    }

    public String getDesignacao()
    {
        return designacao;
    }

    public Contentor getContentor()
    {
        Contentor c;
        c= contentor;

        return c;

    }
}

