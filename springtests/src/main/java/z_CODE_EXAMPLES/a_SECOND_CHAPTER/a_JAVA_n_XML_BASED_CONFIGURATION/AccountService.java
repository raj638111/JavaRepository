package z_CODE_EXAMPLES.a_SECOND_CHAPTER.a_JAVA_n_XML_BASED_CONFIGURATION;


public interface AccountService {
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount);
	public void depositMoney(long accountId, double amount) throws Exception;
	public Account getAccount(long accountId);
}
