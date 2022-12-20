public class Minterm {
    /**
     *
     * @param decimal   the decimal number for which we want to calculate the number of bits necessary to represent it
     * @return          the minimum number of bits needed to encode this decimal in binary.
     */
    public static int numberOfBitsNeeded(int decimal) {
        return 0;
    }

    /*********************************************************
     * Management of the minterms structure
     ******************************************************** */


    /**
     * returns all the numbers that were used to build this minterm.
     * For example, [0*00] may have been created from 0 and 2 (* = -1)
     * @return all the numbers that were used to build this minterm.
     */
    public Collection getCombinations() {
        return new HashSet<>();
    }



    /**
     * marks the minterm as used to build another minTerm
     */
    public void mark(){

    }

    /**
     *
     * @return true if the minterm has been used to build another minterm, false otherwise.
     */
    public boolean isMarked(){
        return false;
    }

    /*********************************************************
     * Management of the minterms contents
     ******************************************************** */
    /**
     *
     * @return return the number of 0 in the minterm
     */
    public int numberOfZero() {
        return -1;
    }

    /**
     *
     * @return return the number of 1 in the minterm
     */
    public int numberOfOne() {
        return -1;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minterm minterm = (Minterm) o;
        return this == o;
    }

    @Override
    public int hashCode() {
        return 0;
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
    }


    /**
     * Builds a minterm from its representation in binary which can contain -1.
     * This constructor does not update the associated combinations.
     * The size of the binary representation corresponds to the number of parameters (binary.length).
     * @param binary
     */
    protected Minterm(int... binary) {
    }



    /**
     * Compute the string showing the binary form of the minterm.
     * For example, "101" represents the minterm corresponding to 5,
     * while "1-1" represents a minterm resulting, for example from the merge of 5 and 7 (1 -1 1)
     * @return the string
     */
    @Override
    public String toString() {
        return "";
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
    public int toIntValue(){
        int res = 0;
        return res;
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
        return null;
    }

}