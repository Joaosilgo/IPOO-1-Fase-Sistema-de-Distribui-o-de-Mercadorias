
/**
 * Uma posição, representada através de coordenadas geográficas. 
 *  latitude no intervalo de [-90.0, 90.0] graus (>0 é norte, <0 é sul) 
 * longitude de [-180.0, 180.0] graus (>0 é este, <0 é oeste).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoordenadasGeograficas
{

    private double latitude;
    private double longitude;

    /**
     * 
     * ficas
     */
    public CoordenadasGeograficas(double longitude,double latitude)
    {
        this.latitude=validarLatitude( latitude);
        this.longitude=validarLongitude( longitude);

    }

    private double validarLatitude(double latitude)
    {
        if(latitude<-90.0  ||  latitude>90.0)
        {
            return 0;
        }
        else
        {
            return latitude;
        }
    }

    private double validarLongitude(double longitude)
    {
        if(latitude<-180.0  ||  latitude>180.0)
        {
            return 0;
        }
        else
        {
            return longitude;
        }
    }

    public double getLongitude()
    {

        return longitude;
    }

    public String coordenadaPolarLatitude()
    {
        if(latitude>0)
        {
            return "Norte";
        }
        else if(latitude<0)
        {
            return "Sul";
        }
        else
        {
            return " ";
        }
    }

  /**
   * 
    public String coordenadaPolarLatitudeWhile()
    {
        switch( latitude)
        {
            case latitude>0.0:
            return "Norte";
            break;
            case latitude<0.0:
            return "Sul";
            break;
            case latitude=0.0:
            return "";
            break;
            default:
            return "";
            break;

        }
    }
    */

    public String coordenadaPolarLongitude()
    {
        if(longitude>0)
        {
            return "Este";
        }
        else if(longitude<0)
        {
            return "Oeste";
        }
        else
        {
            return"";
        }
    }

    public double getLatitude()
    {

        return latitude;
    }

    @Override
    public String toString()
    {
        String inf="";
        inf+= "Posiçao: \n"+
        getLongitude() + " "+coordenadaPolarLongitude()+
        getLatitude() + " "+coordenadaPolarLatitude()+"\n";
        return inf;
        
        

    }
}
