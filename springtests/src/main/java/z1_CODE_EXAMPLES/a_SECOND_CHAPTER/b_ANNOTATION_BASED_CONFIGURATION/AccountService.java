package z1_CODE_EXAMPLES.a_SECOND_CHAPTER.b_ANNOTATION_BASED_CONFIGURATION;


public interface AccountService {
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount);
	public void depositMoney(long accountId, double amount) throws Exception;
	public Account getAccount(long accountId);
}
