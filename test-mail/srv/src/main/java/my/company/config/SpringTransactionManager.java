package my.company.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.sap.cds.transaction.TransactionManager;

@Component
public class SpringTransactionManager implements TransactionManager {
    private PlatformTransactionManager ptm;

    public SpringTransactionManager(PlatformTransactionManager ptm) {
        this.ptm = ptm;
    }

    @Override
    public boolean isActive() {
        return TransactionSynchronizationManager.isActualTransactionActive();
    }

	@Override
	public void setRollbackOnly() {
		// TODO Auto-generated method stub
		
	}
}