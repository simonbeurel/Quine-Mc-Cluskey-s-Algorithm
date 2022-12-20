import java.util.*;
public class MintermCategory extends ArrayList {



    /**
     * It computes the list of minterms m, such that :
     * - either m results from  merging a minterm from the category "this" with a minterm from the other category ;
     * - either m belongs to the current category (this) and could not be unified with a minterm of the other category
     * @param otherCategory
     * @return  the list of merged minterms
     */
    public List merge(MintermCategory otherCategory){
        List result = new ArrayList<>();

        for(int i=0; i!=this.size(); i++){
            for(int u =0; u!=otherCategory.size(); u++){
                Minterm mt = (Minterm) this.get(i);
                Minterm mt2 = (Minterm) otherCategory.get(u);
                Minterm mt3 = mt.merge(mt2);
                if(mt3 != null) result.add(mt3);
            }
        }
        return result;
    }

}
