
package software.credible.mcfinder.remote.dto;

import java.util.ArrayList;
import java.util.List;


public class Data {

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<MarvelCharacter> marvelCharacters = new ArrayList<MarvelCharacter>();


    /**
     * 
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The marvelCharacters
     */
    public List<MarvelCharacter> getMarvelCharacters() {
        return marvelCharacters;
    }

    /**
     * 
     * @param marvelCharacters
     *     The marvelCharacters
     */
    public void setMarvelCharacters(List<MarvelCharacter> marvelCharacters) {
        this.marvelCharacters = marvelCharacters;
    }





}
