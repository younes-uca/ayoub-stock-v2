package ma.zsmart.stocky.zynerator.process;

import ma.zsmart.stocky.zynerator.audit.AuditBusinessObject;

public interface AbstractProcess<I extends AbstractProcessInput, K extends AbstractProcessOutput, T extends AuditBusinessObject> {
    Result<I, K, T> execute(I input);
}
