package br.ufg.inf.fabrica.persistencia;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.openehr.rm.datatypes.basic.DvBoolean;

import java.util.UUID;

/**
 * Testes com DvBoolean.
 */
public class DvBooleanRepositoryTest extends TestCase {

    private DataValueRepository repo;

    @Override
    public void setUp() {
        // Obtém repositório

        repo = new DataValueRepositoryRam();
    }

    public void testDvBooleanTrue() {
        DvBoolean b = new DvBoolean(true);

        String key = UUID.randomUUID().toString();

        repo.save(key, b);

        Assert.assertEquals(b, repo.get(key));
    }

    public void testDvBooleanFalse() {
        DvBoolean b = new DvBoolean(false);

        String key = UUID.randomUUID().toString();

        repo.save(key, b);

        Assert.assertEquals(b, repo.get(key));
    }
}
