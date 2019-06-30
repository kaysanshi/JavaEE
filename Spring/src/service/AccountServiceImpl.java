package service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.support.TransactionTemplate;

import dao.AccountDao;
//注解可以直接加到类上，然后这些下面的方法都会使用，如果哪一个要改变则在下面的对应的方法上覆盖这上面的然后修改覆盖；
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {

	private AccountDao ad ;
	private TransactionTemplate tt;
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from,final Integer to,final Double money) {
				//减钱
				ad.decreaseMoney(from, money);
				int i = 1/0;
				//加钱
				ad.increaseMoney(to, money);
	}

/*	@Override
	public void transfer(final Integer from,final Integer to,final Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//减钱
				ad.decreaseMoney(from, money);
				int i = 1/0;
				//加钱
				ad.increaseMoney(to, money);
			}
		});
		
		
	}
*/
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	
	

}
