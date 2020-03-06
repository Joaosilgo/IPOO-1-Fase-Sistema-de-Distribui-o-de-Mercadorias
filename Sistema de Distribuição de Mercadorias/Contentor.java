
/**
 * Os contentores armazenam os packs de bens a transportar e 
 * devem guardar informação da sua capacidade e da sua carga. 
 * Considere que cada contentor pode levar até 22000Kg de carga com,
 * no máximo, 33 m3 de capacidade cúbica.
 * A aplicação deve garantir que a carga nunca excede qualquer destes valores.
 * 
 * @author (João Gomes, Gonçalo Marques) 
 * @version (09-01-2017)
 */
public class Contentor
{

    private int idContentor;
    private boolean canCarry;
    private final int capacityPacks=10;// 10 max
    private double spaceOccupy;// cm^3
    private double freeSpace;// cm^3
    private double cargoWeight;//Kg
    private double disponibleWeight;//Kg
    private final int  maxWeight=22000;
    private final double maxSpace=33;
    private int index;
    //private PacksDeBens pack;
    private PacksDeBens[] packs;
/**
 *  Create a contentor that have a id,  maxWeight, canCarry begin at true , spaceOccupy at 0,
 *  
 */
    public Contentor(int idContentor)
    {
        this.idContentor=validarInteger( idContentor);

        this.disponibleWeight=maxWeight;

        this.freeSpace=maxSpace;

        this.canCarry=true;

        this.spaceOccupy=0;
        this.packs= new PacksDeBens[capacityPacks];
        this.index=0;

        this.index=0;
    }
    /**
     * return idContentor a integer that identify the container
     */
    public int getIdContentor()
    {
        return idContentor;
    }
    /**
     * validate an Integer that comes by argument as to be superior or equal to 1
     * return a integer i or 0 to validate
     */
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
     * switch the value boolean in attribute canCarry
     */
    public void switchCanCarry()
    {
        canCarry=!canCarry;
    }
/**
 *   return the value of canCarry
 */
    public boolean isCanCarry()
    {
        return canCarry;
    }
    /**
     * receive a good in argument , validate some attributes and add 
     */
    public void receberBem(PacksDeBens bens)

    {
        // querem um array de packs para guardar mais que um num contentor?
        if(canCarry==true)
        {
            if(bens!= null)
            {
                if(index<packs.length-1)
                {
                    if(disponibleWeight>=bens.getUnitaryWeight())
                    {
                        if(freeSpace>=bens.getUnitaryVolume())
                        {
                            packs[index]=bens;
                            index++;
                            disponibleWeight-=bens.getUnitaryWeight();
                            this.cargoWeight+=bens.getUnitaryWeight();
                            freeSpace-=bens. getUnitaryVolume();
                            spaceOccupy+=bens. getUnitaryVolume();
                        }
                        else
                        {
                            System.out.println("O contentor nao pode levar mais, bens espaço isuficiente);");
                        }

                    }
                    else
                    {
                        System.out.println("O contentor nao pode levar mais peso);");
                    }
                }
                else
                {
                    System.out.println("capacidade do contentor insuficiente");
                }
            }
            else
            {
                System.out.println("bens esta a null");
            }
        }
        else
        {
            System.out.println("variavel canCarry esta a false");
        }
    }
    public void descarregarContentorCompleto()
    {
        

        this.disponibleWeight=maxWeight;

        this.freeSpace=maxSpace;

        this.canCarry=true;

        this.spaceOccupy=0;
        this.packs= new PacksDeBens[capacityPacks];
        this.index=0;

        this.cargoWeight=0;
    }
    public PacksDeBens[] getPacks()
    {
        return packs;
    }
    public int countProducts()
    {
       int a=0;
        for(int i=0 ;i<packs.length; i++)
        {
            if(packs[i]!=null)
            {
                a++;
            }
        }
        return a;
    }
}
