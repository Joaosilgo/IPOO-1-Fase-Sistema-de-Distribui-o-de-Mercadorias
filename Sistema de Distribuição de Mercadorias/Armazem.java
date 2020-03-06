
/**
 * Write a description of class Armazem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armazem{
    
    private  PacksDeBens[] armazem;

    /**
     * Constructor,creates a new store with a certain dimension.
     */
    public Armazem(int dimensao)
    {
        armazem = new  PacksDeBens[dimensao];
    }

    
    public PacksDeBens[] getArmazem()
    {
        PacksDeBens[] a;
        a=armazem;
        return a;
    }
    /**
     * Method to count the number of products in the store.
     * @return a: products in the store.
     */
    private int countProducts()
    {
       int a=0;
        for(int i=0 ;i<armazem.length; i++)
        {
            if(armazem[i]!=null)
            {
                a++;
            }
        }
        return a;
    }
    private int getDimensao()
    {
       int i=armazem.length;
        return i ;
    }
    public boolean isFull()
    {
        if(this.countProducts()==this.getDimensao())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Method to put products in the store, 
     */
    public void receiveProducts(PacksDeBens bens )
    {
        for(int i=0 ;i<armazem.length; i++)
        {
            if(bens!=null)
            {
                if(armazem[i].getCodigoDoProduto()==bens.getCodigoDoProduto())
                {
                    armazem[i].addQuantity( bens.getQuantity());
                }
                else if(armazem[i]==null)
                {
                    armazem[i]=bens;
                }
            }
            
        }
    }
    
}
