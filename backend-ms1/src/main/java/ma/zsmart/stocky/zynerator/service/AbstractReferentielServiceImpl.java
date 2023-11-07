package ma.zsmart.stocky.zynerator.service;

import ma.zsmart.stocky.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zsmart.stocky.zynerator.criteria.BaseCriteria;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
