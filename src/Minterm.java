import java.lang.reflect.Array;
import java.util.*;
public class Minterm {

    private ArrayList<Integer> combination = new ArrayList<>();
    private boolean marked = false;
    private String binaire ="";
    /**
     *
     * @param decimal   the decimal number for which we want to calculate the number of bits necessary to represent it
     * @return          the minimum number of bits needed to encode this decimal in binary.
     */
    public static int numberOfBitsNeeded(int decimal) {
        String binaire = Integer.toBinaryString(decimal);
        return binaire.length();
    }

    /*********************************************************
     * Management of the minterms structure
     ******************************************************** */


    /**
     * returns all the numbers that were used to build this minterm.
     * For example, [0*00] may have been created from 0 and 2 (* = -1)
     * @return all the numbers that were used to build this minterm.
     */
    public ArrayList<Integer> getCombinations() {
        return this.combination;
    }



    /**
     * marks the minterm as used to build another minTerm
     */
    public void mark(){
        this.marked = true;
    }

    /**
     *
     * @return true if the minterm has been used to build another minterm, false otherwise.
     */
    public boolean isMarked(){
        return this.marked;
    }

    public String getBinaire(){
        return this.binaire;
    }

    /*********************************************************
     * Management of the minterms contents
     ******************************************************** */
    /**
     *
     * @return return the number of 0 in the minterm
     */
    public int numberOfZero() {
        int ret = 0;
        for(int i =0; i!= this.getBinaire().length(); i++){
            if(this.getBinaire().charAt(i)=='0') ret++;
        }
        return ret;
    }

    /**
     *
     * @return return the number of 1 in the minterm
     */
    public int numberOfOne() {
        int ret = 0;
        for(int i =0; i!= this.getBinaire().length(); i++){
            if(this.getBinaire().charAt(i)=='1') ret++;
        }
        return ret;
    }



    /*********************************************************
     * Equality
     ******************************************************** */

    /**
     * @param o
     * @return true if the representation in base 2 is the same. Ignore the other elements.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Minterm){
            Minterm mt = (Minterm) o;
            if(mt.getBinaire().equals(this.getBinaire())) return true;
            else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }



/* -------------------------------------------------------------------------
        Constructors
 ------------------------------------------------------------------------- */
    /**
     * Construct a minterm corresponding to the decimal passed in parameter
     * and encode it on the given number of bits.
     * The associated combination then contains decimal.
     * @param decimal       the decimal value representing the minterm
     * @param numberOfBits  the number of bits of encoding of the decimal
     */
    public Minterm(int decimal, int numberOfBits) {
        this.combination.add(decimal);
        this.binaire = Integer.toBinaryString(decimal);
        while(binaire.length()!=numberOfBits){
            this.binaire = "0"+this.binaire;
        }
    }


    /**
     * Builds a minterm from its representation in binary which can contain -1.
     * This constructor does not update the associated combinations.
     * The size of the binary representation corresponds to the number of parameters (binary.length).
     * @param binary
     */
    protected Minterm(int... binary) {
        for(int i : binary){
            if(i == -1){
                this.binaire+="-";
            }else{
                this.binaire+= String.valueOf(i);
            }

        }
        //this.combination.add(Integer.parseInt(binaire,2));
    }

    public Minterm(ArrayList<Integer> combination, String binaire){
        this.combination = combination;
        this.binaire = binaire;
        this.marked = false;
    }



    /**
     * Compute the string showing the binary form of the minterm.
     * For example, "101" represents the minterm corresponding to 5,
     * while "1-1" represents a minterm resulting, for example from the merge of 5 and 7 (1 -1 1)
     * @return the string
     */
    @Override
    public String toString() {
        return this.getBinaire();
    }



/* -------------------------------------------------------------------------
        Binary <-> Decimal
 ------------------------------------------------------------------------- */

    /**
     * Calculates the integer value of the binary representation.
     * But in case one of the binary elements is -1, it returns -1.
     * This method is private because it should not be used outside this class.
     * @returns the value of the minterm calculated from its binary representation.
     */
    private int toIntValue(){
        if (this.getBinaire().contains("-")) return -1;
        else return Integer.parseInt(this.getBinaire(),2);
    }


   /* -------------------------------------------------------------------------
        Merge
 ------------------------------------------------------------------------- */


    /**
     * create a Minterm from the merge of two Minterms when it is posssible otherwise return null
     * Attention two minterms can only be merged if
     *  - they differ by one value at most.
     *  - they are of the same size.
     *  If a merge is possible, the returned minterm
     *  - has the same binary representation as the original minterm, but where at most one slot has been replaced by -1,
     *  - and it has, for the combinations, the merge of the combinations of both minterms this and other)
     *  - and the both mindterms  this and other are marked
     * @param other is another Minterm which we try to unify
     * @return a new Minterm when it is possible to unify, else null * @param other is another Minterm which we try to merge
     * @return a new Minterm when it is possible to merge, else null
     */
    public Minterm merge(Minterm other) {
        if(other.getBinaire().length() != this.getBinaire().length()){
            return null;
        }else{
            String binaire2 = other.getBinaire();
            int diff = 0; String binaire3 = "";
            for(int i=0; i!= binaire2.length(); i++){
                if(this.getBinaire().charAt(i)!=binaire2.charAt(i)){
                    diff++;
                    binaire3+="-";
                }else{
                    binaire3+=binaire2.charAt(i);
                }
            }
            if(diff >1){
                return null;
            }else{
                this.mark();
                other.mark();
                ArrayList<Integer> combinaison = new ArrayList<>();
                combinaison.addAll(this.getCombinations());
                combinaison.addAll(other.getCombinations());
                return new Minterm(combinaison, binaire3);
            }
        }
    }


}