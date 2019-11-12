package victor.training.jpa.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import victor.training.jpa.app.domain.entity.ErrorLog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Service
public class Playground {
    public static final Logger log = LoggerFactory.getLogger(Playground.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void firstTransaction() {
        log.debug("Halo!");
        ErrorLog errorLog = new ErrorLog("buba");
        errorLog.setId(1l);
        em.persist(errorLog);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void secondTransaction() {
        log.debug("Halo2!");
    }
}

