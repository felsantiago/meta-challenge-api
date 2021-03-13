package br.com.challenge.meta.util;

import lombok.NoArgsConstructor;

/**
 * Class that implements the Meta Java API utility methods.
 * 
 * @author Mariana Azevedo
 * @since 28/03/2020
 */
@NoArgsConstructor
public class MetaApiUtil {
	
	/**
	 * Field to represent API version on the requests/responses header
	 */
	public static final String HEADER_META_API_VERSION = "meta-api-version";
	
	/**
	 * Field to represent API key on the requests/responses header
	 */
	public static final String HEADER_API_KEY = "X-api-key";
	
	/**
	 * Field to represent API Rate Limit Remaining on the requests/responses header
	 */
	public static final String HEADER_LIMIT_REMAINING = "X-Rate-Limit-Remaining";
    
	/**
	 * Field to represent API Rate Limit Retry After Seconds on the requests/responses header
	 */
	public static final String HEADER_RETRY_AFTER = "X-Rate-Limit-Retry-After-Seconds";
	
}
