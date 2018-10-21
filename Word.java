
package dictionarys;

public class Word {
    private String Word_target;
    private String Word_explain;
    public Word(String Word_target,String Word_explain) {
        this.Word_target=Word_target;
        this.Word_explain=Word_explain;
    }

    /**
     * @return the Word_target
     */
    public String getWord_target() {
        return Word_target;
    }

    /**
     * @param Word_target the Word_target to set
     */
    public void setWord_target(String Word_target) {
        this.Word_target = Word_target;
    }

    /**
     * @return the Word_explain
     */
    public String getWord_explain() {
        return Word_explain;
    }

    /**
     * @param Word_explain the Word_explain to set
     */
    public void setWord_explain(String Word_explain) {
        this.Word_explain = Word_explain;
    }
    
}
