package concert;

/**
 * Created on 14.04.2017.
 * Implementation of abstract critic
 * @see CriticismEngine
 * @author Artemis A. Sirosh
 */
public class CriticismEngineImpl implements CriticismEngine {

    private String[] criticismPool;

    public CriticismEngineImpl() {
        // no - op
    }

    @Override
    public String getCriticism() {
        int index = (int) (Math.random() * criticismPool.length);
        return criticismPool[index];
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
