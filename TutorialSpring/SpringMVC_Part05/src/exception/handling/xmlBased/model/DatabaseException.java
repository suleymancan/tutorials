/**
 * 
 */
package exception.handling.xmlBased.model;

/**
 * @author suleymancan Mar 22, 2018
 */
public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public DatabaseException(String errCode, String errMsg) {

		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public DatabaseException() {
		super();
	}

}
