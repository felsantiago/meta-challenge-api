package br.com.challenge.meta.exception;

/**
 * Class that implements DuplicateStatisticsException in the API
 * 
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class DuplicateStatisticsException extends Exception {

	private static final long serialVersionUID = 6082551323004629906L;
	
	public DuplicateStatisticsException(){
		super();
	}
	
	public DuplicateStatisticsException(String msg){
		super(msg);
	}
	
	public DuplicateStatisticsException(String msg, Throwable cause){
		super(msg, cause);
	}

}
