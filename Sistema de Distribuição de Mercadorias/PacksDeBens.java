
/**
 *Os bens existentes devem ser representados em conjuntos (packs) 
 *onde se definem o código do produto (um número inteiro),
 *o name, a quantity, o peso unitário (em Kg) e o volume unitário (em cm3).
 * 
 * @author (João Gomes, Gonçalo Marques) 
 * @version (09-01-2017)
 */
public class PacksDeBens
{

    private int codeOfProduct;
    private String name;
    private int quantity;
    private double unitaryWeight;// kg
    private double unitaryVolume; //(em cm3).
   /**
    * create a Pack off Goods with certain name, certain quantity
    * ,certain certain, and volume
    */
    public PacksDeBens(String name,int quantity,int codeOfProduct,double unitaryWeight, double unitaryVolume)
    {
        this.name=validateString(name);
        this.quantity=validateInteger(quantity);
        this.codeOfProduct=validateInteger(codeOfProduct);
        this.unitaryWeight=validateDouble( unitaryWeight);
        this.unitaryVolume= validateDouble(unitaryVolume);
    }

    /**
     * Validate a String
     * @return : product Name or empty String to validate
     * @productName : String of textual designation of a product
     */
    private String validateString( String productName)
    {
        if(productName!= null)
        {
            return productName;
        }
        else
        {
            return "";
        }
    }

    /**
     * Validate a Integer
     * @return : i if superior or equal to 1 or zero just to validate
     * @i : Integer
     */
    private int validateInteger(int i)
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
     * Validate a Double 
     * @return : i if superior  0 or zero just to validate
     * @i : Integer
     */
    private double validateDouble(double i)
    {
        if(i>0)
        {
            return i;
        }
        else
        {
            return 0;
        }
    }
    /**
     * return codigo do producto 
     * @return : codeOfProduct an integer 
     */
    public int getCodigoDoProduto()
    {

        return codeOfProduct;
    }
    /**
     * return quantity of product
     * @return quantity an integer
     * 
     */
    public int getQuantity()
    {

        return quantity;
    }
    /**
     * return the name of a product
     * @ return a string 
     */
    public String getName()
    {

        return name;
    }
    /**
     * return the weight per product in kg
     * return double unitaryWeight
     */
    public double getUnitaryWeight()
    {

        return unitaryWeight;
    }
     /**
     * return the volume per product in cm^3
     * return double unitaryVolume
     */
    public double getUnitaryVolume()
    {

        return unitaryVolume;
    }
 /**
  * increment quantity by one 
  * 
  */
    public void incrementQuantity()
    {
        quantity++;
    }
/**
 * increment quantity with the valor of the argument
 * @param : quantity an integer
 */
    public void addQuantity(int quantity)
    {
        this.quantity+=quantity;
    }
/**
 * remove quantity and dont let the attribute be negative
 * @param : quantity an integer
 * 
 */
    public void removeQuantity(int quantity)
    {
        if(this.quantity>=quantity)
        {
            this.quantity-=quantity;
        }
        else
        {
            System.out.println("Nao pode diminuir a quantity requerida");
        }
    }
}
