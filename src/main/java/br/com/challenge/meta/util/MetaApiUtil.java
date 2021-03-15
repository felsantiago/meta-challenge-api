package br.com.challenge.meta.util;

import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.dto.response.Response;
import br.com.challenge.meta.enumeration.RoleEnum;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class that implements the Meta Java API utility methods.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
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
